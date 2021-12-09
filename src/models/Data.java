package models;

import java.io.Serializable;

/**
 * Classe que representa uma data
 */
public class Data implements Serializable {
    //date class
    protected int day;
    protected int month;
    protected int year;

    /**
     * Construtor da classe {@link Data}
     * @param d Dia
     * @param m Mes
     * @param y Ano
     */
    public Data (int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }
}
