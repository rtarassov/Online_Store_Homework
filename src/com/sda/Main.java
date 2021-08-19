package com.sda;

import com.sda.products.AddableToCart;
import com.sda.products.ItemsInStock;
import com.sda.products.Product;
import com.sda.products.electrical_appliances.Manufacturer;
import com.sda.products.electrical_appliances.Radio;
import com.sda.products.electrical_appliances.Television;
import com.sda.products.readings.Books;
import com.sda.products.readings.Magazines;
import com.sda.shopping_cart.Cart;
import com.sda.user.User;

import java.util.Arrays;
import java.util.Scanner;

import static com.sda.products.ItemsInStock.getItemsInStore;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product[] itemsInStore = new Product[5000];

        /** Make new items for the store **/
        Radio fancyRadio = new Radio("Fancy Radio", 500, Manufacturer.SAMSUNG);
        Television cinematic = new Television("Curved TV", 1200, Manufacturer.LG);
        Books pipi = new Books("Pipi", 25);
        Magazines technology = new Magazines("Tech magazine", 7);

        /** Add the items to the store **/
        itemsInStore[0] = fancyRadio;
        itemsInStore[1] = fancyRadio;
        itemsInStore[2] = cinematic;
        itemsInStore[3] = cinematic;
        itemsInStore[4] = cinematic;
        itemsInStore[5] = pipi;
        itemsInStore[6] = pipi;
        itemsInStore[7] = pipi;
        itemsInStore[8] = pipi;
        itemsInStore[9] = pipi;
        itemsInStore[10] = technology;
        itemsInStore[11] = technology;
        itemsInStore[12] = technology;
        itemsInStore[13] = technology;

        /** Make a user **/
        System.out.println("To start, please create an account.");
        System.out.print("Enter your firstName: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your lastName: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your mobileNumber: ");
        String mobileNumber = scanner.nextLine();
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your city: ");
        String city = scanner.nextLine();
        System.out.print("Enter your streetName: ");
        String streetName = scanner.nextLine();
        System.out.print("Enter your postalcode: ");
        int postalCode = scanner.nextInt();
        System.out.print("Enter your emailAddress: ");
        String emailAddress = scanner.next();

        User userAccount = new User(firstName, lastName,
                mobileNumber,
                username, password,
                city, streetName, postalCode,
                emailAddress);
        Cart cart1 = new Cart();


        do {
            cart1.totalItems();
            displayMenu();
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    getItemsInStore(itemsInStore);
                    break;

                case 2:
                    //Add to cart
                    getItemsInStore(itemsInStore);
                    System.out.print("Choose product number to add to cart: ");
                    int chosenProductNumber = scanner.nextInt();
                    System.out.println("Choose how many to add: ");
                    int amountToAddToCart = scanner.nextInt();

                    if (cart1.totalItems() < 5 &&
                            amountToAddToCart + cart1.totalItems() <= 5) {
                        cart1.addToCart(itemsInStore[chosenProductNumber], amountToAddToCart);
                    } else {
                        System.out.println("Your cart will exceed the limit of 5 items.");
                        System.out.println("You still have room for: " + (5 - cart1.totalItems()
                        + " items."));
                    }
                    break;

                case 3:
                    // Remove from cart
                    // TODO: Kuidas teha user inputiga?
                    // Manuaalselt lihtne
                    // cart1.removeFromCart(fancyRadio, 0);
                    // Aga kuidas ma saan võtta user inputiga selle?

                    cart1.getCartProducts();
                    System.out.print("Choose product to remove from Cart: ");
                    // String prodToRemoveFromCart = scanner.next();
                    System.out.println("How many to remove from cart: ");
                    int amountToRemoveFromCart = scanner.nextInt();
                    // cart1.removeFromCart(prodToRemoveFromCart, amountToRemoveFromCart);
                    break;

                case 4:
                    cart1.getCartProducts();
                    break;

                case 5:
                    // TODO: CONFIRM PURCHASE
                    break;

                default:
                    System.out.println("Enter number 1 - 5 OR 0 to EXIT");
                    displayMenu();
            }
        } while (scanner.nextInt() != 0);



//        // For loop over itemsInStore -> if not enough items in store, don't add to cart!
//        // If enough, add to cart, remove from store items
//        cart1.addToCart(fancyRadio, 3);
//        cart1.addToCart(cinematic, 7);
//        try {
//            cart1.removeFromCart(fancyRadio, 0);
//        } catch (IllegalArgumentException e) {
//            System.out.println("ERROR Removing: Not enough items in cart");
//        }
//        cart1.getCartProducts();

    }
    public static void displayMenu() {
        System.out.println("1: Display items in stock");
        System.out.println("2: Add item to cart");
        System.out.println("3: Remove item from cart");
        System.out.println("4: Show items in cart");
        System.out.println("5: Confirm purchase.");
        System.out.println("0: EXIT");
    }
}
