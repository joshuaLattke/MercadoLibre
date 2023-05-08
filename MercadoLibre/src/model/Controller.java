package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    private ArrayList<Product>producto;


    public void addProduct(String nameProduct, String description,int numberOfTimesPurchased,int price, int quanty,int categories){
        producto = new ArrayList<>();

        producto.add(new Product(nameProduct, description, numberOfTimesPurchased, price, quanty, categories));


    }
    public void sort(){
        Collections.sort(producto);
    }

    public void sortByName(){
        Collections.sort(producto, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getNameProduct().compareTo(o2.getNameProduct());
            }
        });
        ;
    }
        public void sortByCategory(){
     Collections.sort(producto, new Comparator<Product>() {
         @Override
         public int compare(Product o1, Product o2) {
             return o1.getCategory().compareTo(o2.getCategory());
         }
     });
     }
    public void sortByPrice(ArrayList<Product> producto){
        Collections.sort(producto, Comparator.comparingInt(Product::getPrice));

    }

}
