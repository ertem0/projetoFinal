package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Discounts implements Serializable {
    private ArrayList<Discount> discounts;

    public Discounts() {
        this.discounts = new ArrayList<Discount>();
    }

    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }

    public void removeDiscount(Discount discount){
        this.discounts.remove(discount);
    }

    public void updateDiscount(Discount discount){
        this.discounts.set(this.discounts.indexOf(discount), discount);
    }

    public Discount getDiscount(int index){
        return this.discounts.get(index);
    }

    public int getSize(){
        return this.discounts.size();
    }

    public ArrayList<Discount> getdiscounts() {
        return discounts;
    }

    public void setdiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}