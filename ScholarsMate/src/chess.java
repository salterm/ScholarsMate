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
    private static final char[] columnNames = {'a', 'b', 'c', 'd', 'e'};
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

    private static State gameState;

    /**
     * Set game state to starting setup.
     */
    public static void reset() {
        gameState = new State();
        gameState.setBoard(startingBoard);
        gameState.setMove(startingMove);
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
            gameState.setMove(newMove);
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
        if (gameState.getMove() > 40) {
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
        if (intX < 0 || intX > State.boardWidth - 1) {
            return false;
        }

        if (intY < 0 || intY > State.boardHeight - 1) {
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
        return 0;
    }

    /**
     * Returns list of valid moves in format: "a1-b2"
     *
     * @return list of valid moves for the current state.
     */
    public static Vector<String> moves() {
        // with reference to the state of the game and return the possible moves - one example is given below - note that a move has exactly 6 characters

        Vector<String> strOut = new Vector<String>();
        char position;

        for (int row = 0; row < State.boardHeight; row++) {
            for (int column = 0; column < State.boardWidth; column++) {
                position = gameState.getBoard()[row][column];
                if (isOwn(position)) {
                    String startPosition = columnNames[column] + row + "-";
                    switch (position) {
                        case 'p':
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getBoard()[row + 1][column])) {
                                strOut.add(startPosition + columnNames[column] + (row + 1) + "\n");
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && isEnemy(gameState.getBoard()[row + 1][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row + 1) + "\n");
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && isEnemy(gameState.getBoard()[row + 1][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row + 1) + "\n");
                            }
                            break;
                        case 'P':
                            //N
                            if (isValid(column, row - 1) && isNothing(gameState.getBoard()[row - 1][column])) {
                                strOut.add(startPosition + columnNames[column] + (row - 1) + "\n");
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && isEnemy(gameState.getBoard()[row - 1][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row - 1) + "\n");
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && isEnemy(gameState.getBoard()[row - 1][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row - 1) + "\n");
                            }
                            break;
                        case 'k':
                        case 'K':
                            //N
                            if (isValid(column, row - 1) && !isOwn(gameState.getBoard()[row - 1][column])) {
                                strOut.add(startPosition + columnNames[column] + (row - 1) + "\n");
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && !isOwn(gameState.getBoard()[row - 1][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row - 1) + "\n");
                            }
                            //E
                            if (isValid(column + 1, row) && !isOwn(gameState.getBoard()[row][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row) + "\n");
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && !isOwn(gameState.getBoard()[row + 1][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row + 1) + "\n");
                            }
                            //S
                            if (isValid(column, row + 1) && !isOwn(gameState.getBoard()[row + 1][column])) {
                                strOut.add(startPosition + columnNames[column] + (row + 1) + "\n");
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && !isOwn(gameState.getBoard()[row + 1][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row + 1) + "\n");
                            }
                            //W
                            if (isValid(column - 1, row) && !isOwn(gameState.getBoard()[row][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row) + "\n");
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && !isOwn(gameState.getBoard()[row - 1][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row - 1) + "\n");
                            }
                            break;
                        case 'q':
                        case 'Q':
                            //N
                            for (int r = row - 1, c = column; isValid(r, c); r--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(r, c); r--, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int r = row, c = column + 1; isValid(r, c); c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(r, c); r++, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1, c = column; isValid(r, c); r++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(r, c); r++, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int r = row, c = column - 1; isValid(r, c); c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(r, c); r--, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
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
                                strOut.add(startPosition + columnNames[column] + (row - 1) + "\n");
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(r, c); r--, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            if (isValid(column + 1, row) && isNothing(gameState.getBoard()[row][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row) + "\n");
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(r, c); r++, c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getBoard()[row + 1][column])) {
                                strOut.add(startPosition + columnNames[column] + (row + 1) + "\n");
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(r, c); r++, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            if (isValid(column - 1, row) && isNothing(gameState.getBoard()[row][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row) + "\n");
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(r, c); r--, c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
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
                                strOut.add(startPosition + columnNames[column - 1] + (row - 2) + "\n");
                            }
                            //NE
                            if (isValid(column + 1, row - 2) && !isOwn(gameState.getBoard()[row - 2][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row - 2) + "\n");
                            }
                            //EN
                            if (isValid(column + 2, row - 1) && !isOwn(gameState.getBoard()[row - 1][column + 2])) {
                                strOut.add(startPosition + columnNames[column + 2] + (row - 1) + "\n");
                            }
                            //ES
                            if (isValid(column + 2, row + 1) && !isOwn(gameState.getBoard()[row + 1][column + 2])) {
                                strOut.add(startPosition + columnNames[column + 2] + (row + 1) + "\n");
                            }
                            //SE
                            if (isValid(column + 1, row + 2) && !isOwn(gameState.getBoard()[row + 2][column + 1])) {
                                strOut.add(startPosition + columnNames[column + 1] + (row + 2) + "\n");
                            }
                            //SW
                            if (isValid(column - 1, row + 2) && !isOwn(gameState.getBoard()[row + 2][column - 1])) {
                                strOut.add(startPosition + columnNames[column - 1] + (row + 2) + "\n");
                            }
                            //WS
                            if (isValid(column - 2, row + 1) && !isOwn(gameState.getBoard()[row + 1][column - 2])) {
                                strOut.add(startPosition + columnNames[column - 2] + (row + 1) + "\n");
                            }
                            //WN
                            if (isValid(column - 2, row - 1) && !isOwn(gameState.getBoard()[row - 1][column - 2])) {
                                strOut.add(startPosition + columnNames[column - 2] + (row - 1) + "\n");
                            }
                            break;
                        case 'r':
                        case 'R':
                            //N
                            for (int r = row - 1, c = column; isValid(r, c); r--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int r = row, c = column + 1; isValid(r, c); c++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1, c = column; isValid(r, c); r++) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
                                    if (isEnemy(gameState.getBoard()[r][c])) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int r = row, c = column - 1; isValid(r, c); c--) {
                                if (isOwn(gameState.getBoard()[r][c])) {
                                    break;
                                } else {
                                    strOut.add(startPosition + columnNames[c] + r + "\n");
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

        return strOut;
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
        // perform the supplied move (for example "a5-a4\n") and update the state of the game / your internal variables accordingly - note that it advised to do a sanity check of the supplied move
        try {
            char firstLetter = charIn.charAt(0);
            int startColumn = -1;
            switch (firstLetter) {
                case 'a':
                    startColumn = 0;
                    break;
                case 'b':
                    startColumn = 1;
                    break;
                case 'c':
                    startColumn = 2;
                    break;
                case 'd':
                    startColumn = 3;
                    break;
                case 'e':
                    startColumn = 4;
                    break;
            }
            int startRow = charIn.charAt(1);

            //Validation test
            if (!isValid(startColumn, startRow)) {
                throw new ChessError("Invalid move: " + charIn);
            }

            char piece = gameState.getBoard()[startRow][startColumn];

            char lastLetter = charIn.charAt(3);
            int endColumn = -1;
            switch (lastLetter) {
                case 'a':
                    endColumn = 0;
                    break;
                case 'b':
                    endColumn = 1;
                    break;
                case 'c':
                    endColumn = 2;
                    break;
                case 'd':
                    endColumn = 3;
                    break;
                case 'e':
                    endColumn = 4;
                    break;
            }
            int endRow = charIn.charAt(4);

            //Validation test
            if (!isValid(startColumn, startRow)) {
                throw new ChessError("Invalid move: " + charIn);
            }

            if (piece == 'p' && endRow == State.boardHeight - 1) {
                piece = 'q';
            } else if (piece == 'P' && endRow == 0) {
                piece = 'Q';
            }


            gameState.setPosition(startRow, startColumn, '.');
            gameState.setPosition(endRow, endColumn, piece);
            boolean isWhitesPly = gameState.getIsWhitesPly();
            if (!isWhitesPly) {
                gameState.setMove(gameState.getMove() + 1);
            }
            gameState.setIsWhitesPly(!isWhitesPly);
        } catch (ChessError e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
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