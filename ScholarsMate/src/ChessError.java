/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

/**
 * Class for returning exceptions to the user.
 */
public class ChessError extends RuntimeException {
    public ChessError(String message) {
        super(message);
    }
}
