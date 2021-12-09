package models;
import java.io.*;

/**
 * Classe para a leitura e criacao de ficheiros txt e obj, respetivamente
 */
public class FileManager {
    private Clientes clientes = new Clientes();
    private ProductsList produtos = new ProductsList();
    private Discounts descontos = new Discounts();

    /**
     * Metodo para ler os ficheiros .txt com os dados dos clientes e criar do ficheiro .obj com recurso a {@link #writethisClass(String, Object)}
     */
    public  void read_clients(){
        File f = new File("src/models/files/clients.txt");
        File f2 = new File("src/models/files/clients_frequentes.txt");
        if (f.exists() && f.isFile() && f2.exists() && f2.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
                    Cliente cliente = new Cliente(str[0], str [1], str[2], Integer.parseInt(str[3]), new Data(Integer.parseInt(str[4]), Integer.parseInt(str[5]), Integer.parseInt(str[5])), false);

                    boolean exists = false;
                    for(Cliente cliente2: clientes.getClientes()){
                        if (cliente.email == cliente2.email){
                            exists = true;
                        }
                    }
                    if (!exists){
                        clientes.addCliente(cliente);
                    }

                }
                fr.close();
                br.close();
                fr = new FileReader(f2);
                br = new BufferedReader(fr);
                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
                    Cliente cliente = new Cliente(str[0], str [1], str[2], Integer.parseInt(str[3]), new Data(Integer.parseInt(str[4]), Integer.parseInt(str[5]), Integer.parseInt(str[5])), true);

                    boolean exists = false;
                    for(Cliente cliente2: clientes.getClientes()){
                        if (cliente.email == cliente2.email){
                            exists = true;
                        }
                    }
                    if (!exists){
                        clientes.addCliente(cliente);
                    }

                }

                //System.out.println(clientes.getClientes());
                writethisClass("clients.obj", clientes);


            } catch (FileNotFoundException ex) {
                System.out.println("Erro a abrir ficheiro de texto.");

            } catch (IOException ex) {
                System.out.println("Erro a ler ficheiro de texto." + "Clientes");
            }
        } else {
            System.out.println("Ficheiro não existe.");
        }
    }
    /**
     * Metodo para ler os ficheiros .txt com os dados dos produtos e criar do ficheiro .obj com recurso a {@link #writethisClass(String, Object)}
     */
    public  void read_products(){
        File f = new File("src/models/files/products.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                String text = "";

                while ((line = br.readLine()) != null) {
                    text += line+"\n";

                }
                String [] file = text.split("!");

                String [] lines_cleaning =  file[0].split("\n");
                String [] lines_food =  file[1].split("\n");
                String [] lines_furniture =  file[2].split("\n");

                for(String l : lines_cleaning){
                    String [] lc = l.split(";");
                    
                    produtos.addProduct(new Cleaning(lc[0],Integer.parseInt(lc[1]), Double.parseDouble(lc[2]), Integer.parseInt(lc[3]), Integer.parseInt(lc[4])));
                }

                for(String l : lines_food){
                    String [] lf = l.split(";");
                    if(lf.length !=6){
                        continue;
                    }
                    produtos.addProduct(new Food((lf[0]),Integer.parseInt(lf[1]), Double.parseDouble(lf[2]), Integer.parseInt(lf[3]), Integer.parseInt(lf[4]), Integer.parseInt(lf[5])));
                }

                for(String l : lines_furniture){
                    String [] lfur = l.split(";");
                    if(lfur.length !=8){
                        continue;
                    }
                    produtos.addProduct(new Furniture(lfur[0],Integer.parseInt(lfur[1]), Double.parseDouble(lfur[2]), Integer.parseInt(lfur[3]), Integer.parseInt(lfur[4]), Integer.parseInt(lfur[5]), Integer.parseInt(lfur[6]), Integer.parseInt(lfur[7])));
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

    /**
     * Metodo para ler os ficheiros .txt com os dados dos descontos e criar do ficheiro .obj com recurso a {@link #writethisClass(String, Object)}
     */
    public  void read_discounts(){
        File f = new File("src/models/files/discounts.txt");

        if (f.exists() && f.isFile()) {
            try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;

                while ((line = br.readLine()) != null) {
                    String [] str =  line.split(";");
                    descontos.addDiscount(new Discount(Boolean.parseBoolean(str[0]), Integer.parseInt(str [1])));

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

    /**
     * Metodo para a criacao do ficheiro .obj
     * @param file_name Nome do ficheiro destino
     * @param objeto Conteudo a escrever
     */
    public void writethisClass(String file_name, Object objeto){
        File f = new File("src/models/files/" + file_name);

        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objeto);
            oos.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Erro a criar ficheiro.");
        } catch (IOException ex) {
            System.out.println(ex);
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
    /**
     * Metodo para a leitura do ficheiro .obj com os dados dos clientes
     * @return Instancia da classe {@link Clientes}
     */
    public Clientes load_clientes(){
        File f = new File("src/models/files/clients.obj");
        Clientes clientes = new Clientes();

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            clientes = (Clientes)ois.readObject();

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro. Clientes");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return clientes;
    }
    /**
     * Metodo para a leitura do ficheiro .obj com os dados dos produtos
     * @return Instancia da classe {@link ProductsList}
     */
    public ProductsList load_products(){
        File f = new File("src/models/files/products.obj");
        ProductsList productsList = new ProductsList();

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            productsList = (ProductsList)ois.readObject();

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro. products");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return productsList;
    }
    /**
     * Metodo para a leitura do ficheiro .obj com os dados dos descontos
     * @return Instancia da classe {@link Discounts}
     */
    public Discounts load_discounts(){
        File f = new File("src/models/files/discounts.obj");
        Discounts discounts = new Discounts();

        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            discounts = (Discounts)ois.readObject();

            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Erro a abrir ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a ler ficheiro. discounts");
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro a converter objeto.");
        }
        return discounts;
    }
}