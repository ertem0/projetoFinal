package models;
import  java.io.*;
import java.util.ArrayList;

public class list_products {

    private ArrayList <Product> produtos = new ArrayList<>();


    public  void read_text(){
        File f = new File("src/models/files/clients.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
                    Product produto = new Product(str[0], Integer.parseInt(str[1]), Double.parseDouble(str[2]), Integer.parseInt(str[3])) {

                    };
                    /*
                    boolean exists = false;
                    for(Product produto2: produto){
                        if (cliente.email.equals(produto2.email)){
                            exists = true;
                        }
                        if (!exists){
                            produtos.add(produto);
                        }
                    }*/

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
            oos.writeObject(produtos);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}
