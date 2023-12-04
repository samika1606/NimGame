import java.util.Scanner;
import java.util.Random;

public class Player{
  private int score;
  private String name;

  public Player(String name){ 
    this.name = name;
    score = 0;
  }

  public Player(){
    System.out.println("Enter your name: ");
    Scanner input = new Scanner(System.in);
    name = input.nextLine();

    score = 0;
  }

  /** This method gets the number of pieces the user wants to take from the pile while limiting the pieces taken to be half or less than the total number of pieces.
  @param remainingPieces - integer number of remaining pieces on the board
  @return returns the integer number of pieces the user wants to take from the pile
  */
  public int takePieces (int remainingPieces){
    System.out.println(name + "'s Turn - Enter number of pieces to take: ");
    Scanner input = new Scanner(System.in);
    int piecesTaken = getUserPieces(input);
    
    while (piecesTaken > (remainingPieces/2)) {
      System.out.println("Enter a new number of pieces, the number you selected was greater than half of the remaining amount!");
      piecesTaken = getUserPieces(input);
    }
    
    score += piecesTaken;
    return piecesTaken;
  }

  /** This method gets the number of pieces the user wants to take from the pile while making sure the user inputs an integer.
  @param input - Scanner object used to get user input
  */
  private int getUserPieces(Scanner input) {
    int pieces = 0; 
    while (pieces <= 0) {
      if (input.hasNextInt()) {
        pieces = input.nextInt();
      }
      else {
        System.out.println("Please enter a positive integer: ");
        input.nextLine();
      }
    }
    return pieces;
  }
  
  /** Returns the player's name */
  public String getName(){
    return name;
  }
  
  /** Returns the player's score */
  public int getScore(){
    return score;
  }

  /** Resets the player's score to 0 */
  public void resetScore() {
    score = 0;
  }

}