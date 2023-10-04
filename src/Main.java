public class Main {
    public static void main(String[] args) {
        TicTacToe obj = new TicTacToe();
        HumanPlayer p1 = new HumanPlayer("HUMAN",'X');
        AIPlayer p2 = new AIPlayer("AI",'O');
        Player cp;
        cp =p1;
        while (true){
            System.out.println(cp.name+" turn");
            cp.makeMove();
            TicTacToe.display();
            if(TicTacToe.colWin() == true || TicTacToe.rowWin() == true || TicTacToe.diagWin() == true)
            {
                System.out.println(cp.name+" won the game");
                break;
            } else if (TicTacToe.checkDraw()) {
                System.out.println("Game is Draw");
                break;
            }
            else {
                if(cp == p1){
                    cp = p2;
                }
                else {
                    cp = p1;
                }
            }
        }
    }
}