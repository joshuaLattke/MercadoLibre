package Gson;

import com.google.gson.Gson;

import java.io.*;

import Exception.WithoutDataSavedGsonReaderException;

public class GsonReader<K> {

    //Attributes
    private final Gson gson;
    private final String path;
    private final String folder;

    public GsonReader() {
        path = "data/database.txt";
        folder = "data";
        gson = new Gson();
    }

    public K readDatabase() throws IOException {
        K data = null;
        String read = reader();
        if (read.equals(""))
            throw new WithoutDataSavedGsonReaderException();
        Class<K> dataClass = (Class<K>) data.getClass();
        data = gson.fromJson(read, dataClass);
        return data;
    }

    private String reader() throws IOException {
        File file = new File(path);
        String json = "";
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);

            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;
            if((line = reader.readLine())!=null){
                json = line;
            }
            fis.close();
        } else {
            File f = new File(folder);
            if(!f.exists()){
                f.mkdirs();
            }
            file.createNewFile();
        }
        return json;
    }
}
