import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {
        Board b1 = new Board(); // An object of Board class is created.

        Scanner sc = new Scanner(System.in); // Scanner object to get user inputs.

        System.out.println("Welcome to 3x3 TIC TAC TOE");
        Board.board = new String[9]; // Size given to Static string variable
        Board.initializeBoard(); // Loads the numbers into the board as position.

        Board.printBoard(); // Prints the intial board with the positional numbers.

        while (true) {
            System.out.print("Please enter 1 to enter the game or 0 to exit the game:  ");
            try {
                int val = sc.nextInt();
                if (val == 0) {
                    System.out.println("You have exited from the game. See you again.");
                    break;
                } else if (val == 1) {
                    b1.startGame(); // Invoked startGame method of Board class.
                } else {
                    continue;
                }
            } catch (InputMismatchException e) {
                sc.nextLine(); // Clears Buffer
                continue;
            }
            sc.close();
        }
    }
}
