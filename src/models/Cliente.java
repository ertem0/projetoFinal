package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Classe que gere os objetos do tipo cliente
 */
public class Cliente implements Serializable {
    String nome;
    String morada;
    String email;
    int telefone;
    Data dataNascimento;
    boolean frequente;
    ArrayList<Order> orders=new ArrayList<>();

    /**
     *
     * @param nome Nome do cliente
     * @param morada Morada do cliente
     * @param email Email
     * @param telefone Número de telefone
     * @param dataNascimento Data de nascimento
     * @param frequente Indica se é cliente frequente ou não
     */
    public Cliente(String nome, String morada, String email, int telefone, Data dataNascimento, boolean frequente) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.frequente = frequente;
    }

    /**
     * Metodo para ir buscar o nome do cliente a classe
     * @return Nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Adicona a lista das encomendas uma nova encomenda
     * @param order Encomenda a adiconar
     */
    public void addOrder(Order order){
        orders.add(order);
    }

    /**
     *
     * @return Lista das encomendas
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }
    /**
     * Override da função {@link #toString()}
     * @return String estruturada com os dados do objeto
     */
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
