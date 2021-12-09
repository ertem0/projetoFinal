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

    /**
     *
     * @return Desconto
     */
    public ArrayList<Discount> getdiscounts() {
        return discounts;
    }

    public void setdiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}