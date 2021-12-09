package models;

import java.io.Serializable;

public class Data implements Serializable {
    //date class
    protected int day;
    protected int month;
    protected int year;

    public Data (int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }
}
