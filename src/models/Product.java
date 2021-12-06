package models;

public abstract class Product {
    String nome;
    int identifier;
    double preco_p_un;
    int stock;


    public int getIdentifier() {
        return identifier;
    }
}
