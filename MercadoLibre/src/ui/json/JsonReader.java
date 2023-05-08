package ui.json;

import com.google.gson.Gson;
import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import model.Controller;

public class JsonReader {
public static Controller control;
public static ArrayList<Product>product;
    public static void main(String[] args) {
         control = new Controller();

       readJson();


    }

    public static void readJson(){
        try {
            File file = new File("product.txt");
            System.out.println("Existe: "+file.exists());
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String json = "";
            String line;
            if((line=reader.readLine())!=null){
                json= line;
            }
            fis.close();
    //            System.out.println(ui.json);

            Gson gson = new Gson();
            Product[] peopleFromJson = gson.fromJson(json, Product[].class);

            product = new ArrayList<>();
            product.addAll(Arrays.asList(peopleFromJson));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
