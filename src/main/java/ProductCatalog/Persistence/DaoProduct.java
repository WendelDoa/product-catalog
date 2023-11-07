package ProductCatalog.Persistence;

import ProductCatalog.System.Product;
import ProductCatalog.System.TypeProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DaoProduct {

    private final ConnectionDB connectionDB = new ConnectionDB();

    public void saveAllProducts(Map<Integer, Product> productsToSave) throws SQLException {
        Connection connection = connectionDB.getConnection();
        for(Product product : productsToSave.values()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO products (id, name, typeproduct, price) VALUES (?,?,?,?)");
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setString(3, product.getType().name());
            statement.setDouble(4, product.getPrice());
            statement.executeUpdate();
        }

    }

    public Map<Integer, Product> recoverAllProducts() throws SQLException {
        Connection connection = connectionDB.getConnection();
        Map<Integer, Product> productsRecovered = new HashMap<>();

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM PRODUCTS");
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Product product = new Product();
            product.setId(result.getInt("id"));
            product.setName(result.getString("name"));
            product.setPrice(result.getDouble("price"));
            String typeProductString = result.getString("typeProduct");
            product.setType(TypeProduct.valueOf(typeProductString));
            productsRecovered.put(product.getId(), product);
        }
        return productsRecovered;
    }

    public void deleteProduct(Integer idProduct) throws SQLException {
        Connection connection = connectionDB.getConnection();

        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE Id = ?");
        statement.setInt(1,idProduct);
        statement.executeUpdate();
    }
}
