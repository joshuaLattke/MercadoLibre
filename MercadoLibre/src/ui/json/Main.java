package ui.json;

import com.google.gson.Gson;
import model.Controller;



import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static Gson gson;
    private static boolean exit;
    private static Controller control;
    public static void main (String[] args){
        Main main = new Main();
        exit=false;
        mainMenu();
    }
    public Main (){
        sc = new Scanner(System.in);
        gson = new Gson();
        control = new Controller();
    }
    public static void mainMenu(){
        while (!exit) {
            System.out.println("""
                                                
                    ---------------------------------
                        Welcome to Mercado Libre     |
                    ----------------------------------
                                                
                    Press an option
                                                
                        [1] create product
                        [2] search product
                        [3] exit
                    """);

            String optionTemp = sc.nextLine();
            int option = Integer.parseInt(optionTemp);
            switch (option){
                case 1:
                    createProduct();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    exit =true;
                    break;

            }

        }
    }

    private static void searchProduct() {
    }

    private static void createProduct() {
        System.out.println("Name of the product");
        String name = sc.nextLine();
        System.out.println("Description");
        String descrption = sc.nextLine();
        System.out.println("numbers of time Purchased");
        String numberTemp = sc.nextLine();
        int number = Integer.parseInt(numberTemp);
        System.out.println("price");
        String priceTemp = sc.nextLine();
        int price = Integer.parseInt(priceTemp);
        System.out.println("quanty");
        String quantyTemp = sc.nextLine();
        int quanty =Integer.parseInt(quantyTemp);
        System.out.println("""
                            -----------------
                                Categories
                            -----------------
                            [1]    BOOKS           [2]    ELECTRONICS       [3] CLOTHING
                            [4]   EATS             [5]   PAPERWORK          [6]    SPORTS
                            [7]  BEAUTYPRODUCTS    [8]   PERSONALCARE       [9]TOYS
                            [10]  GAMES            [11]DRINKS
                            """);
        String categoryTemp = sc.nextLine();
        int category =Integer.parseInt(categoryTemp);

        control.addProduct(name,descrption,number,price,quanty,category);

        System.out.println("Register successfully");

        System.out.println("""
                ---------------------------
                REDIRECTING TO MAIN MENU
                -----------------------
                """);

        mainMenu();

    }

}
