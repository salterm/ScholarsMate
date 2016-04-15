/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

/**
 * Class for returning exceptions to the user.
 */
public class ChessError extends RuntimeException {
    public ChessError(String message) {
        super(message);
    }
}
