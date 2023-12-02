package Practical_17;

import java.text.NumberFormat;
import java.util.Locale;

public class Order {

    public enum Status {
        Pending, Paid, Shipped, Delivered, Refunded
    }
    private final Integer id;
    private Integer quantity;
    private String product_name;
    private Double product_price;
    private Status status;
    public Order(Integer id, String product_name, Double product_price, Integer quantity, Order.Status status){
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.status = status;
    }
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
