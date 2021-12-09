package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {
    private ArrayList<Product> products;

    public Products() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public void removeProduct(Product product){
        this.products.remove(product);
    }

    public void updateProduct(Product product){
        this.products.set(this.products.indexOf(product), product);
    }

    public Product getProduct(int index){
        return this.products.get(index);
    }

    public int getSize(){
        return this.products.size();
    }

    public ArrayList<Product> getproducts() {
        return products;
    }

    public void setproducts(ArrayList<Product> products) {
        this.products = products;
    }
}
