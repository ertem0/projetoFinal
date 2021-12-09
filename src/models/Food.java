package models;

/**
 * Subclasse de {@link Product}, especificada para produtos alimentares com as variáveis calorias e gordura
 */
public class Food extends Product {
    private int calories; //por 100g
    private int fat; //%

    /**
     * Contrutor da subclasse {@link Food}
     * @param nome Nome do alimento
     * @param indentifier Identificador do alimento
     * @param price Preço
     * @param stock Stock disponível
     * @param calories Calorias por 100g
     * @param fat Gordura em percentagem
     */
    public Food(String nome, int indentifier, double price, int stock, int calories, int fat) {
        this.nome = nome;
        this.identifier = indentifier;
        this.preco_p_un = price;
        this.stock = stock;
        this.calories = calories;
        this.fat = fat;
    }

    /**
     * Método para a impressão das informações dos alimentos
     * @return String
     */
    @Override
    public String toString() {
        return  "["+this.nome + " (id: "+this.identifier+")] preco: " + this.preco_p_un + "$, Gordura(%): " + this.fat + ", Calorias: " + this.calories;
    }
}
