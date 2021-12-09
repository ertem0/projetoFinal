package models;

import java.io.Serializable;

/**
 * Superclasse dos {@link Product}, onde as variaveis base sao definidas para utilizacao nas subclasse {@link Cleaning},
 * {@link Food} e {@link Furniture}
 *
 */
public abstract class Product implements Serializable {
    String nome;
    int identifier;
    double preco_p_un;
    int stock;

    /**
     *
     * @return Nome do produto
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return Identificador do produto
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return Stock do produto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Altera o stock do produto
     * @param stock Valor do stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Verificar se o produto em questao é mobilia
     * @return False, exceto na classe Furniture, onde é overridden
     */
    public boolean is_mobilia(){
        return false;
    }
}