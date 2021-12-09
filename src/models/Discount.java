package models;

import java.io.Serializable;

public class Discount implements Serializable{
    boolean discount_type; // true = pay 3 take 4, false = payless
    int identifier;

    public Discount(boolean discount_type, int identifier) {
        this.discount_type = discount_type;
        this.identifier = identifier;
    }

    public boolean isDiscount_type() {
        return discount_type;
    }
}
