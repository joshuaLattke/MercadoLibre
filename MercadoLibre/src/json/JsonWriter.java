package json;

import com.google.gson.Gson;
import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class JsonWriter {

    public static void main(String[] args) {
        Gson gson = new Gson();

        ArrayList<Product> people = new ArrayList<>();



        String json = gson.toJson(people);
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
