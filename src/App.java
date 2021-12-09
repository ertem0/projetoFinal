import java.util.Scanner;

import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        list_clients list = new list_clients();
        list.read_clients();
        list.read_discounts();
        list.read_products();
        Clientes clientes = list.load_clientes();
        Products products = list.load_products();
        Discounts discounts = list.load_discounts();

        Inventory inventory = new Inventory();
        inventory.setProducts(products.getproducts());
        inventory.setDiscounts(discounts.getdiscounts());

        System.out.println(inventory.getProducts());
        System.out.println(clientes.getClientes());
        
        Scanner sc= new Scanner(System.in); 

        System.out.print("[Login]\n\nEmail: ");  
        String email= sc.nextLine();
        Cliente cliente = clientes.getByEmail(email);
        if(cliente == null){
            System.out.println("\n\n[Login]\n\nEmail não encontrado");
            return;
        }
        Order order = new Order(inventory, cliente);
        System.out.println("Welcome, " + cliente.getNome() + "\n\n");  
        
        System.out.println("Options:\n1 - Listar produtos\n2 - Comprar produto\n3 - Listar descontos\n");  
        int opcao= sc.nextInt();
        switch(opcao){
            case 1:
                System.out.println(inventory.getProducts());
                break;
            case 2:
                System.out.print("\n[Compra]\n\nID do produto: ");  
                int id= sc.nextInt();
                System.out.print("Quantidade: ");  
                int qtd= sc.nextInt();
                order.addProduct(id, qtd);
                System.out.println("\n\n[Compra]\n\nProduto adicionado com sucesso");
                System.out.println(order.getOrder());
                break;
            case 3:
                System.out.println(inventory.getDiscounts());
                break;
        }
        //System.out.println(order.getOrder());
        //System.out.println(inventory.getDiscounts().get(0).getProduct());
        System.out.println(order.process_order());
        sc.close();
    }
}