package app.entity;

public class Order {
    private final int quota;
    private final double price;


    public Order(int quota, double price) {
        this.quota = quota;
        this.price = price;

    }

    public double getQuota() {
        return quota;
    }

    public double getPrice() {
        return price;
    }


}


