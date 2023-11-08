package ProductCatalog.System;

import ProductCatalog.Exceptions.ProductNotFoundException;

import java.sql.SQLException;
import java.util.Map;

public interface LogicalSystemInterface {
    void idUptade();

    String saveData() throws SQLException;

    void recoverData() throws SQLException;

    void registerProduct(String name, TypeProduct typeProduct, double price);

    Map<Integer, Product> searchProductWithName(String name);

    void deleteProductById(int idProduct) throws ProductNotFoundException, SQLException;

    String getNameProductById(int idProduct) throws ProductNotFoundException;

    Map<Integer, Product> searchAllProducts();
}
