package models;

import java.io.Serializable;

/**
 * Classe que representa os discontos, por tipo de desconto e identificador
 */
public class Discount implements Serializable{
    boolean discount_type; // true = pay 3 take 4, false = payless
    int identifier;

    /**
     * Construtor da classe {@link Discount}
     * @param discount_type Tipo de desconto (True- Pague 3 leve 4, False- Desconto percentual)
     * @param identifier
     */
    public Discount(boolean discount_type, int identifier) {
        this.discount_type = discount_type;
        this.identifier = identifier;
    }

    /**
     *
     * @return Identificador
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return Tipo de disconto (True- Pague 3 leve 4, False- Desconto percentual)
     */
    public boolean isDiscount_type() {
        return discount_type;
    }
}
