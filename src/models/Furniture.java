package models;

import java.io.Serializable;

public class Furniture extends Product {
    int peso;
    Dimensao dimensao;

    public Furniture(String nome, int indentifier, double price, int stock, int peso, int altura, int latgura, int profundidade) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.peso = peso;
        this.dimensao = new Dimensao(altura, latgura, profundidade);
    }

    public double getpeso() {
        return this.peso;
    }

    @Override
    public boolean is_mobilia() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public String toString() {
        return "["+this.nome + " (id: "+this.identifier+")] preco: " + this.preco_p_un + "$, Peso: " + this.peso + ", Altura:" + this.dimensao.altura + ", Largura: " + this.dimensao.largura + ",  Profundidade: " + this.dimensao.profundidade;
    }
}

class Dimensao implements Serializable{
    int altura;
    int largura;
    int profundidade;

    Dimensao(int altura, int largura, int profundidade) {
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
}