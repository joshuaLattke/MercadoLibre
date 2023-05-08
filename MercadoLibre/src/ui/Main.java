package ui;

import model.Controller;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    //Attributes
    private static Scanner sc;
    private static boolean exit;

    //Relationship
    private static Controller control;

    //Executable
    public static void main (String[] args){
        Main main = new Main();
        exit = false;
        main.mainMenu();
    }

    //Builder
    public Main (){
        sc = new Scanner(System.in);
        control = new Controller();
    }

    public void mainMenu(){
        try {
            control.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            switch (option) {
                case 1 -> createProduct();
                case 2 -> searchProduct();
                case 3 -> exit = true;
            }
        }
        control.saveData();
    }

    private void searchProduct() {
        while (!exit) {
            System.out.println("""
                                    
                            search product by
                            [1] name
                            [2] price
                            [3] category
                            [4] stock
                    """);
            String optionTemp = sc.nextLine();
            int option = Integer.parseInt(optionTemp);
            switch (option) {
                case 1 -> control.sortByName();
                case 2 -> control.sortByPrice();
                case 3 -> control.sortByCategory();
                case 4 -> control.sortByStock();
                case 5 -> {
                    mainMenu();
                    exit = true;
                }
            }
        }
    }

    private void createProduct() {
        System.out.println("Name of the product");
        String name = sc.nextLine();
        System.out.println("Description");
        String description = sc.nextLine();
        System.out.println("numbers of time Purchased");
        String numberTemp = sc.nextLine();
        int number = Integer.parseInt(numberTemp);
        System.out.println("price");
        String priceTemp = sc.nextLine();
        int price = Integer.parseInt(priceTemp);
        System.out.println("quantity");
        String quantityTemp = sc.nextLine();
        int quantity =Integer.parseInt(quantityTemp);
        System.out.println("""
                            -----------------
                                Categories
                            -----------------
                            [1]   BOOKS            [2]   ELECTRONICS        [3] CLOTHING
                            [4]   EATS             [5]   PAPERWORK          [6] SPORTS
                            [7]   BEAUTYPRODUCTS   [8]   PERSONALCARE       [9] TOYS
                            [10]  GAMES            [11]  DRINKS
                            """);
        String categoryTemp = sc.nextLine();
        int category =Integer.parseInt(categoryTemp);

        control.addProduct(name,description,number,price,quantity,category);

        System.out.println("Register successfully");

        System.out.println("""
                ---------------------------
                REDIRECTING TO MAIN MENU
                -----------------------
                """);

        mainMenu();
    }
}
