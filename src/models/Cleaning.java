package models;

public class Cleaning extends Product {
    int toxicity;

    public Cleaning(String nome, int indentifier, double price, int stock, int toxicity) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.toxicity = toxicity;
    }
    
    @Override
    public String toString() {
        return "Cleaning{" + "nome=" + nome + ", identifier=" + identifier + ", preco_p_un=" + preco_p_un + ", stock=" + stock + ", toxicity=" + toxicity + "}\n";
    }
}
