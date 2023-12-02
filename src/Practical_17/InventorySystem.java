/**
 * InventorySystem class
 * This class is used to manage the orders
 * It has methods to place, update, cancel and track orders
 * It also has a method to print orders with a specified status
 * It has a HashMap to store the orders
 * It has a constructor to initialize the HashMap
 * It has getter and setter methods for the HashMap
 * It has a method to place an order
 * It has a method to update an order
 * It has a method to cancel an order
 * It has a method to track an order
 * It has a method to print orders with a specified status
 */
package Practical_17;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    // HashMap to store the orders
    private Map<Integer, Order> orders;
    // Constructor to initialize the HashMap
    public InventorySystem() {
        this.orders = new HashMap<>();
    }
    // method to place an order
    public void placeOrder(Order order) {
        orders.put(order.getId(), order);
    }
    // method to update an order
    public void updateOrder(Integer id, String product_name,
                            Double product_price, Integer quantity, Order.Status status) {
        if (!orders.containsKey(id)) {
            System.out.println("Order not found\n");
            return;
        }
        Order Order = orders.get(id);
        System.out.println(orders.get(id));
        Order.setProduct_name(product_name);
        Order.setProduct_price(product_price);
        Order.setQuantity(quantity);
        Order.setStatus(status);
        System.out.println("Order " + id + " updated successfully\n");
        System.out.println("Updated order details:");
        System.out.println(orders.get(id));
    }
    // method to cancel an order
    public void cancelOrder(Integer id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
            System.out.println("Order " + id + " cancelled successfully\n");
        } else {
            System.out.println("Order not found\n");
        }
    }
    // method to track and print an order
    public void trackOrder(Integer id) {
        if (orders.containsKey(id)) {
            System.out.println(orders.get(id) + "\n");
        } else {
            System.out.println("Order not found\n");
        }

    }
    // method to print orders with a specified status
    public void printOrdersWithStatus(Order.Status status) {
        System.out.println("Orders with status: " + status + ":");
        boolean found = false;

        for (Order order : orders.values()) {
            if (order.getStatus() == status) {
                System.out.println(order);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No orders with the specified status.\n");
        }
    }
    // getter method for the HashMap
    public Map<Integer, Order> getOrders() {
        return InventorySystem.this.orders;
    }
}
