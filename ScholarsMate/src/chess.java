/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class chess {
    //Evaluation heuristic values
    final static int pawnValue = 100;
    final static int rookValue = 500;
    final static int knightValue = 300;
    final static int bishopValue = 300;
    final static int queenValue = 900;
    final static int kingValue = 10000;

    public static final char[] columnNames = {'a', 'b', 'c', 'd', 'e'};
    private static final char startingBoard[][] = {
            {'k', 'q', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K'}};
    private static final int startingMove = 1;
    private static final boolean startingIsWhitesPly = true;

    private static final ArrayList<Character> validPieces = new ArrayList<Character>(
            Arrays.asList('k', 'q', 'b', 'n', 'r', 'p', 'K', 'Q', 'B', 'N', 'R', 'P', '.'));
    private static final String whiteTurn = "W";
    private static final String blackTurn = "B";

    public static State gameState;

    /**
     * Set game state to starting setup.
     */
    public static void reset() {
        gameState = new State();
        gameState.setBoard(startingBoard);
        gameState.setMoveNumber(startingMove);
        gameState.setIsWhitesPly(startingIsWhitesPly);
    }

    /**
     * Returns the current state of the game as a string.
     *
     * @return String representing the current state of the game.
     */
    public static String boardGet() {
        return gameState.toString();
    }

    /**
     * Set game state to state specified by input string.
     *
     * @param strIn State as a string.
     */
    public static void boardSet(String strIn) {
        try {
            String[] strInSplit = strIn.split("\\n");

            //Validation test
            if (strInSplit.length != 7) {
                throw new ChessError("Invalid state line count: " + strInSplit.length);
            }

            String[] moveAndPly = strInSplit[0].split("\\s");

            //Validation test
            if (moveAndPly.length != 2) {
                throw new ChessError("Invalid first line: " + strInSplit[0]);
            }

            //Validation test
            for (int i = 1; i < strInSplit.length; i++) {
                String s = strInSplit[i];
                if (s.length() != 5) {
                    throw new ChessError("Invalid board line: " + s);
                }
            }

            int newMove = Integer.valueOf(moveAndPly[0]);

            //Validation test
            if (newMove < 1 || newMove > 41) {
                throw new ChessError("Invalid move number: " + newMove);
            }

            boolean newIsWhitesPly;
            if (moveAndPly[1].equals(whiteTurn)) {
                newIsWhitesPly = true;
            } else if (moveAndPly[1].equals(blackTurn)) {
                newIsWhitesPly = false;
            } else {
                //Validation test
                throw new ChessError("Invalid turn format: " + moveAndPly[1]);
            }

            char[][] newBoard = new char[State.boardHeight][State.boardWidth];
            char a;
            for (int i = 0; i < State.boardHeight; i++) {
                for (int j = 0; j < State.boardWidth; j++) {
                    a = strInSplit[i + 1].charAt(j);
                    //Validation test
                    if (!validPieces.contains(a)) {
                        throw new ChessError("Invalid game piece: " + a);
                    } else {
                        newBoard[i][j] = a;
                    }
                }
            }

            gameState.setBoard(newBoard);
            gameState.setMoveNumber(newMove);
            gameState.setIsWhitesPly(newIsWhitesPly);
        } catch (ChessError e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }

    /**
     * Determine victory status of current game state.
     * 'B' - Black wins
     * 'W' - White wins
     * '=' - Draw
     * '?' - Game is in progress
     *
     * @return Character specifying victory status of current game state.
     */
    public static char winner() {
        //Check move count
        if (gameState.getMoveNumber() > 40) {
            return '=';
        } else {
            //Check who has kings on the board
            boolean whiteHasKing = false;
            boolean blackHasKing = false;
            for (char[] ca : gameState.getBoard()) {
                for (char c : ca) {
                    if (c == 'k') {
                        blackHasKing = true;
                    } else if (c == 'K') {
                        whiteHasKing = true;
                    }

                    if (whiteHasKing && blackHasKing) {
                        break;
                    }
                }
            }

            if (blackHasKing && !whiteHasKing) {
                return 'B';
            } else if (!blackHasKing && whiteHasKing) {
                return 'W';
            } else if (!blackHasKing && !whiteHasKing) {
                // ...Hypothetically
                return '=';
            } else {
                //Check if current player has no legal moves
                if (moves().size() == 0) {
                    if (gameState.getIsWhitesPly()) {
                        return 'B';
                    } else {
                        return 'W';
                    }
                } else {
                    //Game is still open
                    return '?';
                }
            }
        }
    }

    /**
     * Checks that a move's position is within the boundaries of the game board.
     *
     * @param intX x position of a move.
     * @param intY y position of a move.
     * @return True if the move is within bounds, false otherwise.
     */
    public static boolean isValid(int intX, int intY) {
        if (intX < 0 || intX >= State.boardWidth) {
            return false;
        }

        if (intY < 0 || intY >= State.boardHeight) {
            return false;
        }

        return true;
    }

    /**
     * Determine if the position in question contains a piece belonging to the opposing player.
     *
     * @param charPiece A character denoting a board position.
     * @return True if so, false otherwise.
     */
    public static boolean isEnemy(char charPiece) {
        switch (charPiece) {
            case 'k':
            case 'q':
            case 'b':
            case 'n':
            case 'r':
            case 'p':
                if (gameState.getIsWhitesPly()) {
                    return true;
                } else {
                    return false;
                }
            case 'K':
            case 'Q':
            case 'B':
            case 'N':
            case 'R':
            case 'P':
                if (gameState.getIsWhitesPly()) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    /**
     * Determine if the position in question contains a piece belonging to the current player.
     *
     * @param charPiece A character denoting a board position.
     * @return True if so, false otherwise.
     */
    public static boolean isOwn(char charPiece) {
        switch (charPiece) {
            case 'k':
            case 'q':
            case 'b':
            case 'n':
            case 'r':
            case 'p':
                if (gameState.getIsWhitesPly()) {
                    return false;
                } else {
                    return true;
                }
            case 'K':
            case 'Q':
            case 'B':
            case 'N':
            case 'R':
            case 'P':
                if (gameState.getIsWhitesPly()) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    /**
     * Determine if the position in question is empty.
     *
     * @param charPiece A character denoting a board position.
     * @return True if so, false otherwise.
     */
    public static boolean isNothing(char charPiece) {
        if (charPiece == '.') {
            return true;
        } else {
            return false;
        }
    }

    public static int eval() {
        // with reference to the state of the game, return the the evaluation score of the side on move - note that positive means an advantage while negative means a disadvantage
        int eval = 0;
        int pieceEval = 0;
        for (char[] ca : gameState.getBoard()) {
            for (char c : ca) {
                switch (c) {
                    case 'p':
                    case 'P':
                        pieceEval = pawnValue;
                        break;
                    case 'r':
                    case 'R':
                        pieceEval = rookValue;
                        break;
                    case 'n':
                    case 'N':
                        pieceEval = knightValue;
                        break;
                    case 'b':
                    case 'B':
                        pieceEval = bishopValue;
                        break;
                    case 'q':
                    case 'Q':
                        pieceEval = queenValue;
                        break;
                    case 'k':
                    case 'K':
                        pieceEval = kingValue;
                        break;
                }

                if (isOwn(c)) {
                    eval = eval + pieceEval;

                } else if (isEnemy(c)) {
                    eval = eval - pieceEval;
                }
            }
        }
        return eval;
    }

    private static String moveBuilder(int startColumn, int startRow, int endColumn, int endRow) {
        return columnNames[startColumn] + String.valueOf(startRow + 1) + "-" + columnNames[endColumn] + String.valueOf(endRow + 1) + "\n";
    }

    /**
     * Returns list of valid moves in format: "a1-b2"
     *
     * @return list of valid moves for the current state.
     */
    public static Vector<String> moves() {
        Vector<String> outputMoveList = new Vector<String>();
        Vector<Move> moveList = new Vector<Move>();
        char position;

        for (int row = 0; row < State.boardHeight; row++) {
            for (int column = 0; column < State.boardWidth; column++) {
                position = gameState.getBoard()[row][column];
                if (isOwn(position)) {
                    switch (position) {
                        case 'p':
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getBoard()[row + 1][column])) {
                                moveList.add(new Move(row, column, row + 1, column));
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && isEnemy(gameState.getBoard()[row + 1][column + 1])) {
                                moveList.add(new Move(row, column, row + 1, column + 1));
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && isEnemy(gameState.getBoard()[row + 1][column - 1])) {
                                moveList.add(new Move(row, column, row + 1, column - 1));
                            }
                            break;
                        case 'P':
                            //N
                            if (isValid(column, row - 1) && isNothing(gameState.getBoard()[row - 1][column])) {
                                moveList.add(new Move(row, column, row - 1, column));
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && isEnemy(gameState.getBoard()[row - 1][column + 1])) {
                                moveList.add(new Move(row, column, row - 1, column + 1));
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && isEnemy(gameState.getBoard()[row - 1][column - 1])) {
                                moveList.add(new Move(row, column, row - 1, column - 1));
                            }
                            break;
                        case 'k':
                        case 'K':
                            //N
                            if (isValid(column, row - 1) && !isOwn(gameState.getBoard()[row - 1][column])) {
                                moveList.add(new Move(row, column, row - 1, column));
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && !isOwn(gameState.getBoard()[row - 1][column + 1])) {
                                moveList.add(new Move(row, column, row - 1, column + 1));
                            }
                            //E
                            if (isValid(column + 1, row) && !isOwn(gameState.getBoard()[row][column + 1])) {
                                moveList.add(new Move(row, column, (row), column + 1));
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && !isOwn(gameState.getBoard()[row + 1][column + 1])) {
                                moveList.add(new Move(row, column, row + 1, column + 1));
                            }
                            //S
                            if (isValid(column, row + 1) && !isOwn(gameState.getBoard()[row + 1][column])) {
                                moveList.add(new Move(row, column, row + 1, column));
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && !isOwn(gameState.getBoard()[row + 1][column - 1])) {
                                moveList.add(new Move(row, column, row + 1, column - 1));
                            }
                            //W
                            if (isValid(column - 1, row) && !isOwn(gameState.getBoard()[row][column - 1])) {
                                moveList.add(new Move(row, column, (row), column - 1));
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && !isOwn(gameState.getBoard()[row - 1][column - 1])) {
                                moveList.add(new Move(row, column, row - 1, column - 1));
                            }
                            break;
                        case 'q':
                        case 'Q':
                            //N
                            for (int r = row - 1, c = column; isValid(c, r); r--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(c, r); r--, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int r = row, c = column + 1; isValid(c, r); c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(c, r); r++, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1, c = column; isValid(c, r); r++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(c, r); r++, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int r = row, c = column - 1; isValid(c, r); c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(c, r); r--, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 'b':
                        case 'B':
                            //N
                            if (isValid(column, row - 1) && isNothing(gameState.getBoard()[row - 1][column])) {
                                moveList.add(new Move(row, column, row - 1, column));
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(c, r); r--, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            if (isValid(column + 1, row) && isNothing(gameState.getBoard()[row][column + 1])) {
                                moveList.add(new Move(row, column, (row), column + 1));
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(c, r); r++, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getBoard()[row + 1][column])) {
                                moveList.add(new Move(row, column, row + 1, column));
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(c, r); r++, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            if (isValid(column - 1, row) && isNothing(gameState.getBoard()[row][column - 1])) {
                                moveList.add(new Move(row, column, (row), column - 1));
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(c, r); r--, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 'n':
                        case 'N':
                            //NW
                            if (isValid(column - 1, row - 2) && !isOwn(gameState.getBoard()[row - 2][column - 1])) {
                                moveList.add(new Move(row, column, row - 2, column - 1));
                            }
                            //NE
                            if (isValid(column + 1, row - 2) && !isOwn(gameState.getBoard()[row - 2][column + 1])) {
                                moveList.add(new Move(row, column, row - 2, column + 1));
                            }
                            //EN
                            if (isValid(column + 2, row - 1) && !isOwn(gameState.getBoard()[row - 1][column + 2])) {
                                moveList.add(new Move(row, column, row - 1, column + 2));
                            }
                            //ES
                            if (isValid(column + 2, row + 1) && !isOwn(gameState.getBoard()[row + 1][column + 2])) {
                                moveList.add(new Move(row, column, row + 1, column + 2));
                            }
                            //SE
                            if (isValid(column + 1, row + 2) && !isOwn(gameState.getBoard()[row + 2][column + 1])) {
                                moveList.add(new Move(row, column, row + 2, column + 1));
                            }
                            //SW
                            if (isValid(column - 1, row + 2) && !isOwn(gameState.getBoard()[row + 2][column - 1])) {
                                moveList.add(new Move(row, column, row + 2, column - 1));
                            }
                            //WS
                            if (isValid(column - 2, row + 1) && !isOwn(gameState.getBoard()[row + 1][column - 2])) {
                                moveList.add(new Move(row, column, row + 1, column - 2));
                            }
                            //WN
                            if (isValid(column - 2, row - 1) && !isOwn(gameState.getBoard()[row - 1][column - 2])) {
                                moveList.add(new Move(row, column, row - 1, column - 2));
                            }
                            break;
                        case 'r':
                        case 'R':
                            //N
                            for (int r = row - 1, c = column; isValid(c, r); r--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int r = row, c = column + 1; isValid(c, r); c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1, c = column; isValid(c, r); r++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int r = row, c = column - 1; isValid(c, r); c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c));
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }

        for (Move m : moveList) {
            outputMoveList.add(m.toString());
        }

        return outputMoveList;
    }

    public static Vector<String> movesShuffled() {
        // with reference to the state of the game, determine the possible moves and shuffle them before returning them - note that you can call the chess.moves() function in here

        return new Vector<String>();
    }

    public static Vector<String> movesEvaluated() {
        // with reference to the state of the game, determine the possible moves and sort them in order of an increasing evaluation score before returning them - note that you can call the chess.moves() function in here

        return new Vector<String>();
    }

    public static void move(String charIn) {
        gameState.move(new Move(charIn));
    }

    public static String moveRandom() {
        // perform a random move and return it - one example output is given below - note that you can call the chess.movesShuffled() function as well as the chess.move() function in here

        return "a5-a4\n";
    }

    public static String moveGreedy() {
        // perform a greedy move and return it - one example output is given below - note that you can call the chess.movesEvaluated() function as well as the chess.move() function in here

        return "a5-a4\n";
    }

    public static String moveNegamax(int intDepth, int intDuration) {
        // perform a negamax move and return it - one example output is given below - note that you can call the the other functions in here

        return "a5-a4\n";
    }

    public static String moveAlphabeta(int intDepth, int intDuration) {
        // perform a alphabeta move and return it - one example output is given below - note that you can call the the other functions in here

        return "a5-a4\n";
    }

    public static void undo() {
        // undo the last move and update the state of the game / your internal variables accordingly - note that you need to maintain an internal variable that keeps track of the previous history for this
    }
}