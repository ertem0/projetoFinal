package models;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.SortingFocusTraversalPolicy;

/**
 * Classe para a gestao das encomendas
 */
public class Order implements Serializable{
    Hashtable<Product, Integer> order = new Hashtable<Product, Integer>();
    Inventory inventory;
    Cliente cliente;
    double total;

    /**
     * Contrutor da classe {@link Order}
     * @param inventory Instancia da classe {@link Inventory}
     * @param cliente Cliente
     */
    public Order(Inventory inventory, Cliente cliente) {
        this.inventory = inventory;
        this.cliente = cliente;
    }

    /**
     * Adiciona o produto ao carrinho de compras
     * @param indentifier Identificador do produto
     * @param quantity Quantidade a adicionar
     */
    public void addProduct(int indentifier, int quantity) {
        for (Product product : inventory.getProducts()) {
            if (product.getIdentifier() == indentifier) {
                if (order.containsKey(product)) {
                    order.put(product, order.get(product) + quantity);
                } else {
                    order.put(product, quantity);
                }
                if (order.get(product) <= 0) {
                    order.remove(product);
                } else if(order.get(product) > product.getStock()) {
                    order.put(product, product.getStock());
                }
            }
        }
    }

    public void removeProduct(int indentifier, int quantity) {
        for (Product product : inventory.getProducts()) {
            if (product.getIdentifier() == indentifier) {
                if (order.containsKey(product)) {
                    order.put(product, order.get(product) - quantity);
                    if (order.get(product) <= 0) {
                        order.remove(product);
                    }
                }
            }
        }
    }

    /**
     * Processa a encomenda com todos os artigos do carrinho e os portes
     * @return Preco total da encomenda
     */
    public double process_order(){
        double totalp = 0.0;
        Enumeration<Product> products = order.keys();
        Product currentProduct;
        Discount currentDiscount;
        while (products.hasMoreElements()){
            currentProduct = products.nextElement();
            currentDiscount = null;
            int quantity = order.get(currentProduct);
            for (Discount discount: inventory.discounts) {
                if(discount.identifier==currentProduct.identifier){
                    currentDiscount=discount;
                }
            }
            if(currentDiscount==null){
                totalp += quantity * currentProduct.preco_p_un;
            }
            else if(currentDiscount.isDiscount_type()==true){
                int promo = quantity/4;
                totalp += (quantity-promo) * currentProduct.preco_p_un;
            }
            else if(currentDiscount.isDiscount_type()==false){
                boolean overflow = false;
                for (int i = 0; i < quantity; i++) {
                    if(i>=10){
                        overflow = true;
                        break;
                    }
                    totalp += (1-(i*0.05))*currentProduct.preco_p_un;
                }
                if(overflow){
                    totalp += 0.5 * (quantity-10) * currentProduct.preco_p_un;
                }

            }
            if(currentProduct.is_mobilia()){
                Furniture furniture = (Furniture)currentProduct;
                if(furniture.peso>15){
                    totalp += 10*quantity;
                }
            }
            currentProduct.setStock(currentProduct.getStock()-quantity);
        }
        if(cliente.frequente && (totalp<40)){
            totalp+=15;
        } else if(!cliente.frequente){
            totalp+=20;
        }
        this.total = totalp;
        return totalp;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Imprime o conteudo atual do carrinho
     */
    public void displayOrder() {
        Enumeration<Product> products = order.keys();
        Product currentProduct;
        while (products.hasMoreElements()) {
            currentProduct = products.nextElement();
            System.out.println(currentProduct.getNome() + " (id:"+currentProduct.identifier+"): Quantidade " + order.get(currentProduct));
        }
        System.out.println("Total Previsto: " + process_order() + "$");
    }

    /**
     *
     * @return Dicionario da encomenda
     */
    public Hashtable<Product, Integer> getOrder() {
        return order;
    }
}
