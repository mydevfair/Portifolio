package Practical_17;

import java.util.HashMap;
import java.util.Map;

public class InventorySystem {
    private Map<Integer, Order> orders;

    public InventorySystem() {
        this.orders = new HashMap<>();
    }

    public void placeOrder(Order order) {
        orders.put(order.getId(), order);
    }

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

    public void cancelOrder(Integer id) {
        if (orders.containsKey(id)) {
            orders.remove(id);
            System.out.println("Order " + id + " cancelled successfully\n");
        } else {
            System.out.println("Order not found\n");
        }
    }

    public void trackOrder(Integer id) {
        if (orders.containsKey(id)) {
            System.out.println(orders.get(id) + "\n");
        } else {
            System.out.println("Order not found\n");
        }

    }
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

    public Map<Integer, Order> getOrders() {
        return InventorySystem.this.orders;
    }
}
