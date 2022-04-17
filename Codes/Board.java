
public class Board {
  
 public void startGame() {
   
    Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to 3x3 TIC TAC TOE");
        board = new String[9];
        initializeBoard();
        printBoard();
 }
}
