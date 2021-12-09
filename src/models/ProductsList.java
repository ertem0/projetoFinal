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

    /**
     *
     * @return Lista de produtos
     */
    public ArrayList<Product> getproducts() {
        return products;
    }
}
