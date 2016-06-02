/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

public class Move {
    public int startRow;
    public int startColumn;
    public int endRow;
    public int endColumn;
    public char captured; //The piece at the ending position before the move was executed
    public char moved; //The piece at the starting position before the move was executed

    public Move() {
        moved = '.';
        captured = '.';
        startRow = 0;
        startColumn = 0;
        endRow = 0;
        endColumn = 0;
    }

    public Move(String s, State state) throws ChessError {
        startColumn = interpretColumn(s.charAt(0));
        startRow = interpretRow(Character.getNumericValue(s.charAt(1)));

        endColumn = interpretColumn(s.charAt(3));
        endRow = interpretRow(Character.getNumericValue(s.charAt(4)));

        moved = state.getPosition(startRow, startColumn);
        captured = state.getPosition(endRow, endColumn);
    }

    public Move(int startRow, int startColumn, int endRow, int endColumn, State state) throws ChessError {
        this.startRow = startRow;
        this.startColumn = startColumn;

        this.endRow = endRow;
        this.endColumn = endColumn;

        moved = state.getPosition(startRow, startColumn);
        captured = state.getPosition(endRow, endColumn);
    }

    private int interpretColumn(char c) throws ChessError {

        switch (c) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            default:
                return -1;
        }
    }

    private int interpretRow(int i) throws ChessError {
        switch (i) {
            case 1:
                return 5;
            case 2:
                return 4;
            case 3:
                return 3;
            case 4:
                return 2;
            case 5:
                return 1;
            case 6:
                return 0;
            default:
                return -1;
        }
    }

    public String toString() {
        String s = "";
        switch (startColumn) {
            case 0:
                s += "a";
                break;
            case 1:
                s += "b";
                break;
            case 2:
                s += "c";
                break;
            case 3:
                s += "d";
                break;
            case 4:
                s += "e";
                break;
        }
        switch (startRow) {
            case 5:
                s += "1";
                break;
            case 4:
                s += "2";
                break;
            case 3:
                s += "3";
                break;
            case 2:
                s += "4";
                break;
            case 1:
                s += "5";
                break;
            case 0:
                s += "6";
                break;
        }
        s += "-";
        switch (endColumn) {
            case 0:
                s += "a";
                break;
            case 1:
                s += "b";
                break;
            case 2:
                s += "c";
                break;
            case 3:
                s += "d";
                break;
            case 4:
                s += "e";
                break;
        }
        switch (endRow) {
            case 5:
                s += "1";
                break;
            case 4:
                s += "2";
                break;
            case 3:
                s += "3";
                break;
            case 2:
                s += "4";
                break;
            case 1:
                s += "5";
                break;
            case 0:
                s += "6";
                break;
        }

        return s + "\n";
    }
}
