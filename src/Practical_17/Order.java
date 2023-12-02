/**
 * Class Order
 * This class is used to create an Order object
 * It has the following attributes:
 * 1. id: Integer
 * 2. quantity: Integer
 * 3. product_name: String
 * 4. product_price: Double
 * 5. status: Status
 * It has the following methods:
 * 1. getId(): Integer
 * 2. getQuantity(): Integer
 * 3. getProduct_name(): String
 * 4. getProduct_price(): Double
 * 5. getStatus(): Status
 * 6. setProduct_name(String productName): void
 * 7. setProduct_price(Double productPrice): void
 * 8. setQuantity(Integer quantity): void
 * 9. setStatus(Status status): void
 * 10. toString(): String
 */
package Practical_17;

import java.text.NumberFormat;
import java.util.Locale;

public class Order {
    // Enum to store the status of an order
    public enum Status {
        Pending, Paid, Shipped, Delivered, Refunded
    }
    // Attributes
    private final Integer id;
    private Integer quantity;
    private String product_name;
    private Double product_price;
    private Status status;
    // Constructor
    public Order(Integer id, String product_name, Double product_price, Integer quantity, Order.Status status){
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.status = status;
    }
    // Getter and setter methods
    public Integer getId() {
        return id;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public String getProduct_name() {
        return product_name;
    }
    public Double getProduct_price() {
        return product_price;
    }
    public Status getStatus() {
        return status;
    }
    public void setProduct_name(String productName) {
        this.product_name = productName;
    }
    public void setProduct_price(Double productPrice) {
        this.product_price = productPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    // toString() method
    @Override
    public String toString() {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
        String formattedPrice = currencyFormatter.format(product_price);
        String sb = "Order ID: "
                + id + "\nProduct Name: " + product_name +
                "\nProduct Quantity: " + quantity +
                "\nProduct Price: " + formattedPrice +
                "\nProduct Status: " + status + "\n";

        return sb;
    }
}
