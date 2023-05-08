package model;

import Gson.GsonReader;
import Gson.GsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {

    //Attribute
    private ArrayList<Product> products;

    //Relations
    private final GsonReader<ArrayList<Product>> reader;
    private final GsonWriter<ArrayList<Product>> writer;

    //Builder
    public Controller() {
        products = new ArrayList<>();
        reader = new GsonReader<ArrayList<Product>>();
        writer = new GsonWriter<ArrayList<Product>>();
    }

    public void addProduct(String nameProduct, String description, int numberOfTimesPurchased, int price, int quantity, int categories){
        products.add(new Product(nameProduct, description, numberOfTimesPurchased, price, quantity, categories));
    }

    public void sort(){
        Collections.sort(products);
    }

    public void sortByName(){
        Collections.sort(products, Comparator.comparing(Product::getNameProduct));
    }
        public void sortByCategory(){
     Collections.sort(products, Comparator.comparing(Product::getCategory));
     }
    public void sortByPrice(){
        Collections.sort(products, Comparator.comparingInt(Product::getPrice));
    }

    public void sortByStock(){
        Collections.sort(products,Comparator.comparingInt(Product::getQuanty));
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

    public void loadData() throws IOException {
        products = reader.readDatabase();
    }
    public void saveData(){
        writer.writeInDatabase(products);
    }
}
