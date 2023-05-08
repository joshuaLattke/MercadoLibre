package Gson;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class GsonReader<K> {

    private Gson gson;
    private String path;
    public K data;

    public GsonReader() {
        path = "data/database.txt";
        gson = new Gson();
    }

    public ArrayList<K> readArraylistDatabase() {
        ArrayList<K> data = new ArrayList<>();
        try {
            Class<ArrayList<K>> dataClass = (Class<ArrayList<K>>) data.getClass();
            data = gson.fromJson(reader(), dataClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public K readDatabase() {
        K data = null;
        try {
            Class<K> dataClass = (Class<K>) data.getClass();
            data = gson.fromJson(reader(), dataClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private String reader() throws IOException {
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

        String json = "";
        String line;
        if((line = reader.readLine())!=null){
            json = line;
        }
        fis.close();

        return json;
    }
}
