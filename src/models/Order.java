package models;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    Hashtable<Product, Integer> order = new Hashtable<Product, Integer>();
    Inventory inventory;
    Cliente cliente;

    public Order(Inventory inventory, Cliente cliente) {
        this.inventory = inventory;
        this.cliente = cliente;
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

    public double process_order(){
        double total = 0.0;
        Enumeration<Product> products = order.keys();
        Product currentProduct;
        Discount currentDiscount;
        while (products.hasMoreElements()){
            currentProduct = products.nextElement();
            currentDiscount = null;
            int quantity = order.get(currentProduct);
            for (Discount discount: inventory.discounts) {
                if(discount.getProduct().identifier==currentProduct.identifier){
                    currentDiscount=discount;
                }
            }
            if(currentDiscount==null){
                total += quantity * currentProduct.preco_p_un;
            }
            else if(currentDiscount.isDiscount_type()==true){
                int promo = quantity/4;
                total += (quantity-promo) * currentProduct.preco_p_un;
            }
            else if(currentDiscount.isDiscount_type()==false){
                total += (1-(quantity-1)*0.05)* quantity*currentProduct.preco_p_un;
            }
            if(currentProduct.is_mobilia()){
                Furniture furniture = (Furniture)currentProduct;
                if(furniture.peso>15){
                    total += 10*quantity;
                }
            }
        }
        return total;
    }

    public Hashtable<Product, Integer> getOrder() {
        return order;
    }
}
