package json;

import com.google.gson.Gson;
import model.Product;

import java.io.*;
import java.util.ArrayList;

public class JsonReader {

    public static void main(String[] args) {
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
            System.out.println(json);

            Gson gson = new Gson();
            Product[] peopleFromJson = gson.fromJson(json, Product[].class);

            ArrayList<Product> people = new ArrayList<>();
            for(Product p : peopleFromJson){
                people.add(p);
                System.out.println(p.getNameProduct()+" "+p.getCategory());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
