package com.sda.products;

public abstract class Product {
    public int price;
    public String name;

    public Product(String name, int price) {
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(Price: " + price + ")";
    }
}
