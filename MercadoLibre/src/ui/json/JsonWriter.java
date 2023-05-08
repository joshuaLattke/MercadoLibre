package ui.json;

import com.google.gson.Gson;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JsonWriter {
    private static ArrayList<Product> producto;

    public static void main(String[] args) {
        Gson gson = new Gson();

        producto = new ArrayList<>();
        Product product1 = new Product("pepito","",22,1200,1,2);
        Product product2 = new Product("juan","j",12,500,1,1);
        Product product3 = new Product("andres","",84,200,1,3);
        Product product4 = new Product("pablito","",22,400,1,1);
        Product product5 = new Product("merensejo","",15,70,1,8);

        producto.add(product1);
        producto.add(product2);
        producto.add(product3);
        producto.add(product4);
        producto.add(product5);



        String json = gson.toJson(producto);
        System.out.print(json);

        try {
            FileOutputStream fos = new FileOutputStream(new File("Product.txt"));
            fos.write( json.getBytes(StandardCharsets.UTF_8) );
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
