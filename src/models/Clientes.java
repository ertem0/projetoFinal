package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Clientes implements Serializable{
    private ArrayList<Cliente> clientes;

    public Clientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public Cliente login(){
        Scanner sc= new Scanner(System.in);

        while(true){
            System.out.print("[Login]\n\nEmail: ");  
            String email= sc.nextLine();
            Cliente cliente = getByEmail(email);
            if(cliente != null){
                System.out.println("Welcome, " + cliente.getNome() + "\n\n"); 
                return cliente;
            } else{
                System.out.println("\n\n[Login]\n\nEmail não encontrado\n");
            }
        }
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