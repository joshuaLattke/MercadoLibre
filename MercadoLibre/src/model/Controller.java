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
    public void sortByPrice(){
        Collections.sort(producto, Comparator.comparingInt(Product::getPrice));

    }
    public void sortByStock(){
        Collections.sort(producto,Comparator.comparingInt(Product::getQuanty));
    }
    private static int binarySearch(ArrayList<Product> products, char start) {
        int min = 0;
        int max = products.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            char firstChar = products.get(mid).getNameProduct().charAt(0);

            if (firstChar == start) {
                // El primer producto que empieza por la letra inicial
                return mid;
            } else if (firstChar < start) {
                // La letra inicial dada está más adelante en el alfabeto, busca en la mitad derecha
                min = mid + 1;
            } else {
                // La letra inicial dada está más atrás en el alfabeto, busca en la mitad izquierda
                max = mid - 1;
            }
        }

        // No se ha encontrado ningún producto que empiece por la letra inicial
        return -1;
    }
}
