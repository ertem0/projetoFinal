package models;

public class Food extends Product {
    private int calories; //por 100g
    private int fat; //%

    public Food(String nome, int indentifier, double price, int stock, int calories, int fat) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.calories = calories;
        this.fat = fat;
    }
    
}