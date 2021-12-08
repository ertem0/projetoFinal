package models;

public class Furniture extends Product {
    double peso;
    int dimensao;

    public Furniture(String nome, int indentifier, double price, int stock, double peso, int dimensao) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.peso = peso;
        this.dimensao = dimensao;
    }

    public double getpeso() {
        return this.peso;
    }

    @Override
    public boolean is_mobilia() {
        // TODO Auto-generated method stub
        return true;
    }
}
