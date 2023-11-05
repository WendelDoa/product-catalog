package ProductCatalog.System;

import ProductCatalog.Exceptions.ExceptionRegistrationError;

import java.util.HashMap;
import java.util.Map;

public class LogicalSystem {

    private Map<Integer, Product> products = new HashMap<>();
    private int idCounter = 1;

    public void registerProduct(String name, TypeProduct typeProduct, double price) {
        Product newProduct = new Product(idCounter, name, typeProduct, price);
        products.put(idCounter, newProduct);
        idCounter++;
    }

    public Map<Integer, Product> searchProductWithName(String name) {
        Map<Integer, Product> productsFound = new HashMap<>();
        for(Product p : products.values()) {
            if(p.getName().contains(name)) {
                productsFound.put(p.getId(), p);
            }
        }
        return productsFound;
    }

    public Map<Integer, Product> searchAllProducts() {
        return products;
    }
}
