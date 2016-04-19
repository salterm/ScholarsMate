/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 2
  Michael Salter
  04/19/16
*/

/**
 * Class for returning exceptions to the user.
 */
public class ChessError extends RuntimeException {
    public ChessError(String message) {
        super(message);
    }
}
