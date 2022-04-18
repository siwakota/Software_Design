import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Board {

    Scanner sc = new Scanner(System.in);        //An object of scanner class to get user inputs

    // New players p1 and p2 of Player class added.
    static Player p1 = new Player();
    static Player p2 = new Player();

    // Store name, and turns of the players.
    String winner = null;
    static String name, turn;

    // To store numbers in the board's boxes.
    static String[] board;

    // To store the slot number entered by user.
    int slotNum;

    //Prints the board
    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    // Method to populate the initial board with numbers as position.
    static void initializeBoard() {
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
    }

    // Method to return the player's symbol concatenated 3 times to match the rows.
    public static String tripleSym(String S) {
        return S.concat(S.concat(S));
    }

    static String checkWinner() {

        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            // For P1 winner
            if (line.equals(tripleSym(p1.getCharacter()))) {
                p1.setScore(1);
                return p1.getName();
            }

            // For P2 winner
            else if (line.equals(tripleSym(p2.getCharacter()))) {
                p2.setScore(1);
                return p2.getName();
            }
        }

        // For draw
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(String.valueOf(a + 1))) {
                break;
            } else if (a == 8) {
                return "draw";
            }
        }

        // To enter the Player's character at the exact place on board.
        System.out.print(name + "'s turn; Enter a slot number to place your character in: ");
        return null;
    }

    // Method to enter into the game.
    public void startGame() {

        while (true) 
        {
            //Prompts to ask player's name and character.
            System.out.print("Please enter the name of the player 1: ");
            String player1Name = sc.nextLine();
            System.out.print("Please enter your character: ");
            String sym1 = Character.toString(sc.next().charAt(0));
            sc.nextLine();
            System.out.print("Please enter the name of the player 2: ");
            String player2Name = sc.nextLine();
            System.out.print("Please enter your character: ");
            String sym2 = Character.toString(sc.next().charAt(0));
            sc.nextLine();

            //Sets Player's name and symbol
            p1.setName(player1Name);
            p1.setCharacter(sym1);
            p2.setName(player2Name);
            p2.setCharacter(sym2);

            //Displays Player's Name
            System.out.println(p1.getName() + " vs. " + p2.getName());
            System.out.println("--------------------");

            //Sets turn for the first player
            turn = p1.getCharacter();

            Board.printBoard();
            System.out.print(p1.getName()
                    + " will play first.\nPlease enter a slot number to place your character: ");

            while (winner == null) {
                try {
                    slotNum = sc.nextInt();
                    if (!(slotNum > 0 && slotNum <= 9)) {
                        sc.nextLine();
                        System.out.print("Invalid input; re-enter slot number:");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.print("Invalid input; re-enter slot number:");
                    continue;
                }

                // This game has two players p1 and p2.
                // Here is the logic to decide the turn.
                if (board[slotNum - 1].equals(String.valueOf(slotNum))) {
                    board[slotNum - 1] = turn;

                    if (turn == (p1.getCharacter())) {
                        name = p2.getName();
                        turn = p2.getCharacter();
                    } else {
                        name = p1.getName();
                        turn = p1.getCharacter();
                    }

                    sc.nextLine();
                    printBoard();
                    winner = checkWinner();
                } else {
                    sc.nextLine(); // Clears buffer
                    System.out.print("Slot already taken; re-enter slot number:");
                    continue;
                }
            }

            // If no one win or lose from both player p1 and p2.
            // then here is the logic to print "draw".
            if (winner.equalsIgnoreCase("draw")) {
                System.out.println("It's a draw! Thanks for playing.");
                System.out.print("Enter 1 to continue playing or 0 to exit: ");
                if (sc.nextInt() != 1 || sc.nextInt() == 0) {
                    break;
                }
            }

            // For winner -to display Congratulations! message and the score
            else {
                System.out.println("Congratulations! " + winner + " has won! Thanks for playing.");
                System.out.println("Scores");
                System.out.println(p1.getName() + "'s Score: " + p1.getScore());
                System.out.println(p2.getName() + "'s Score: " + p2.getScore());
                System.out.print("Enter 1 to continue playing or 0 to exit: ");
                
                if (sc.nextInt() != 1 || sc.nextInt() == 0) {
                    break;
                }
            }
        }
    }

}
