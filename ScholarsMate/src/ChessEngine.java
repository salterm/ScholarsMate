/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

import java.util.*;

public class ChessEngine {
    //TODO: Remove all DEBUG blocks

    //Evaluation heuristic values
    private static final int pawnValue = 100;
    private static final int rookValue = 500;
    private static final int knightValue = 300;
    private static final int bishopValue = 300;
    private static final int queenValue = 900;
    private static final int kingValue = 10000;

    private static final int infinity = 100000000;

    //Iterative deepening and timing control
    private static final int tournamentDepth = 4;
    private static final int tournamentDuration = 300000; //5 minutes, in milliseconds
    private static final int tournamentMaxDepth = 15; //The furthest ahead we look, ever.
    private static final int tournamentMinDepth = 5; //Where we begin iterative deepening and the shallowest we go, ever.
    private static final int tournamentTimeForMove = 7350; //For 40 moves, 7500ms is the average time for move; 7350 is a little shy to be on the safe side.
    private static int timeCounter = 0; //A counter to keep us from actually checking the system time too frequently
    private static final int timeCounterThreshold = 1000; //An arbitrary threshold to keep us from actually checking the system time too frequently
    private static long cachedTime = 0; //The time in milliseconds the last time we checked
    private static long tournamentTimeLimit = 0; //Future (ideally) time after which we should halt our search

    //Game rules
    public static final int boardWidth = 5; //columns
    public static final int boardHeight = 6; //rows
    public static final char[] columnNames = {'a', 'b', 'c', 'd', 'e'};
    private static final char startingBoard[][] = {
            {'k', 'q', 'b', 'n', 'r'},
            {'p', 'p', 'p', 'p', 'p'},
            {'.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.'},
            {'P', 'P', 'P', 'P', 'P'},
            {'R', 'N', 'B', 'Q', 'K'}};
    private static final int startingMoveNumber = 1;
    private static final boolean startingIsWhitesPly = true;
    public static final ArrayList<Character> validPieces = new ArrayList<>(
            Arrays.asList('k', 'q', 'b', 'n', 'r', 'p', 'K', 'Q', 'B', 'N', 'R', 'P'));
    public static final char emptySpace = '.';
    private static final String whiteTurn = "W";
    private static final String blackTurn = "B";

    private static Stack<Move> historyStack = new Stack<>();

    public static State gameState;

    //Transposition table
    private static TranspositionTable transpositionTable = new TranspositionTable(boardHeight, boardWidth, validPieces.size());

    /**
     * Set game state to starting setup.
     */
    public static void reset() {
        gameState = new State(boardHeight, boardWidth);
        gameState.setBoard(startingBoard);
        gameState.setMoveNumber(startingMoveNumber);
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
        String[] strInSplit = strIn.split("\\n");

        String[] moveAndPly = strInSplit[0].split("\\s");

        int newMove = Integer.valueOf(moveAndPly[0]);

        boolean newIsWhitesPly = moveAndPly[1].equals(whiteTurn);

        char[][] newBoard = new char[boardHeight][boardWidth];
        char a;
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                a = strInSplit[i + 1].charAt(j);
                newBoard[i][j] = a;
            }
        }

        gameState.setBoard(newBoard);
        gameState.setMoveNumber(newMove);
        gameState.setIsWhitesPly(newIsWhitesPly);
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
    public static char winner() throws ChessError {
        //Check move count, always a draw past move 41
        if (gameState.getMoveNumber() > 42) {
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
                    //Draw
                    if (gameState.getMoveNumber() == 41) {
                        return '=';
                    } else {
                        //Game is still open
                        return '?';
                    }
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
        return (intX >= 0 && intX < boardWidth && intY >= 0 && intY < boardHeight);
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
                return gameState.getIsWhitesPly();
            case 'K':
            case 'Q':
            case 'B':
            case 'N':
            case 'R':
            case 'P':
                return !gameState.getIsWhitesPly();
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
                return !gameState.getIsWhitesPly();
            case 'K':
            case 'Q':
            case 'B':
            case 'N':
            case 'R':
            case 'P':
                return gameState.getIsWhitesPly();
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
        return charPiece == '.';
    }

    /**
     * Returns a numerical score based on the value of pieces on the board, relative to the current player.
     *
     * @return the eval score.
     */
    public static int eval() {
        if (winner() == '=') {
            return 0;
        }
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

    /**
     * Returns list of valid moves in format: "a1-b2"
     *
     * @return list of valid moves for the current state.
     */
    public static Vector<Move> moves() {
        Vector<Move> moveList = new Vector<>();
        char position;

        for (int row = 0; row < boardHeight; row++) {
            for (int column = 0; column < boardWidth; column++) {
                position = gameState.getPosition(row, column);
                if (isOwn(position)) {
                    switch (position) {
                        case 'p':
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getPosition(row + 1, column))) {
                                moveList.add(new Move(row, column, row + 1, column, gameState));
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && isEnemy(gameState.getPosition(row + 1, column + 1))) {
                                moveList.add(new Move(row, column, row + 1, column + 1, gameState));
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && isEnemy(gameState.getPosition(row + 1, column - 1))) {
                                moveList.add(new Move(row, column, row + 1, column - 1, gameState));
                            }
                            break;
                        case 'P':
                            //N
                            if (isValid(column, row - 1) && isNothing(gameState.getPosition(row - 1, column))) {
                                moveList.add(new Move(row, column, row - 1, column, gameState));
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && isEnemy(gameState.getPosition(row - 1, column + 1))) {
                                moveList.add(new Move(row, column, row - 1, column + 1, gameState));
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && isEnemy(gameState.getPosition(row - 1, column - 1))) {
                                moveList.add(new Move(row, column, row - 1, column - 1, gameState));
                            }
                            break;
                        case 'k':
                        case 'K':
                            //N
                            if (isValid(column, row - 1) && !isOwn(gameState.getPosition(row - 1, column))) {
                                moveList.add(new Move(row, column, row - 1, column, gameState));
                            }
                            //NE
                            if (isValid(column + 1, row - 1) && !isOwn(gameState.getPosition(row - 1, column + 1))) {
                                moveList.add(new Move(row, column, row - 1, column + 1, gameState));
                            }
                            //E
                            if (isValid(column + 1, row) && !isOwn(gameState.getPosition(row, column + 1))) {
                                moveList.add(new Move(row, column, (row), column + 1, gameState));
                            }
                            //SE
                            if (isValid(column + 1, row + 1) && !isOwn(gameState.getPosition(row + 1, column + 1))) {
                                moveList.add(new Move(row, column, row + 1, column + 1, gameState));
                            }
                            //S
                            if (isValid(column, row + 1) && !isOwn(gameState.getPosition(row + 1, column))) {
                                moveList.add(new Move(row, column, row + 1, column, gameState));
                            }
                            //SW
                            if (isValid(column - 1, row + 1) && !isOwn(gameState.getPosition(row + 1, column - 1))) {
                                moveList.add(new Move(row, column, row + 1, column - 1, gameState));
                            }
                            //W
                            if (isValid(column - 1, row) && !isOwn(gameState.getPosition(row, column - 1))) {
                                moveList.add(new Move(row, column, (row), column - 1, gameState));
                            }
                            //NW
                            if (isValid(column - 1, row - 1) && !isOwn(gameState.getPosition(row - 1, column - 1))) {
                                moveList.add(new Move(row, column, row - 1, column - 1, gameState));
                            }
                            break;
                        case 'q':
                        case 'Q':
                            //N
                            for (int r = row - 1; isValid(column, r); r--) {
                                if (isOwn(gameState.getPosition(r, column))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, column, gameState));
                                    if (isEnemy(gameState.getPosition(r, column))) {
                                        break;
                                    }
                                }
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(c, r); r--, c++) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int c = column + 1; isValid(c, row); c++) {
                                if (isOwn(gameState.getPosition(row, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, row, c, gameState));
                                    if (isEnemy(gameState.getPosition(row, c))) {
                                        break;
                                    }
                                }
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(c, r); r++, c++) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1; isValid(column, r); r++) {
                                if (isOwn(gameState.getPosition(r, column))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, column, gameState));
                                    if (isEnemy(gameState.getPosition(r, column))) {
                                        break;
                                    }
                                }
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(c, r); r++, c--) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int c = column - 1; isValid(c, row); c--) {
                                if (isOwn(gameState.getPosition(row, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, row, c, gameState));
                                    if (isEnemy(gameState.getPosition(row, c))) {
                                        break;
                                    }
                                }
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(c, r); r--, c--) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 'b':
                        case 'B':
                            //N
                            if (isValid(column, row - 1) && isNothing(gameState.getPosition(row - 1, column))) {
                                moveList.add(new Move(row, column, row - 1, column, gameState));
                            }
                            //NE
                            for (int r = row - 1, c = column + 1; isValid(c, r); r--, c++) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //E
                            if (isValid(column + 1, row) && isNothing(gameState.getPosition(row, column + 1))) {
                                moveList.add(new Move(row, column, (row), column + 1, gameState));
                            }
                            //SE
                            for (int r = row + 1, c = column + 1; isValid(c, r); r++, c++) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //S
                            if (isValid(column, row + 1) && isNothing(gameState.getPosition(row + 1, column))) {
                                moveList.add(new Move(row, column, row + 1, column, gameState));
                            }
                            //SW
                            for (int r = row + 1, c = column - 1; isValid(c, r); r++, c--) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            //W
                            if (isValid(column - 1, row) && isNothing(gameState.getPosition(row, column - 1))) {
                                moveList.add(new Move(row, column, (row), column - 1, gameState));
                            }
                            //NW
                            for (int r = row - 1, c = column - 1; isValid(c, r); r--, c--) {
                                if (isOwn(gameState.getPosition(r, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, c, gameState));
                                    if (isEnemy(gameState.getPosition(r, c))) {
                                        break;
                                    }
                                }
                            }
                            break;
                        case 'n':
                        case 'N':
                            //NW
                            if (isValid(column - 1, row - 2) && !isOwn(gameState.getPosition(row - 2, column - 1))) {
                                moveList.add(new Move(row, column, row - 2, column - 1, gameState));
                            }
                            //NE
                            if (isValid(column + 1, row - 2) && !isOwn(gameState.getPosition(row - 2, column + 1))) {
                                moveList.add(new Move(row, column, row - 2, column + 1, gameState));
                            }
                            //EN
                            if (isValid(column + 2, row - 1) && !isOwn(gameState.getPosition(row - 1, column + 2))) {
                                moveList.add(new Move(row, column, row - 1, column + 2, gameState));
                            }
                            //ES
                            if (isValid(column + 2, row + 1) && !isOwn(gameState.getPosition(row + 1, column + 2))) {
                                moveList.add(new Move(row, column, row + 1, column + 2, gameState));
                            }
                            //SE
                            if (isValid(column + 1, row + 2) && !isOwn(gameState.getPosition(row + 2, column + 1))) {
                                moveList.add(new Move(row, column, row + 2, column + 1, gameState));
                            }
                            //SW
                            if (isValid(column - 1, row + 2) && !isOwn(gameState.getPosition(row + 2, column - 1))) {
                                moveList.add(new Move(row, column, row + 2, column - 1, gameState));
                            }
                            //WS
                            if (isValid(column - 2, row + 1) && !isOwn(gameState.getPosition(row + 1, column - 2))) {
                                moveList.add(new Move(row, column, row + 1, column - 2, gameState));
                            }
                            //WN
                            if (isValid(column - 2, row - 1) && !isOwn(gameState.getPosition(row - 1, column - 2))) {
                                moveList.add(new Move(row, column, row - 1, column - 2, gameState));
                            }
                            break;
                        case 'r':
                        case 'R':
                            //N
                            for (int r = row - 1; isValid(column, r); r--) {
                                if (isOwn(gameState.getPosition(r, column))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, column, gameState));
                                    if (isEnemy(gameState.getPosition(r, column))) {
                                        break;
                                    }
                                }
                            }
                            //E
                            for (int c = column + 1; isValid(c, row); c++) {
                                if (isOwn(gameState.getPosition(row, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, row, c, gameState));
                                    if (isEnemy(gameState.getPosition(row, c))) {
                                        break;
                                    }
                                }
                            }
                            //S
                            for (int r = row + 1; isValid(column, r); r++) {
                                if (isOwn(gameState.getPosition(r, column))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, r, column, gameState));
                                    if (isEnemy(gameState.getPosition(r, column))) {
                                        break;
                                    }
                                }
                            }
                            //W
                            for (int c = column - 1; isValid(c, row); c--) {
                                if (isOwn(gameState.getPosition(row, c))) {
                                    break;
                                } else {
                                    moveList.add(new Move(row, column, row, c, gameState));
                                    if (isEnemy(gameState.getPosition(row, c))) {
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                }
            }
        }

        return moveList;
    }

    /**
     * Randomly shuffles the list of possible moves.
     *
     * @return A vector of possible moves, randomly shuffled.
     */
    public static Vector<Move> movesShuffled() {
        Vector<Move> shuffledMoveList = moves();
        Collections.shuffle(shuffledMoveList);
        return shuffledMoveList;
    }

    /**
     * Returns a list of moves (as strings) in ascending order by their eval scores.
     *
     * @return A list of moves as strings in ascending order by their eval scores.
     */
    public static Vector<Move> movesEvaluated() {
        Vector<Move> evaluatedMoveList = movesShuffled();
        Collections.sort(evaluatedMoveList, new Comparator<Move>() {
            public int compare(Move o1, Move o2) {
                int eval1, eval2;
                move(o1);
                eval1 = eval();
                undo();
                move(o2);
                eval2 = eval();
                undo();
                return eval1 - eval2;
            }
        });
        return evaluatedMoveList;
    }

    /**
     * Executes a move.
     *
     * @param move The move in question.
     */
    public static void move(Move move) {
        if (move != null) {
            historyStack.push(move);
            gameState.move(move);
        }
    }

    /**
     * Performs a random move and returns the move as a string.
     *
     * @return The random move performed as a string.
     */
    public static Move moveRandom() {
        Move randomMove = movesShuffled().firstElement();
        move(randomMove);
        return randomMove;
    }

    /**
     * Performs a move with the highest eval score and returns the move as a string.
     *
     * @return The "best" move performed as a string.
     */
    public static Move moveGreedy() {
        Move greedyMove = movesEvaluated().firstElement();
        move(greedyMove);
        return greedyMove;
    }

    /**
     * Evaluates valid moves using an adversary search bounded by depth and duration, performs the move with the highest eval score, and returns it as a string.
     *
     * @param depth    How deep the adversary search tree should be. (-1 indicates "Tournament Mode", meaning duration will be used)
     * @param duration How much time is left to perform the search. (Ignored unless in "Tournament Mode".)
     * @return The performed move as a string.
     */
    public static Move moveNegamax(int depth, int duration) {
        //TODO Iterative deepening
        Move bestMove = null;
        int highestScore = -infinity;
        int tempScore = 0;

        if (depth == -1) {
            //TODO Tournament Mode
            depth = tournamentDepth;
        }

        for (Move move : movesShuffled()) {
            move(move);
            tempScore = -negamax(depth - 1);
            undo();

            if (tempScore > highestScore) {
                bestMove = move;
                highestScore = tempScore;
            }
        }

        move(bestMove);
        return bestMove;
    }

    /**
     * Performs negamax adversary search and returns eval score at top node level.
     *
     * @param depth How deep the adversary search tree should be.
     * @return The eval score at the top node level.
     */
    private static int negamax(int depth) {
        //TODO Iterative deepening
        if (depth == 0 || winner() != '?') {
            return eval();
        }

        int score = -infinity;
        for (Move move : movesShuffled()) {
            move(move);
            score = Math.max(score, -negamax(depth - 1));
            undo();
        }

        return score;
    }

    /**
     * Performs Negamax search, implementing alpha-beta pruning, iterative deepening, and transposition tables.
     *
     * @param depth The depth of the search tree; -1 indicates "Tournament Mode", where the function will instead use iterative deepening based on a preset duration.
     * @return
     */
    public static Move moveAlphabeta(int depth) {
        //Get the time after which we should stop trying
        cachedTime = System.currentTimeMillis();
        tournamentTimeLimit = cachedTime + tournamentTimeForMove;

        Move bestMove = null;

        //If we're in Tournament Mode
        if (depth == -1) {

            //Iteratively deepen the search until we run out of time
            for (depth = tournamentMinDepth; depth <= tournamentMaxDepth; depth++) {
                Move candidateBestMove = null;
                int alpha = -infinity;
                int beta = infinity;
                int tempScore = 0;

                //Negamax search
                try {
                    for (Move move : movesShuffled()) {
                        //Try the move
                        move(move);

                        //Evaluate the score at the deepest level of our search
                        tempScore = -alphabeta(depth - 1, -beta, -alpha);

                        //Undo the move
                        undo();

                        //If our move's score is better than the highest remembered score
                        if (tempScore > alpha) {
                            candidateBestMove = move;
                            alpha = tempScore;
                        }
                    }
                } catch (ChessTimeout e) {
                    //If we're over time, don't deepen the search!
                    //DEBUG
                    System.out.println("Depth " + depth + " " + e.getMessage());

                    undo();
                    break;
                }

                //Remember the best move found at this depth
                bestMove = candidateBestMove;
            }

            //Move and return the move
            if (bestMove == null) {
                System.out.println("Not enough time: moved greedily!");
                return moveGreedy();
            } else {
                move(bestMove);
                return bestMove;
            }
        } else {
            return moveAlphabetaUniterative(depth);
        }
    }

    private static int alphabeta(int depth, int alpha, int beta) throws ChessTimeout {
        //Try to avoid checking the time too often!
        timeCounter++;
        if (timeCounter > timeCounterThreshold) {
            timeCounter = 0;
            cachedTime = System.currentTimeMillis();
        }
        //Check whether we have time for this or not
        if (cachedTime > tournamentTimeLimit) {
            throw new ChessTimeout("Outta time!");
        }

        //If we're past our depth or the game is over, just return the eval score
        if (depth == 0 || winner() != '?') {
            return eval();
        }

        //Load from transposition table and incorporate it
        int oldAlpha = alpha;
        TranspositionTable.TranspositionTableEntry entry = transpositionTable.retrieve(gameState);
        if (entry.depth >= depth) {

            if (entry.nodeType == TranspositionTable.nodeType.EXACT) {
                return entry.evalScore;
            } else if (entry.nodeType == TranspositionTable.nodeType.LOWERBOUND) {
                alpha = Math.max(alpha, entry.evalScore);
            } else if (entry.nodeType == TranspositionTable.nodeType.UPPERBOUND) {
                beta = Math.min(beta, entry.evalScore);
            }

            if (alpha >= beta) {
                return entry.evalScore;
            }
        }

        int score = -infinity;

        //Assess possible moves, with pruning
        for (Move move : movesShuffled()) {
            move(move);
            try {
                score = Math.max(score, -alphabeta(depth - 1, -beta, -alpha));
            } catch (ChessTimeout e) {
                undo();
                throw e;
            }
            undo();

            alpha = Math.max(alpha, score);

            if (alpha >= beta) {
                break;
            }
        }

        //Store in the transposition table
        TranspositionTable.nodeType nodeType;
        if (score <= oldAlpha) {
            nodeType = TranspositionTable.nodeType.UPPERBOUND;
        } else if (score >= beta) {
            nodeType = TranspositionTable.nodeType.LOWERBOUND;
        } else {
            nodeType = TranspositionTable.nodeType.EXACT;
        }
        transpositionTable.store(gameState, depth, nodeType, score);

        return score;
    }

    /**
     * Evaluates valid moves using an adversary search bounded by depth and duration, performs the move with the highest eval score, and returns it as a string. Utilizes alpha beta search tree pruning.
     *
     * @param depth    How deep the adversary search tree should be.
     * @return The performed move as a string.
     */
    public static Move moveAlphabetaUniterative(int depth) {
        Move bestMove = null;
        int alpha = -infinity;
        int beta = infinity;
        int tempScore = 0;

        for (Move move : movesShuffled()) {

            move(move);

            tempScore = -alphabetaUniterative(depth - 1, -beta, -alpha);
            undo();

            if (tempScore > alpha) {
                bestMove = move;
                alpha = tempScore;
            }
        }

        move(bestMove);
        return bestMove;
    }

    /**
     * Performs negamax adversary search and returns eval score at top node level, utilizing alpha beta pruning and transposition tables.
     *
     * @param depth How deep the adversary search tree should be.
     * @param alpha alpha
     * @param beta  beta
     * @return The eval score at the top node level.
     */
    private static int alphabetaUniterative(int depth, int alpha, int beta) {


        if (depth == 0 || winner() != '?') {
            return eval();
        }

        //Load from transposition table and incorporate it
        int oldAlpha = alpha;
        TranspositionTable.TranspositionTableEntry entry = transpositionTable.retrieve(gameState);
        if (entry.depth >= depth) {

            if (entry.nodeType == TranspositionTable.nodeType.EXACT) {
                return entry.evalScore;
            } else if (entry.nodeType == TranspositionTable.nodeType.LOWERBOUND) {
                alpha = Math.max(alpha, entry.evalScore);
            } else if (entry.nodeType == TranspositionTable.nodeType.UPPERBOUND) {
                beta = Math.min(beta, entry.evalScore);
            }

            if (alpha >= beta) {
                return entry.evalScore;
            }
        }

        int score = -infinity;

        //Assess possible moves, with pruning
        for (Move move : movesShuffled()) {

            move(move);
            score = Math.max(score, -alphabetaUniterative(depth - 1, -beta, -alpha));
            undo();

            alpha = Math.max(alpha, score);

            if (alpha >= beta) {
                break;
            }
        }

        //Store in the transposition table
        TranspositionTable.nodeType nodeType;
        if (score <= oldAlpha) {
            nodeType = TranspositionTable.nodeType.UPPERBOUND;
        } else if (score >= beta) {
            nodeType = TranspositionTable.nodeType.LOWERBOUND;
        } else {
            nodeType = TranspositionTable.nodeType.EXACT;
        }
        transpositionTable.store(gameState, depth, nodeType, score);

        return score;
    }

    /**
     * Undo the last move and reset internal variables accordingly.
     */
    public static void undo() {
        if (!historyStack.empty()) {
            Move m = historyStack.pop();

            //Reset positions
            gameState.setPosition(m.startRow, m.startColumn, m.moved);
            gameState.setPosition(m.endRow, m.endColumn, m.captured);

            //Change the move number
            boolean isWhitesPly = gameState.getIsWhitesPly();
            if (isWhitesPly) {
                gameState.setMoveNumber(gameState.getMoveNumber() - 1);
            }

            //Change the color on move
            gameState.setIsWhitesPly(!isWhitesPly);
        }
    }
}