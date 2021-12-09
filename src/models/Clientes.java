package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Clientes implements Serializable{
    private ArrayList<Cliente> clientes;

    public Clientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public Cliente getByEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.email.equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public void updateCliente(Cliente cliente){
        this.clientes.set(this.clientes.indexOf(cliente), cliente);
    }

    public Cliente getCliente(int index){
        return this.clientes.get(index);
    }

    public int getSize(){
        return this.clientes.size();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}