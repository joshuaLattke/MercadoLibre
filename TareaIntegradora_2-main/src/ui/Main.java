package ui;

import Model.Controller;
import java.util.Calendar;

import Model.Product;
import Model.TypeCategory;

import java.util.Scanner;

import static Model.Controller.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static boolean exit = false;

    public static Controller controller = new Controller();
    public static int option;

    public Main() {

    }

    public static void main(String[] args) {
        Main m = new Main();
        m.menu();
    }

    public void menu() {
        boolean exit=false;
        System.out.println("welcome Merccado Libre");
        while (!exit) {
            System.out.println("1. buyProduct\n 2.search order'\n3. exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    buyProduct();
                    break;
                case 2:
                    searchOrder();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("you can only enter values from 1 to 3");
                    break;
            }

        }

    }

    public void searchOrder() {
    }

    public void buyProduct() {

        while (!exit) {
            System.out.println("1. register product\n 2. delete product\n 3. SearchProduct\4. register order \n 5.add aditional product\n 6- exit ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    registerProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    registerOrder();
                    break;
                case 5:
                    addAnAdditionalProduct();
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("you can only enter values from 1 to 5");
                    break;
            }
        }
    }

    private void addAnAdditionalProduct() {
            sc.nextLine();
        System.out.println("enter the product name");

        String nameProduct = sc.nextLine();

        System.out.println("enter the quantity of the product");


        int quanty = sc.nextInt();
        if (Controller.addProduct(nameProduct, quanty)) {
            System.out.println("the product has been successfully added ");
        } else {
            System.out.println("product not found");
        }

    }

    private void registerOrder() {
        sc.nextLine();

        System.out.println("Enter customer name:");
        String nameClient = sc.nextLine();

        Calendar c = Calendar.getInstance();

        // Show available products and ask user to choose one
        System.out.println("Available products:");
        for (Product p : products) {
            System.out.println(p.getNameProduct());
        }
        System.out.println("Enter name of product to purchase:");
        String productName = sc.nextLine();
        Product product = getProductByName(productName);

        if (Controller.createOrder(nameClient, c, product)) {
            System.out.println("Order registered correctly.");
        } else {
            System.out.println("Error registering order.");
        }
    }


    private void searchProduct() {
    }

    public void deleteProduct() {

        /*System.out.println("enter the product name");

        String nameProduct=sc.nextLine();
        if(Contoller.(){
            System.out.println("was successfully removed");
        }
        else{
            System.out.println("the product name does not exist");
        }
    }*/
    }
        private void registerProduct () {
            sc.nextLine();
            System.out.println("register name product");

            String nameProduct = sc.nextLine();

            System.out.println("register description");

            String description = sc.nextLine();

            System.out.println("register quanty");

            int quanty = sc.nextInt();

            System.out.println(" register price");

            double price = sc.nextInt();

            System.out.println(" register number of times purchased");

            int numberOfTimesPurchased = sc.nextInt();

             boolean exit=false;

            TypeCategory category = null;
            while (!exit) {
                System.out.println("enter the type of category");
                System.out.println("1. books\n 2. beautyProducts \n 3.eats \4. drinks \n 5. clothing \n 6. electronics \n 7. games \n 8.paperwork \n 9. sports \n 10. toys \n 11 personalcare ");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        category = TypeCategory.BOOKS;
                        exit = true;
                        break;
                    case 2:
                        category = TypeCategory.BEAUTYPRODUCTS;
                        exit = true;
                        break;
                    case 3:
                        category = TypeCategory.EATS;
                        exit = true;
                        break;
                    case 4:
                        category = TypeCategory.DRINKS;
                        exit = true;
                        break;
                    case 5:
                        category = TypeCategory.CLOTHING;
                        exit = true;
                        break;
                    case 6:
                        category = TypeCategory.ELECTRONICS;
                        exit = true;
                        break;
                    case 7:
                        category = TypeCategory.GAMES;
                        exit = true;
                        break;
                    case 8:
                        category = TypeCategory.PAPERWORK;
                        exit = true;
                        break;
                    case 9:
                        category = TypeCategory.SPORTS;
                        exit = true;
                        break;
                    case 10:
                        category = TypeCategory.TOYS;
                        exit = true;
                        break;
                    case 11:
                        category = TypeCategory.PERSONALCARE;
                        exit = true;
                        break;
                    default:
                        System.out.println("you can only enter values from 1 to 11");


                }
            }
                if (Controller.registerListProduct(nameProduct, description, quanty, price, numberOfTimesPurchased, category)) {
                    System.out.println("product successfully registered");
                } else {
                    System.out.println("type correctly");
                }




        }
    }
