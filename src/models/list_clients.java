package models;
import java.io.*;
import java.util.ArrayList;


public class list_clients {

    private ArrayList <Cliente> clientes = new ArrayList<>();


    public  void read_text(){
        File f = new File("src/models/files/clients.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(",");
                    Cliente cliente = new Cliente(str[0], str [1], str[2], Integer.parseInt(str[3]), new Data(Integer.parseInt(str[4]), Integer.parseInt(str[5]), Integer.parseInt(str[5])));

                    boolean exists = false;
                    for(Cliente cliente2: clientes){
                        if (cliente.email.equals(cliente2.email)){
                            exists = true;
                        }
                        if (!exists){
                            clientes.add(cliente);
                        }
                    }

                }
                writethisClass();
                br.close();


            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");

            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto.");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }



    public void writethisClass(){
        File f = new File("src/models/files/ficheiro.obj");

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}