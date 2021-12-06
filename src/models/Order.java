package models;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    Hashtable<Product, Integer> order = new Hashtable<Product, Integer>();
    Inventory inventory;

    public Order(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addProduct(int indentifier, int quantity) {
        for (Product product : inventory.getProducts()) {
            if (product.getIdentifier() == indentifier) {
                if (order.containsKey(product)) {
                    order.put(product, order.get(product) + quantity);
                } else {
                    order.put(product, quantity);
                }
            }
        }
    }

    public void removeProduct(int indentifier, int quantity) {
        for (Product product : inventory.getProducts()) {
            if (product.getIdentifier() == indentifier) {
                if (order.containsKey(product)) {
                    order.put(product, order.get(product) - quantity);
                    if (order.get(product) <= 0) {
                        order.remove(product);
                    }
                }
            }
        }
    }

    public void process_order(){
        int total = 0;

        for (int i = 0; i < order.size(); i++) {
            Product product = order.keys().;
        }

    }

    public Hashtable<Product, Integer> getOrder() {
        return order;
    }
}
