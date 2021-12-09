package models;

import java.io.Serializable;

public abstract class Product implements Serializable {
    String nome;
    int identifier;
    double preco_p_un;
    int stock;

    public int getIdentifier() {
        return identifier;
    }

    public boolean is_mobilia(){
        return false;
    }
}