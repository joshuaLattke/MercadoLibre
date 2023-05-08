package Model;
import Model.Order;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Controller {

    public static ArrayList<Product>products;
    private static ArrayList<Order>orders;

    public Controller(){

        products=new ArrayList<Product>();

        orders=new  ArrayList<Order>();

    }
    public static Product getProductByName(String productName) {
        for (Product p : products) {
            if (p.getNameProduct().equals(productName)) {
                return p;
            }
        }
        return null;
    }
    public  static boolean registerListProduct(String nameProduct, String description, int quanty, double price, int numberOfTimesPurchased, TypeCategory category) {
        Product product = new Product(nameProduct, description, quanty, price, numberOfTimesPurchased, category);
        products.add(product);
        for (Product p : products) {
            if (nameProduct.equals(p.getNameProduct())) {
                return true;
            }
        }

        return false;
    }

    public static boolean createOrder(String nameClient, Calendar c, Product product) {
        int requestedQuantity = product.getQuanty();
        double pricePerUnit = product.getPrice();
        double totalPrice = requestedQuantity * pricePerUnit;
        for (Product p : products) {
            if (p.getNameProduct().equals(product.getNameProduct())) {
                int currentQuantity = p.getQuanty();
                int newQuantity = currentQuantity - requestedQuantity;
                if (newQuantity >= 0) {
                    p.setQuanty(newQuantity);
                    Order order = new Order(nameClient, c, product, totalPrice);
                    orders.add(order);
                    
                    return true;
                }
                break;
            }
        }
        return false;
    }
    public  static boolean addProduct(String nameProduct, int quanty) {
        int suma=0;
        for (Product p : products) {
            if (p.getNameProduct().equals(nameProduct)) {
                p.setQuanty(p.getQuanty() + suma);
                return true;
            }
        }

        return false;
    }



}
