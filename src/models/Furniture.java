package models;

public class Furniture extends Product {
    int peso;
    Dimensao dimensao;

    public Furniture(String nome, int indentifier, double price, int stock, int peso) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.peso = peso;
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

class Dimensao {
    int altura;
    int largura;
    int profundidade;

    Dimensao(int altura, int largura, int profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
}