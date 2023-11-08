package ProductCatalog.System;

import ProductCatalog.Exceptions.ProductNotFoundException;
import ProductCatalog.Persistence.ConnectionDB;
import ProductCatalog.Persistence.DaoProduct;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LogicalSystem implements LogicalSystemInterface {

    private Map<Integer, Product> products;
    private Map<Integer, Product> newProductsToDb;
    private int idCounter = 1;
    DaoProduct daoProduct = new DaoProduct();

    public LogicalSystem() throws SQLException {
        this.products = new HashMap<>();
        this.newProductsToDb = new HashMap<>();
        recoverData();
        idUptade();
    }

    @Override
    public void idUptade() {
        int productWithMaxId = 1;
        for(Product p : products.values()) {
            if(p.getId() >= productWithMaxId) {
                productWithMaxId = p.getId()+1;
            }
        }
        idCounter = productWithMaxId;
    }

    @Override
    public String saveData() throws SQLException {
        String resultOperation;
        if(!newProductsToDb.isEmpty()) {
            daoProduct.saveAllProducts(newProductsToDb);
            newProductsToDb.clear();
            resultOperation = "Products saved successfully!";
        } else {
            resultOperation = "The database is up to date!";
        }
        return resultOperation;
    }

    @Override
    public void recoverData() throws SQLException {
        this.products = daoProduct.recoverAllProducts();
    }

    @Override
    public void registerProduct(String name, TypeProduct typeProduct, double price) {
        Product newProduct = new Product(idCounter, name, typeProduct, price);
        products.put(idCounter, newProduct);
        newProductsToDb.put(idCounter, newProduct);
        idCounter++;
    }

    @Override
    public Map<Integer, Product> searchProductWithName(String name) {
        Map<Integer, Product> productsFound = new HashMap<>();
        for(Product p : products.values()) {
            if(p.getName().contains(name)) {
                productsFound.put(p.getId(), p);
            }
        }
        return productsFound;
    }

    @Override
    public void deleteProductById(int idProduct) throws ProductNotFoundException, SQLException {
        if(products.get(idProduct) != null) {
            products.remove(idProduct);
            daoProduct.deleteProduct(idProduct);
            idUptade();
        } else {
            throw new ProductNotFoundException("The product was not found!");
        }
        Map<Integer, Product> updatedProducts = new HashMap<>();

        for (Product p : products.values()) {
            updatedProducts.put(p.getId(), p);

        }
        products = updatedProducts;
    }

    @Override
    public String getNameProductById(int idProduct) throws ProductNotFoundException {
        if(products.get(idProduct) != null) {
            return products.get(idProduct).getName();
        } else {
            throw new ProductNotFoundException("The product was not found!");
        }
    }

    @Override
    public Map<Integer, Product> searchAllProducts() {
        return products;
    }

}