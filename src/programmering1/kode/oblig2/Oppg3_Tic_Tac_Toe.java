package programmering1.kode.oblig2;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Marko
 * Date: 28.09.13
 * Time: 22:45
 */


public class Oppg3_Tic_Tac_Toe{

    // Makes the scanner available for all functions:
    public static Scanner input = new Scanner(System.in);

    public static void printBoard(int[][] board)
    {
        // prints the game brett to the screen:
        char player;

        // Looping through all the rows sc the brett:
        for (int i = 0; i < board.length; i++)
        {
            System.out.println("-------------------");
            System.out.print("|");

            // Looping through all the columns for each row:
            for (int o = 0; o < board[0].length; o++)
            {

                // Print either X, 0 or blank.
                // Based on the number stored at the current row and columns:
                if (board[i][o] == 1)
                {
                    player = 'X';
                }else if (board[i][o] == 2)
                {
                    player = 'O';
                }else
                {
                    player = ' ';
                }

                // Print one block of the brett:
                System.out.print("  " + player + "  |");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

    public static int[][] boardInput(int[][] board, int player)
    {
        int row = 0;
        int column = 0;


        // Output for user ROW (down):
        System.out.print("\nEnter a row (0, 1, 2) for player " + player + ": ");
        row = input.nextInt();

        // Output for user COLUMN (across):
        System.out.print("Enter a column (0, 1, 2) for player " + player + ": ");
        column = input.nextInt();
        System.out.println();

        // Store the player number at the chosen position:
        board[row][column] = player;

        // Display result:
        return board;
    }

    public static int checkWinner(int[][] board)
    {
        // Checks the brett for any winning combinations.
        // 0 = no winner, 1 = player 1 winner, 2 = player 2 winner:
        int winner = 0;

        // There are 8 ways to win sc Tic Tac Toe,
        // Check all possible combinations.
        // All horizontal possibilities:
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2])
            winner = board[0][0];
        if (board[1][0] == board[1][1] && board[1][1] == board[1][2])
            winner = board[1][0];
        if (board[2][0] == board[2][1] && board[2][1] == board[2][2])
            winner = board[2][0];

        // All vertical possibilities:
        if (board[0][0] == board[1][0] && board[1][0] == board[2][0])
            winner = board[0][0];
        if (board[0][1] == board[1][1] && board[1][1] == board[2][1])
            winner = board[0][1];
        if (board[0][2] == board[1][2] && board[1][2] == board[2][2])
            winner = board[0][2];

        // The two possibilities diagonal:
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            winner = board[0][0];
        if (board[2][0] == board[1][1] && board[1][1] == board[0][2])
            winner = board[2][0];

        // Display the result:
        return winner;
    }

    // Define winner:
    public static void main(String []args){
        int[][] board = new int[3][3];
        int winner = 0;
        int turns = 1;
        int currentPlayer = 1;

        // Output Introduction, with skrivUtBrettet:
        System.out.println("Welcome to a game of Tic Tac Toe!\n");
        printBoard(board);

        while (winner == 0 && turns < 10) {

            // Ask for input:
            board = boardInput(board, currentPlayer);

            // Print the brett showing the new selection:
            printBoard(board);

            // CHeck if there is a winner:
            winner = checkWinner(board);
            turns++;

            // Switch between players after each round:
            if (currentPlayer == 1)
            {
                currentPlayer = 2;
            }else
            {
                currentPlayer = 1;
            }
        }

        // If winner is 0 after 9 rounds, then it's a draw:
        if (winner == 0)
        {
            System.out.println("\nThe game is a tie!");
        }else
        {
            System.out.println("\nThe winner is Player " + winner + "!");
        }

    }
}
