package ui;

import Model.Order;
import Model.Product;
import com.google.gson.Gson;

import model.Controller;

import java.io.*;
import java.util.ArrayList;


public class Reader {
    Gson gson = new Gson();

    File projectDir = new File(System.getProperty("user.dir"));
    File dataDirectory = new File(projectDir.getName()+"/data");
    File result = new File(projectDir.getName()+"/data/result.json");

      try {
        FileInputStream fis = new FileInputStream(result);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
        String line;
        String json = "";
        while ( (line = reader.readLine()) != null){
            json += line;
        }
        products= gson.fromJson(json,

        orders=new  ArrayList<Order>();

        System.out.println(json);
        for (Product p : products)

            for (Order c:Orders)

       }catch (FileNotFoundException e){
        e.printStackTrace();
        }catch (IOException e){
        e.printStackTrace();
        }
    }
    }


}

