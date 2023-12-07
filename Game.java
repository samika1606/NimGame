public class Game {
  private int numPieces;
  private Player player1;
  private Player player2;

  public Game() {
    numPieces = Board.generatePieces();
    player1 = new Player();
    player2 = new Player();
  }

  /** Plays the nim game */
  public void play() {
    if (Board.doSwitch()) {
      swapPlayers();
    }
    int turn = 1; 
    while (numPieces > 1){
      // 1st player
      System.out.println("There are currently " + numPieces + " pieces on the board.");
      numPieces -= player1.takePieces(numPieces);
      turn = 1;

      // 2nd player
      if (numPieces > 1){
        System.out.println("There are now currently " + numPieces + " pieces on the board.");
        numPieces -= player2.takePieces(numPieces);
        turn = 2;
      }
    }

    // if game done
    if (numPieces == 1){
      if (turn == 2) {
        System.out.println(player1.getName() + " wins!");
      }
      else {
        System.out.println(player1.getName() + " wins!");
      }

      if (player1.getScore() > player2.getScore()) {
        System.out.println(player1.getName() + " has the most points with " + player1.getScore() + " points!");
      } else if (player2.getScore() > player1.getScore()) {
        System.out.println(player2.getName() + " has the most points with " + player2.getScore() + " points!");
      } else if (player2.getScore() == player1.getScore()) {
        System.out.println("Both players got the same number of points with " + player1.getScore() + " points each!");
      } 

      // initiate restart
      if (Board.doRestart()) {
        restart();
        System.out.println();
        play();
      }
    }
  }

  /** Resets all stats */
  private void restart() {
    numPieces = Board.generatePieces();
    player1.resetScore();
    player2.resetScore();
  }

  /** Switches the players around */
  private void swapPlayers() {
    Player temp = player1;
    player1 = player2;
    player2 = temp;
  }

}