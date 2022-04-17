
public class Board {
  
  // New players p1 and p2 of Player class added.
    static Player p1 = new Player();
    static Player p2 = new Player();

  // Store name, and turns of the players.
    String winner = null;
    static String name, turn;
  
  //To store numbers in the board's boxes.
    static String[] board;

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

  //Method to populate the initial board with numbers as position.
    static void initializeBoard() {
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
    }

  //Method to return the player's symbol concatenated 3 times to match the rows.
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
}
