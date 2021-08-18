package com.sda;

import com.sda.products.AddableToCart;
import com.sda.products.Product;
import com.sda.products.electrical_appliances.Manufacturer;
import com.sda.products.electrical_appliances.Radio;
import com.sda.products.electrical_appliances.Television;
import com.sda.shopping_cart.Cart;
import com.sda.user.User;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Product[] itemsInStore = new Product[5000];
        // Make a user
        User user1 = new User("Richard", "Tarassov",
                "55544333",
                "rt", "1234",
                "Tamsalu", "Kastani", 41555,
                "r.t@hotmail.com");

        Radio fancyRadio = new Radio("Fancy Radio", 500, Manufacturer.SAMSUNG);
        Television cinematic = new Television("Curved TV", 1200, Manufacturer.LG);
        // Add the items to the store
        itemsInStore[0] = fancyRadio;
        itemsInStore[1] = fancyRadio;
        itemsInStore[2] = cinematic;
        itemsInStore[3] = cinematic;
        itemsInStore[4] = cinematic;

        Cart cart1 = new Cart();
        // For loop over itemsInStore -> if not enough items in store, don't add to cart!
        // If enough, add to cart, remove from store items
        cart1.addToCart(fancyRadio, 3);
        cart1.addToCart(cinematic, 7);
        try {
            cart1.removeFromCart(fancyRadio, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR Removing: Not enough items in cart");
        }
        cart1.getCartProducts();

    }
}
