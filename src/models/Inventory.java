package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe para a gestao de produtos e descontos
 */
public class Inventory implements Serializable {
    ArrayList<Product> products = new ArrayList<Product>();
    ArrayList<Discount> discounts = new ArrayList<Discount>();

    /**
     *
     * @param products Lista dos produtos
     */
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    /**
     *
     * @param discounts Lista de descontos
     */
    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
    /**
     * Metodo que devolve os dados de um produto fornecido o seu identificador
     * @param id Identificador
     * @return Produto associado
     */
    public Product getProductfromId(int id){
        for (Product prod:products) {
            if (prod.identifier == id){
                return prod;
            }
        }
        return null;
    }
    /**
     *
     * @return Lista dos produtos
     */
    public ArrayList<Product> getProducts() {
        return products;
    }
    /**
     *
     * @return Lista dos descontos
     */
    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

}
