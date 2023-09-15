package ui;
import model.Controller;
import java.util.Scanner;


public class Main {

    private Scanner sc;

    private Controller cll;

    public Main(){
        sc = new Scanner(System.in);

        cll = new Controller();
    }


    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Main ppal = new Main();

        System.out.println("");


        int option=0;

        do{
            option= ppal.showMenu();
            ppal.executeOperation(option);

        }while (option!=0);



    }

    public int showMenu() {
        int option=0;


        System.out.println(
                "Main menu, please pick an option\n" +
                        "(1) New game \n" +
                        "(2) Score \n"+
                        "(0) Leave\n"
        );
        option= sc.nextInt();
        sc.nextLine();
        return option;
    }

    public int showGameMenu() {
        int optionGame=0;


        System.out.println(
                "Game menu, please pick an option\n" +
                        "(1) Put pipe \n" +
                        "(2) delete pipe \n" +
                        "(3) Simulate \n"+
                        "(0) Leave\n"
        );
        optionGame= sc.nextInt();
        sc.nextLine();
        return optionGame;
    }

    public void executeOperation(int operation) {

        switch(operation) {
            case 0:
                System.out.println("Bye!");
                break;
            case 1:
                createGame();
                break;
            case 2:
                System.out.println("1");
                break;

            default:
                System.out.println("Error, wrong option");

        }
    }


    public void executeOperationInGame(int operation) {

        switch(operation) {
            case 0:
                System.out.println("Returning to the tittle!");
                break;
            case 1:
                //addPipe();
                break;
            case 2:
                //deletePipe();
                break;
            case 3:
                //simulateGame();
                break;

            default:
                System.out.println("Error, wrong option");

        }


    }

    public void createGame(){

        System.out.println("Please input your nickname");
        String name = sc.nextLine();



        cll.startGame();

        System.out.println(cll.showBoard());

        int optionGame=0;

        boolean respuesta = false;

        do{
            optionGame = showGameMenu();
            if(optionGame == 3){
                respuesta = simulateGame();
            }else{
                executeOperationInGame(optionGame);
            }
            //executeOperationInGame(optionGame);
        }while (optionGame !=0 && !respuesta);

    }

    public boolean simulateGame(){
        return false;
    }

    public void showScores(){


    }

    public void pipeAction(){

    }

    public void deletePipe(){

    }


}