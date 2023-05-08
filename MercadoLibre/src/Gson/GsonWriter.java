package Gson;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class GsonWriter<K>{

    private final Gson gson;
    private final String path;

    public GsonWriter() {
        path = "data/database.txt";
        gson = new Gson();
    }

    public void writeInDatabase(ArrayList<K> data){
        writer(gson.toJson(data));
    }

    public void writeInDatabase(K data) {
        writer(gson.toJson(data));
    }

    private void writer(String json) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(json.getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

