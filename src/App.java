import java.util.Scanner;

import models.*;
//nota para mim passar tudo pelo inv.add em vez de dar set (nao apagar rosendo)
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
        Cliente cliente= clientes.login();
        
        Order order = new Order(inventory, cliente);
        boolean stop =false;
        while(!stop){
            System.out.println("Options:\n1 - Listar produtos\n2 - Adicionar produto\n3 - Listar descontos\n4 - Listar carrinho de compras\n5 - Finalizar compra\n6 - Logout\n7 - Sair\n");
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
                    order = new Order(inventory, cliente);
                    break;
                case 6:
                    System.out.println("\n[LOGOUT]\n");
                    cliente = clientes.login();
                    order = new Order(inventory, cliente);
                    break;
                case 7:
                    System.out.println("Turning off...");
                    stop = true;
            }
            System.out.println("\n");
        }
        //System.out.println(order.getOrder());
        //System.out.println(inventory.getDiscounts().get(0).getProduct());
        
        sc.close();
    }
}