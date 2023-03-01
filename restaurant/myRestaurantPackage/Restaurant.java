package restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
    
    private static final Scanner input = new Scanner(System.in);
    // main method, Starting point for our program 
    public static void main(String[] args) {
       
       
       
        // initial menu list
        menuListItems.add(new MenuItem("Spaghetti", 150.00));
        menuListItems.add(new MenuItem("Rice Chicken", 950.00));
        menuListItems.add(new MenuItem("Pilau", 200.00));
        menuListItems.add(new MenuItem("Coffee", 150.00));
        menuListItems.add(new MenuItem("Soda", 150.00));
        menuListItems.add(new MenuItem("Juice", 150.00));
        menuListItems.add(new MenuItem("Milo", 150.00));
        

        //bool to check if program is running
        boolean running = true;
        while (running) {
            System.out.println("Welcome to the restaurant menu!");
            System.out.println("1. View menu");
            System.out.println("2. Order food and drink");
            System.out.println("3. Add item to menu (Admins only)");
            System.out.println("4. Exit");

            int choice = input.nextInt();
            input.nextLine(); // consume the newline character

            switch (choice) {
                case 1 -> checkMenu();
                case 2 -> makeOrder();
                case 3 -> addItemToMenu();
                case 4 -> running = false; //return false to stop program
                default -> System.out.println("Invalid selection, please try again.");
            }
        }

        System.out.println("Thank you for visiting the restaurant!");
    }

    // List for storing menu items
    private static final ArrayList<MenuItem> menuListItems = new ArrayList<>();
    

    // Method to view the current menu items
    private static void checkMenu() {

        //use for loof to get every menu items
        for (MenuItem item : menuListItems) {
            System.out.println(item.getName() + " | Price Ksh." + item.getPrice());
        }
    }

    // Method to add a new item to the menu
    private static void addItemToMenu() {
        //get input from the user
        System.out.print("Enter item name: ");
        String itemName = input.nextLine();
        System.out.print("Enter item price: ");
        double itemPrice = input.nextDouble();
        input.nextLine();

        //Creating menu item object
        MenuItem newItemObj = new MenuItem(itemName, itemPrice);
        menuListItems.add(newItemObj);
        System.out.println(itemName + " added to menu menu list");
    }

   
    private static MenuItem findMenuItem(String name) {
        for (MenuItem item : menuListItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        // if item not available, return null
        return null; 
    }

    
    // Method to find
// Inner class representing a menu item
    private static class MenuItem {
        private final String name;
        private final double price;

        public MenuItem(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }


    }



 // Method to allow customer to order food and drink
 private static void makeOrder() {
    ArrayList<MenuItem> order = new ArrayList<>();
    double totalCost = 0;
    boolean gettingItems = true;

    while (gettingItems) {
        System.out.print("Enter item name (type \"0\" zero when done): ");
        String itemName = input.nextLine();

        if (itemName.equals("0")) {
            gettingItems = false;
        } else {
            MenuItem item = findMenuItem(itemName);
            if (item == null) {
                System.out.println("Item not found, please try again.");
            } else {
                order.add(item);
                totalCost += item.getPrice();
            }
        }
    }

    System.out.println("Order summary:");
    for (MenuItem item : order) {
        System.out.println(item.getName() + " | Price: Ksh. " + item.getPrice());
    }
    System.out.println("Total cost:" + totalCost);

    System.out.print("Enter payment amount: Ksh. ");
    double paymentAmount = input.nextDouble();
    input.nextLine();

    if (paymentAmount < totalCost) {
        System.out.println("Order cancelled [PAYMENT AMOUNT IS LESS THAN tOTAL COST]");
    } else {
        System.out.println("Payment received!");
    }
}
}
