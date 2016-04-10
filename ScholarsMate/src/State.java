/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/
public class State {
    public static final int boardWidth = 5;
    public static final int boardHeight = 6;
    private char[][] board;
    private int move;
    private boolean isWhitesPly;

    public State() {
        this.board = new char[boardHeight][boardWidth];
        move = 1;
        isWhitesPly = true;
    }

    public State(int move, boolean isWhitesPly, char[][] newBoard) {
        this.move = move;
        this.isWhitesPly = isWhitesPly;
        this.board = new char[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                this.board[i][j] = newBoard[i][j];
            }
        }
    }

    public void setBoard(final char[][] newBoard) {
        this.board = new char[boardHeight][boardWidth];
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                this.board[i][j] = newBoard[i][j];
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getMove() {
        return move;
    }

    public void setIsWhitesPly(boolean isWhitesPly) {
        this.isWhitesPly = isWhitesPly;
    }

    public boolean getIsWhitesPly() {
        return isWhitesPly;
    }

    public void setPosition (int row, int column, char position) throws ChessError {
        if (row < 0 || row >= boardHeight || column < 0 || column >= boardWidth) {
            throw new ChessError("Invalid board dimensions: " + row + " x " + column);
        } else {
            board[row][column] = position;
        }
    }

    public String toString() {
        String s = move + " " + (isWhitesPly ? "W" : "B") + "\n";
        for (char[] ca : board) {
            for (char c : ca) {
                s += c;
            }
            s += "\n";
        }
        assert s.length() > 39 && s.length() < 42;
        return s;
    }
}
