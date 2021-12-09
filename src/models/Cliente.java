package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Cliente implements Serializable {
    String nome;
    String morada;
    String email;
    int telefone;
    Data dataNascimento;
    boolean frequente;
    ArrayList<Order> orders=new ArrayList<>();

    public Cliente(String nome, String morada, String email, int telefone, Data dataNascimento, boolean frequente) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.frequente = frequente;
    }


    public String getNome() {
        return nome;
    }

    public void addOrder(Order order){
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", dataNascimento=" + dataNascimento +
                ", frequente=" + frequente +
                ", orders= "+ orders+'}';
    }
}
