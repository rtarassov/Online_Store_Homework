package com.sda.shopping_cart;

import com.sda.products.AddableToCart;
import com.sda.products.Product;
import com.sda.products.electrical_appliances.Radio;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cart implements AddableToCart {

    Product[] productsInCart = new Product[1000];
    int currentAmountOfProducts = 0;
    @Override
    public void addToCart(Product product, int amountOfProduct) {
        for (int i = 0; i < amountOfProduct; i++) {
            productsInCart[currentAmountOfProducts] = product;
            currentAmountOfProducts++;
        }

    }

    @Override
    public void removeFromCart(Product product, int amount) throws IllegalArgumentException {
        int amt = 0;
        for (Product p : productsInCart) {
            if (p == product) {
                amt++;
            }
        }

        if (amt < amount) {
            throw new IllegalArgumentException("Can't remove more than you have");
        }
        int amountRemoved = 0;
        for (int i = 0; i < productsInCart.length; i++) {
            if (amountRemoved == amount) {
                break;
            }
            if (productsInCart[i] == product) {
                productsInCart[i] = null;
                amountRemoved++;
            }
        }
    }

    @Override
    public void getCartProducts() {

        Map<Product, Integer> prods = new HashMap();
        for (Product product : productsInCart) {
            if (product == null) continue;

            if (prods.containsKey(product)) {
                prods.replace(product, prods.get(product) + 1);
            } else {
                prods.put(product, 1);
            }
        }

        for (Product product : prods.keySet()) {
            System.out.println("Product: " + product + ", amount: " + prods.get(product) +
                    ", Total price: " + (product.price * prods.get(product)));
        }
        System.out.println("Amount of items: " + totalItems());
        System.out.println("Total cost: " + totalCost());
    }

    @Override
    public int totalCost() {
        int totalPrice = 0;
        for (Product product : productsInCart) {
            if (product != null) {
                totalPrice += product.price;
            }
        }
        return totalPrice;
    }

    @Override
    public int totalItems() {
        int items = 0;
        for (Product product : productsInCart) {
            if (product != null) {
                items ++;
            }
        }
        return items;
    }


}
