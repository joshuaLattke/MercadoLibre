package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    private  ArrayList<Product> producto;
    public Controller(){


        producto = new ArrayList<>();
        Product product1 = new Product("pepito","jugete sexual",22,1200,1,2);
        Product product2 = new Product("juan","jugete sexual",12,500,1,1);
        Product product3 = new Product("andres","jugete sexual",84,200,1,3);
        Product product4 = new Product("pablito","jugete sexual",22,400,1,1);
        Product product5 = new Product("merensejo","jugete sexual",15,70,1,8);

        producto.add(product1);
        producto.add(product2);
        producto.add(product3);
        producto.add(product4);
        producto.add(product5);


        //System.out.println(producto);
        sortByPrice();
        System.out.println(producto);

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
    }
        public void sortByCategory(){
     Collections.sort(producto, new Comparator<Product>() {
         @Override
         public int compare(Product o1, Product o2) {
             return o1.getCategory().compareTo(o2.getCategory());
         }
     });
     }
    public void sortByPrice(){
        Collections.sort(producto, Comparator.comparingInt(Product::getPrice));

    }

}
