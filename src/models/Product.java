package models;

import java.io.Serializable;

/**
 * Superclasse dos {@link Product}, onde as variáveis base são definidas para utilização nas subclasse {@link Cleaning},
 * {@link Food} e {@link Furniture}
 *
 * @author Francisco Rosendo
 * @author Vasco Gouveia
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
     * Verificar se o produto em questão é mobília
     * @return False, exceto na classe Furniture, onde é overridden
     */
    public boolean is_mobilia(){
        return false;
    }
}