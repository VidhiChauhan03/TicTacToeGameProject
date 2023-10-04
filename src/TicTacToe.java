import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    static char[][] board;
    public TicTacToe() {
        board = new char[3][3];
        inti();
    }
    public void inti(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                board[i][j] = ' ';
            }
        }
    }
    public static void display(){
        System.out.print("-------------");
        System.out.println();
        for(int i=0;i<board.length;i++){
            System.out.print("|");
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+"  |");
            }
            System.out.println();
            System.out.print("-------------");
            System.out.println();
        }
    }
    public static void markPlace(int row,int col,char mark){
                board[row][col] = mark;
//                System.out.println();
    }
    public static boolean rowWin(){
        for(int i=0;i<3;i++){
            if(board[i][0] != ' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return true;
            }
        }
        return false;
    }
    public static boolean colWin(){
        for(int i=0;i<3;i++){
            if(board[0][i] != ' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                return true;
            }
        }
        return false;
    }
    public static boolean diagWin(){
        if((board[0][0] !=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
                ||(board[0][2] != ' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])){
           return true;
        }
        return false;
    }
    static boolean checkDraw(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
abstract class Player {
    String name;
    char mark;
    abstract void makeMove();
    boolean isValid(int row, int col) {
        if (row >= 0 && row <= 2 && col >= 0 && col <= 2) {
            if (TicTacToe.board[row][col] == ' ') {
                return true;
            }
        }
        return false;
    }
}
class HumanPlayer extends Player{
    HumanPlayer(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter the row and col");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValid(row, col));
        TicTacToe.markPlace(row, col, mark);
    }
}
    class AIPlayer extends Player{
        AIPlayer(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }

        void makeMove() {
            int row;
            int col;
            do {
                Random random = new Random();
                row = random.nextInt(3);
                col = random.nextInt(3);
            } while (!isValid(row, col));
            TicTacToe.markPlace(row, col, mark);
        }
}
