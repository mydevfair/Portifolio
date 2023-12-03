/*
 * File: User.java
 * Author: Chris Fairhurst
 * Date: December 2nd, 2023
 * Description: This file contains the implementation of an inventory system.
 *              It includes classes for Orders, InventorySystem, and a main method in the User class for testing.
 */
package Practical_17;
import java.text.NumberFormat;
import java.util.Locale;

public class User {
    /**
     * Method to calculate the total revenue of each inventory system
     * @param inventorySystem The inventory systems in user
     */
    public static void calculateTotalPrice(InventorySystem inventorySystem) {
        double totalPrice = 0.0;
        for (Order order : inventorySystem.getOrders().values()) {
            totalPrice += order.getProduct_price() * order.getQuantity();
        }
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        String formattedPrice = currencyFormatter.format(totalPrice);
        System.out.println("Total price of all orders: " + formattedPrice + "\n");
    }
    /**
     * Main method to test the inventory system
     * @param args Command line arguments
     */

    public static void main(String[] args) {
        // Create an inventory system
        InventorySystem inventorySystem1 = new InventorySystem();
        // Create some orders
        Order order1 = new Order(1, "Product 1", 100.0, 1, Order.Status.Pending);
        Order order2 = new Order(2, "Product 2", 200.0, 2, Order.Status.Paid);
        Order order3 = new Order(3, "Product 3", 300.0, 3, Order.Status.Shipped);
        Order order4 = new Order(4, "Product 4", 400.0, 4, Order.Status.Delivered);
        // Place the orders
        inventorySystem1.placeOrder(order1);
        inventorySystem1.placeOrder(order2);
        inventorySystem1.placeOrder(order3);
        inventorySystem1.placeOrder(order4);
        // Update an order
        inventorySystem1.updateOrder(1, "Product 1", 150.0, 1, Order.Status.Pending);
        // Cancel an order
        inventorySystem1.cancelOrder(3);
        // Track and print orders
        inventorySystem1.trackOrder(1);
        inventorySystem1.trackOrder(2);
        // Print orders with a specific status
        inventorySystem1.printOrdersWithStatus(Order.Status.Pending);
        inventorySystem1.printOrdersWithStatus(Order.Status.Paid);
        inventorySystem1.printOrdersWithStatus(Order.Status.Shipped);
        inventorySystem1.printOrdersWithStatus(Order.Status.Delivered);
        // Calculate the total price of all orders in inventory system
        calculateTotalPrice(inventorySystem1);
        // Create another inventory system
        InventorySystem inventorySystem2 = new InventorySystem();
        // Create some orders
        Order order5 = new Order(5, "Product 5", 500.0, 5, Order.Status.Pending);
        Order order6 = new Order(6, "Product 6", 600.0, 6, Order.Status.Paid);
        Order order7 = new Order(7, "Product 7", 700.0, 7, Order.Status.Shipped);
        Order order8 = new Order(8, "Product 8", 800.0, 8, Order.Status.Delivered);
        // Place the orders
        inventorySystem2.placeOrder(order5);
        inventorySystem2.placeOrder(order6);
        inventorySystem2.placeOrder(order7);
        inventorySystem2.placeOrder(order8);
        // Update an order
        inventorySystem2.updateOrder(5, "Product 5", 550.0, 5, Order.Status.Pending);
        // Cancel an order
        inventorySystem2.cancelOrder(7);
        //track and print orders
        inventorySystem2.trackOrder(5);
        inventorySystem2.trackOrder(6);
        // Print orders with a specific status
        inventorySystem2.printOrdersWithStatus(Order.Status.Pending);
        inventorySystem2.printOrdersWithStatus(Order.Status.Paid);
        inventorySystem2.printOrdersWithStatus(Order.Status.Shipped);
        inventorySystem2.printOrdersWithStatus(Order.Status.Delivered);
        // Calculate the total price of all orders in inventory system
        calculateTotalPrice(inventorySystem2);
    }

}
