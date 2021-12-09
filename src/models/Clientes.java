package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Clientes implements Serializable{
    /**
     * @author Francisco Rosendo
     * @author Vasco Gouveia
     */
    public Clientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    private ArrayList<Cliente> clientes;
    /**
     * Função para a implementação do Login.
     * Caso o email não esteja registado, o ciclo é retomado.
     */
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
    /**
     * Método que identifica o cliente através do email fornecido.
     * @param email Fornecido pelo utilizador no Login.
     * @return Instância da classe Cliente associada ao email, se existir. Null, se não.
     */
    public Cliente getByEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.email.equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    /**
     *
     * @param cliente
     */
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