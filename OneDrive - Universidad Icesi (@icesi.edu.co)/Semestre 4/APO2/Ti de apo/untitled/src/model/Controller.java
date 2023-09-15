package model;
import java.util.Random;

public class Controller {

    public static int usedPipes = 0;
    private User root;

    private BoardPipe head;

    private BoardPipe tail;

    public BoardPipe realFont;

    public BoardPipe realSewer;

    private BoardPipe anterior;

    public Controller() {
    }

    public void startGame(){

        createBoardDouble();

        createBoardCuadra();

        ubicateFontSewer();

        showBoard();

    }
    /**
     * Description : Metodo iterativo para crear la lista enlazada doble.
     */
    public void createBoardDouble(){

        int num = 1;

        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){


                if(head == null){
                    head = new BoardPipe(null,i,j, num);
                    tail = head;

                    num++;
                }
                else{
                    BoardPipe box = new BoardPipe(null,i,j, num);
                    this.tail.setNext(box);
                    box.setPrevious(this.tail);
                    this.tail = box;
                    num++;

                }
            }
        }
    }

    /**
     * Description : Metodo iterativo para crear la lista enlazada cuadruple por medio de una lista enlazada doble.
     */
    public void createBoardCuadra(){

        BoardPipe anterior = new BoardPipe(null, 0, 0, 0);

        head.setPrevious(anterior);

        anterior.setNext(head);

        BoardPipe current = head;

        BoardPipe actual =  anterior;


        for(int i=1;i<=8;i++){
            for(int j=1;j<=8;j++){

                actual = actual.getNext();


                if(i == 2){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }
                else if(i == 3){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }else if(i == 4){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }else if(i == 5){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }else if(i == 6){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }else if(i == 7){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }else if(i == 8 && current.getNext() != null && actual != null){
                    actual.setAbove(current);
                    current.setUnder(actual);
                    current = current.getNext();

                }

            }

        }

    }

    /**
     * Description : Posible version recursiva de del metodo createCuadraBoard, publica.
     * Esta incompleta.
     */
    public void createCuadra(){
        BoardPipe anterior = new BoardPipe(null, 0, 0, 0);
        head.setPrevious(anterior);

        anterior.setNext(head);

        BoardPipe current = head;

        BoardPipe actual =  anterior;

        createCuadra(current, actual);
    }

    /**
     * Description : Posible version recursiva de del metodo createCuadraBoard, privada.
     * Esta incompleta.
     */
    private void createCuadra(BoardPipe current, BoardPipe actual){

        if(actual.getIndicator()<=8){
            actual = actual.getNext();
        }

        if (actual.getIndicator()>8){
            actual.setAbove(current);
            current.setUnder(actual);
            createCuadra(current.getNext(), actual.getNext());
        }
    }


    public void createBoard(){

    }

    public void ubicateFontSewer(){

        anterior = new BoardPipe(null, 0, 0, 0);

        anterior.setNext(head);

        Pipe font = new Pipe(Type.FONT_PIPE, true);

        Pipe sewer = new Pipe(Type.SEWER_PIPE, true);

        int randomNum = (int)(Math.random()*(8)+1);

        int randomNum2 = (int)(Math.random()*(8)+1);

        int randomNum3 = (int)(Math.random()*(8)+1);

        int randomNum4 = (int)(Math.random()*(8)+1);

        while(randomNum == randomNum3 || randomNum == randomNum4 && randomNum2 == randomNum3 || randomNum2 == randomNum4){

            randomNum3 = (int)(Math.random()*(8)+1);

            randomNum4 = (int)(Math.random()*(8)+1);

        }

        BoardPipe pointer = anterior;

        BoardPipe pointer2 = anterior;

        for(int i=1;i<=randomNum;i++){
            for(int j=1;j<=randomNum2;j++){

                pointer = pointer.getNext();


                if(i == randomNum && j == randomNum2){
                    pointer.setPipe(font);
                    realFont = pointer;
                }
            }
        }


        for(int i=1;i<=randomNum3;i++){
            for(int j=1;j<=randomNum4;j++){

                pointer2 = pointer2.getNext();


                if(i == randomNum3 && j == randomNum4){
                    pointer2.setPipe(sewer);
                    realSewer = pointer2;
                }
            }
        }
    }

    public void addPipe(String pipe, boolean isCircular, int row, int column) {
        int indicator = ((row-1)*8)+column;
        BoardPipe node = head;
        boolean flag = false;
        BoardPipe toAddPipe = null;

        for(int i = 1;i<=64;i++){

            if(!flag){

                if(node.getIndicator()==indicator && node != realFont && node != realSewer){
                    flag = true;
                    toAddPipe = node;
                    usedPipes++;
                }else{
                    node = node.getNext();
                }

            }
        }
        if(toAddPipe == null){
            System.out.println("You can not put a pipe on this position");
        }else{
            addPipe(pipe, isCircular, toAddPipe);
        }
    }

    public void addPipe(String pipe,boolean isCircular,BoardPipe board){
        Pipe forAdd = null;
        if(pipe == "vertical" ){
            Type type = Type.VERTICAL_PIPE;
            forAdd = new Pipe(type, isCircular);
        }
        if(pipe == "horizontal"){
            Type type = Type.HORIZONTAL_PIPE;
            forAdd = new Pipe(type, isCircular);
        }
        if( pipe == "circular"){
            Type type = Type.CIRCULAR_PIPE;
            forAdd = new Pipe(type, isCircular);
        }
        System.out.println(forAdd.getPipeType());
        board.setPipe(forAdd);
    }

    public void deletePipe(){

    }
    /**
     * Description : Imprime el tablero por medio del .toString de BoardPipe
     */
    public String showBoard() {

        String out = " ";
        BoardPipe current = new BoardPipe(null, 0, 0, 0);
        current.setNext(head);

        //Primera columna de numeros desde el 1 al 8
        for(int i = 0;i<=7;i++){
            if(i != 0){
                out += "\n";
            }
            //Primera fila de numeros desde el 1 al 8
            for(int k = 0; k<=7 && i == 0;k++){
                out += "  " + k + " ";
            }

            if(i == 0){
                out += "\n";
            }

            out += i;
            for(int j = 0; j<=7;j++){
                if(current != null){
                    current = current.getNext();
                    out +=  " " + current.toString();
                }
            }

        }
        return out;
    }

    public int calculateScore(){
        return 0;
    }
    /*public void addScoreRegister(Player player){
        NodeScore score= new NodeScore(player);
        addScore(score);
    }*/

    /*public void addScoreRegister(String nickname, int score){
        User user = new User(nickname, score);
        insertRec(root, user);
    }

    public void insertRec(User root, User user) {
        if (this.root == null) {
            this.root = new User(user);
        } else {
            insert(this.root, user);
        }
    }

    public User search(int score) {
        User node = root;
        while (node != null) {
            if (score < node.getScore()) {
                node = node.getLeft();
            } else if (score > node.getScore()) {
                node = node.getRight();
            } else {
                return node.getUser();
            }
        }
        return null;
    }

    public void printInReverseOrder() {
        printInReverseOrder(root);
    }

    private void printInReverseOrder(User node) {
        if (node != null) {
            printInReverseOrder(node.getRight());
            System.out.println(node.getUser().getNickname() + " " + node.getUser().getScore());
            printInReverseOrder(node.getLeft());
        }
    }
 */
    public String addUserScore(){
        return "";
    }

    public void simulate(){

    }
}
