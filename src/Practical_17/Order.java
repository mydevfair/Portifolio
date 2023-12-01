package Practical_17;
public class Order {
    public enum Status {
        Pending, Paid, Shipped, Delivered, Refunded
    }
    Integer id, quantity;
    String product_name;
    Double product_price;
    Status status;
    public Order(Integer id, String product_name, Double product_price, Integer quantity, Status status){
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product_name='" + product_name + '\'' +
                ", product_price=" + product_price +
                '}';
    }
}
