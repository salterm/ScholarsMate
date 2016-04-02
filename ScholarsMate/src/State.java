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

    public State(int move, boolean isWhitesPly, char[][] board) {
        this.move = move;
        this.isWhitesPly = isWhitesPly;
        board = new char[boardHeight][];
        for (int i = 0; i < boardHeight; i++) {
            char[] column = board[i];
            board[i] = new char[boardWidth];
            System.arraycopy(column, 0, board[i], 0, boardWidth);
        }
    }

    public void setBoard(char[][] board) {
        board = new char[boardHeight][];
        for (int i = 0; i < boardHeight; i++) {
            char[] column = board[i];
            board[i] = new char[boardWidth];
            System.arraycopy(column, 0, board[i], 0, boardWidth);
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public int getMove() {
        return this.move;
    }

    public void setIsWhitesPly(boolean isWhitesPly) {
        this.isWhitesPly = isWhitesPly;
    }

    public boolean getIsWhitesPly() {
        return isWhitesPly;
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
