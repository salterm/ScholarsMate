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

        //Validation test
        if (!ChessEngine.isValid(startColumn, startRow)) {
            throw new ChessError("Invalid starting position for move: " + s + " (" + ChessEngine.columnNames[startColumn] + "," + startRow + ")");
        }

        endColumn = interpretColumn(s.charAt(3));
        endRow = interpretRow(Character.getNumericValue(s.charAt(4)));

        //Validation test
        if (!ChessEngine.isValid(endColumn, endRow)) {
            throw new ChessError("Invalid ending position for move: " + s + " (" + ChessEngine.columnNames[endColumn] + "," + endRow + ")");
        }

        moved = state.getPosition(startRow, startColumn);
        captured = state.getPosition(endRow, endColumn);
    }

    public Move(int startRow, int startColumn, int endRow, int endColumn, State state) throws ChessError {
        //Validation test
        if (!ChessEngine.isValid(startColumn, startRow)) {
            throw new ChessError("Invalid starting position for move: " + "(" + ChessEngine.columnNames[startColumn] + "," + startRow + ")");
        }

        this.startRow = startRow;
        this.startColumn = startColumn;

        //Validation test
        if (!ChessEngine.isValid(endColumn, endRow)) {
            throw new ChessError("Invalid ending position for move: " + "(" + ChessEngine.columnNames[endColumn] + "," + endRow + ")");
        }

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
                throw new ChessError("Invalid column: " + c);
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
                throw new ChessError("Invalid row: " + i);
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
