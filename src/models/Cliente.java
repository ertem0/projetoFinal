package models;

public class Cliente {
    String nome;
    String morada;
    String email;
    int telefone;
    Data dataNascimento;
    boolean frequente;

    public Cliente(String nome, String morada, String email, int telefone, Data dataNascimento) {
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }


}
