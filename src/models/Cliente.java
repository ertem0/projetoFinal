package models;

import java.io.Serializable;

public class Cliente implements Serializable {
    String nome;
    String morada;
    String email;
    int telefone;
    Data dataNascimento;
    boolean frequente;

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

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", telefone=" + telefone +
                ", dataNascimento=" + dataNascimento +
                ", frequente=" + frequente +
                '}';
    }
}
