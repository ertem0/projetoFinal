import models.*;

public class App {
    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        Order order = new Order(inventory, new Cliente(null, null, null, 0, null));

        inventory.addProduct(new Food("Carne", 111, 2.5, 10, 1050, 22));
        inventory.addProduct(new Cleaning("clorix", 222, 6.7, 5, 6));
        inventory.addProduct(new Furniture("mesa", 333, 10, 5, 20, 0));
        inventory.getProducts();
        //inventory.addDiscount(new Discount(true, inventory.getProductfromId(222)));

        list_clients list = new list_clients();

        list.read_text();

        order.addProduct(222, 2);
        order.addProduct(111, 2);
        order.removeProduct(222, 1);
        order.addProduct(222, 5);
        order.addProduct(333, 1);
        System.out.println(order.getOrder());
        //System.out.println(inventory.getDiscounts().get(0).getProduct());
        System.out.println(order.process_order());
    }
}