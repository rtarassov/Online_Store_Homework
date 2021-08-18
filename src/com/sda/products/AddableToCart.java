package com.sda.products;

public interface AddableToCart {
    void addToCart(Product product, int amountOfProduct);

    void removeFromCart(Product product, int amount);

    void getCartProducts();

    int totalCost();

    int totalItems();
}
