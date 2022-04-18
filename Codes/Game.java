import java.util.InputMismatchException;
import java.util.Scanner;

public class Game 
{
    public static void main(String[] args) throws Exception 
    {
        Board b1 = new Board();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to 3x3 TIC TAC TOE");
        Board.board = new String[9];
        Board.initializeBoard();
        Board.printBoard();
        while (true) {
            System.out.print("Please enter 1 to enter the game or 0 to exit the game:  ");
            try {
                int val = sc.nextInt();
                if (val == 0) {
                    System.out.println("You have exited from the game. See you again.");
                    break;
                }
                else if (val == 1) 
                {
                   b1.startGame();
                }
                else
                {
                    continue;
                }
            } 
            catch (InputMismatchException e) 
            {
                sc.nextLine(); // Clears Buffer
                continue;
            }
            sc.close();
        }
    }
}

