import java.util.Random;
import java.util.Scanner;

public class Board {

    /**
     * Generates a random number of game pieces from 10 to 50 inclusive.
     * 
     * @return integer from 10 to 50 inclusive
     */
    public static int generatePieces() {
        Random rand = new Random();
        int pieces = rand.nextInt(41) + 10;
        return pieces;
    }

    /**
     * Asks if the players want to restart the Nim Game.
     * 
     * @return boolean with true for wanting to play and false for not.
     */
    public static boolean doRestart() {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to play again? (Y/N)");

        String choice = input.nextLine();

        while (!choice.equals("Y") && !choice.equals("N") && !choice.equals("n") && !choice.equals("y")) {
            System.out.println("Please enter Y or N.");
            choice = input.nextLine();
        }

        if (choice.equals("Y") || choice.equals("y")) {
            return true;
        } else {
            System.out.println("Thanks for playing!");
            return false;
        }
    }

    /**
     * Returns a random true or false to switch the players
     */
    public static boolean doSwitch() {
        Random rand = new Random();

        return rand.nextBoolean();
    }
}