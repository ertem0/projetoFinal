package models;

/**
 * Subclasse de {@link Product}, especificada para produtos de limpeza com a variavel toxicidade
 */
public class Cleaning extends Product {
    int toxicity;

    /**
     * Construtor da classe
     * @param nome Nome do produto
     * @param indentifier Identificador do produto
     * @param price Preço do produto
     * @param stock Stock disponível
     * @param toxicity Toxicidade
     */
    public Cleaning(String nome, int indentifier, double price, int stock, int toxicity) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.toxicity = toxicity;
    }

    /**
     * Metodo para a impressao das informacoes dos produtos
     * @return String
     */
    @Override
    public String toString() {
        return  "["+this.nome + " (id: "+this.identifier+")] preco: " + this.preco_p_un + "$, Nivel de toxicidade: " + this.toxicity;
    }
}
