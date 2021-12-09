package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe para a implementacao de funcionalidades
 */
public class ProductsList implements Serializable {
    private ArrayList<Product> products;

    /**
     * Inicializa a lista de produtos
     */
    public ProductsList() {
        this.products = new ArrayList<Product>();
    }

    /**
     * Adiciona produtos a lista
     * @param product Produto a adicionar
     */
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

    /**
     *
     * @return Lista de produtos
     */
    public ArrayList<Product> getproducts() {
        return products;
    }

    public void setproducts(ArrayList<Product> products) {
        this.products = products;
    }
}
