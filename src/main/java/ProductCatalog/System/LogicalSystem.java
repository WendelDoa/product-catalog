package ProductCatalog.System;

import java.util.HashMap;
import java.util.Map;

public class LogicalSystem {

    private Map<Integer, Product> products = new HashMap<>();
    private int idCounter = 1;

    public void registerProduct(String name, Type type, double price) {
        Product newProduct = new Product(idCounter, name, type, price);
        products.put(idCounter, newProduct);
        idCounter++;
    }

    public Map<Integer, Product> searchAllProducts() {
        return products;
    }
}
