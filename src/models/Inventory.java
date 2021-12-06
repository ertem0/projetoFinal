package models;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Discount> discounts = new ArrayList<Discount>();

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        for (Product prod : products) {
            if(product.identifier == prod.identifier) {
                return;
            }
        }
        products.add(product);
    }

    public void addDiscount(Discount discount) {
        if (discount == null) {
            return;
        }
        removeDiscountfromProduct(discount.product);
        discounts.add(discount);
    }

    public void removeDiscountfromProduct(Product product){
        for (Discount disc: discounts) {
            if (product == disc.product){
                discounts.remove(disc);
            }
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product getProductfromId(int id){
        for (Product prod:products) {
            if (prod.identifier == id){
                return prod;
            }
        }
        return null;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

}
