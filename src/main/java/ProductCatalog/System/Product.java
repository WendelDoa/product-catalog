package ProductCatalog.System;

public class Product {

    private int id;
    private String name;
    private TypeProduct typeProduct;
    private double price;

    public Product(int id, String name, TypeProduct typeProduct, double price) {
        this.id = id;
        this.name = name;
        this.typeProduct = typeProduct;
        this.price = price;
    }

    public Product() {
        this(0,"", null, 0.0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProduct getType() {
        return typeProduct;
    }

    public void setType(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
