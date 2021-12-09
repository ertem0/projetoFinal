package models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    String nome;
    int identifier;
    double preco_p_un;
    int stock;

    public String getNome() {
        return nome;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean is_mobilia(){
        return false;
    }
}