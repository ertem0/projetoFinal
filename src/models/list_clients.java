package models;
import java.io.*;
import java.util.ArrayList;


public class
list_clients {

    private ArrayList <Cliente> clientes = new ArrayList<>();
    private ArrayList <Product> produtos = new ArrayList<>();
    private ArrayList <Discount> descontos = new ArrayList<>();


    public  void read_clients(){
        File f = new File("src/models/files/clients.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
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
                writethisClass("clients.obj", clientes);
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

    public  void read_products(){
        File f = new File("src/models/files/products.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String text = "";

                while ((line = br.readLine()) != null) {
                    text += line;

                }
                String [] file = text.split("!");

                String [] lines_cleaning =  file[0].split("\n");
                String [] lines_food =  file[1].split("\n");
                String [] lines_furniture =  file[2].split("\n");

                for(String l : lines_cleaning){
                    String [] lc = l.split(";");
                    produtos.add(new Cleaning(lc[0],Integer.parseInt(lc[1]), Double.parseDouble(lc[2]), Integer.parseInt(lc[3]), Integer.parseInt(lc[4])));
                }

                for(String l : lines_food){
                    String [] lf = l.split(";");
                    produtos.add(new Food((lf[0]),Integer.parseInt(lf[1]), Double.parseDouble(lf[2]), Integer.parseInt(lf[3]), Integer.parseInt(lf[4]), Integer.parseInt(lf[5])));
                }

                for(String l : lines_furniture){
                    String [] lfur = l.split(";");
                    produtos.add(new Furniture(lfur[0],Integer.parseInt(lfur[1]), Double.parseDouble(lfur[2]), Integer.parseInt(lfur[3]), Integer.parseInt(lfur[4]), Integer.parseInt(lfur[5]), Integer.parseInt(lfur[6]), Integer.parseInt(lfur[7])));
                }

                writethisClass("products.obj", produtos);
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

    public  void read_discounts(){
        File f = new File("src/models/files/discounts.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
                    descontos.add(new Discount(Boolean.parseBoolean(str[0]), Integer.parseInt(str [1])));

                }
                writethisClass("discounts.obj", descontos);
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


    public void writethisClass(String file_name, ArrayList objeto){
        File f = new File("src/models/files/" + file_name);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objeto);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

}