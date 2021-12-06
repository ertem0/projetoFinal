package models;

public class Discount {
    boolean discount_type; // true = pay 3 take 4, false = payless
    Product product;

    public Discount(boolean discount_type, Product product) {
        this.discount_type = discount_type;
        this.product = product;
    }

    public boolean isDiscount_type() {
        return discount_type;
    }

    public Product getProduct() {
        return product;
    }
}
