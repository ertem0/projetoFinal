package models;

public abstract class Product {
    String nome;
    int identifier;
    double preco_p_un;
    int stock;
/*
    public Product(String n, int i, double p, int s){
        this.nome = n;
        this.identifier = i;
        this.preco_p_un = p;
        this.stock = s;
    } */
    public int getIdentifier() {
        return identifier;
    }

    public boolean is_mobilia(){
        return false;
    }
}
