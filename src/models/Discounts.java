package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Classe para a implementacao de funcionalidades
 */
public class Discounts implements Serializable {
    private ArrayList<Discount> discounts;

    /**
     * Inicializa a lista dos descontos
     */
    public Discounts() {
        this.discounts = new ArrayList<Discount>();
    }

    /**
     * Adiciona o desconto a lista
     * @param discount Desconto
     */
    public void addDiscount(Discount discount){
        this.discounts.add(discount);
    }
    /**
     *
     * @return Desconto
     */
    public ArrayList<Discount> getdiscounts() {
        return discounts;
    }
}