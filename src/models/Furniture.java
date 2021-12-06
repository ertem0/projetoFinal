package models;

public class Furniture extends Product {
    int peso;
    int dimensao;

    public Furniture(String nome, int indentifier, double price, int stock, int peso, int dimensao) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.peso = peso;
        this.dimensao = dimensao;
    }
}
