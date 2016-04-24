/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 5
  Michael Salter
  05/17/16
*/

/**
 * Class for returning exceptions to the user.
 */
public class ChessError extends RuntimeException {
    public ChessError(String message) {
        super(message);
    }
}
