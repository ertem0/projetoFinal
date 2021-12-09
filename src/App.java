import java.io.File;
import java.util.Scanner;

import models.*;
//nota para mim passar tudo pelo inv.add em vez de dar set (nao apagar rosendo)(ok, eu nao apago)
/**
 * A classe app é o main
 *
 * @author Francisco Rosendo
 * @author Vasco Gouveia
 */
public class App {
    /**
     * Começa-se por incializar os objetos necessários, fazer a leitura dos ficheiros .txt onde se encontram
     * os dados sobre os clientes, pordutos e descontos, e guardar a informação em ficheiros .obj.
     * É pedido ao utilizador que faça o login. Caso este escolha fazer logout o loop é reiniciado.
     * O programa apenas é terminado por ordem do utilizador.
     *
     */
    public static void main(String[] args) throws Exception {

        FileManager list = new FileManager();

        if(!(new File("src/models/files/clients.obj")).exists()){
            list.read_clients();
        }
        if(!(new File("src/models/files/discounts.obj")).exists()){
            list.read_discounts();
        }
        if(!(new File("src/models/files/products.obj")).exists()){
            list.read_products();
        }
        
        
        Clientes clientes = list.load_clientes();
        ProductsList productsList = list.load_products();
        Discounts discounts = list.load_discounts();

        Inventory inventory = new Inventory();
        inventory.setProducts(productsList.getproducts());
        inventory.setDiscounts(discounts.getdiscounts());
        
        Scanner sc= new Scanner(System.in);
        Cliente cliente= clientes.login();
        
        Order order = new Order(inventory, cliente);
        boolean stop =false;

        while(!stop){
            System.out.println("Options:\n1 - Listar produtos\n2 - Adicionar produto\n3 - Listar descontos\n4 - Listar carrinho de compras\n5 - Finalizar compra\n6 - Historico de compras\n7 - Logout\n8 - Sair\n");
            System.out.print("Option: ");
            int opcao= sc.nextInt();
            System.out.println();
            switch(opcao){
                case 1:
                    System.out.println("[PRODUTOS]\n");
                    for (Product product : inventory.getProducts()) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.print("\n[Compra]\n\nID do produto: ");  
                    int id= sc.nextInt();
                    System.out.print("Quantidade: ");  
                    int qtd= sc.nextInt();
                    order.addProduct(id, qtd);
                    System.out.println("\nProduto adicionado com sucesso");
                    System.out.println("[CARRINHO DE COMPRAS]\n");
                    order.displayOrder();
                    break;
                case 3:
                    System.out.println("[DESCONTOS]\n");
                    for (Discount discount : inventory.getDiscounts()) {
                        Product pord = inventory.getProductfromId(discount.getIdentifier());
                        if(discount.isDiscount_type()){
                            System.out.println("Desconto tipo pague 3 leve 4 para o produto " + pord.getNome() + "(id: "+pord.getIdentifier()+")");
                        }else{
                            System.out.println("Desconto tipo paga menos para o produto " + pord.getNome() + "(id: "+pord.getIdentifier()+")");
                        }
                    }
                    
                    break;
                case 4:
                    System.out.println("[CARRRINHO DE COMPRAS]\n");
                    order.displayOrder();
                    break;
                case 5:
                    System.out.println("[PAGAMENTO]\n");
                    System.out.println("Valor total: " + order.process_order()+ "$");
                    cliente.addOrder(order);
                    list.writethisClass("clients.obj", clientes);
                    order = new Order(inventory, cliente);
                    break;
                case 6:
                    System.out.println("[HISTORICO]\n");
                    for (Order ord : cliente.getOrders()) {
                        System.out.println("\n[ORDEM]\n");
                        for (Product product : ord.getOrder().keySet()) {
                            System.out.println(product.getNome() + " - " + ord.getOrder().get(product) + " unidades");
                        }
                        System.out.println("Total: " + ord.getTotal() + "$");
                        System.out.println("\n");
                    }
                    break;
                case 7:
                    System.out.println("\n[LOGOUT]\n");
                    cliente = clientes.login();
                    order = new Order(inventory, cliente);
                    break;
                case 8:
                    System.out.println("Turning off...");
                    stop = true;
                    System.out.println(clientes.getClientes());
            }
            System.out.println("\n");
        }
        //System.out.println(order.getOrder());
        //System.out.println(inventory.getDiscounts().get(0).getProduct());
        
        sc.close();
    }
}