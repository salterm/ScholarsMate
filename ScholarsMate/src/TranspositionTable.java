/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

import java.security.SecureRandom;

public class TranspositionTable {
    public enum nodeType {EXACT, LOWERBOUND, UPPERBOUND, UNDEFINED}

    public class TranspositionTableEntry {
        public long zobristKey = 0;
        public int evalScore = 0;
        public nodeType nodeType = TranspositionTable.nodeType.UNDEFINED;
        public int depth = 0;

        public TranspositionTableEntry() {
            zobristKey = 0;
            evalScore = 0;
            nodeType = TranspositionTable.nodeType.UNDEFINED;
            depth = 0;
        }

        public TranspositionTableEntry(long zobristKey, int depth, int evalScore, nodeType nodeType) {
            this.zobristKey = zobristKey;
            this.depth = depth;
            this.evalScore = evalScore;
            this.nodeType = nodeType;
        }
    }

    private static int tableSize = 1048576;

    //Zobrist key values
    private long[][][] zobristPositionAndPiece;
    private long zobristWhitesPly;
    private long zobristBlacksPly;

    private int boardHeight;
    private int boardWidth;

    private TranspositionTableEntry[] table;

    public TranspositionTable(int boardHeight, int boardWidth, int piecesCount) {

        //DEBUG
        System.out.println("Transposition Table initialization");

        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        zobristPositionAndPiece = new long[boardHeight][boardWidth][piecesCount];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidth; j++) {
                for (int k = 0; k < piecesCount; k++) {
                    zobristPositionAndPiece[i][j][k] = random.nextLong();
                }
            }
        }
        zobristWhitesPly = random.nextLong();
        zobristBlacksPly = random.nextLong();

        table = new TranspositionTableEntry[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = new TranspositionTableEntry();
        }
    }

    public long generateZobristKey(State state) {
        //TODO: Allow update of key without recomputation
        long zobristKey = 0;

        //Key affected by side on move
        if (state.getIsWhitesPly()) {
            zobristKey ^= zobristWhitesPly;
        } else {
            zobristKey ^= zobristBlacksPly;
        }

        //Key affected by position and piece, assuming it is non-empty
        for (int row = 0; row < boardHeight; row++) {
            for (int column = 0; column < boardWidth; column++) {
                int piece = -1;
                switch (state.getPosition(row, column)) {
                    case 'p':
                        piece = 0;
                        break;
                    case 'P':
                        piece = 1;
                        break;
                    case 'r':
                        piece = 2;
                        break;
                    case 'R':
                        piece = 3;
                        break;
                    case 'n':
                        piece = 4;
                        break;
                    case 'N':
                        piece = 5;
                        break;
                    case 'b':
                        piece = 6;
                        break;
                    case 'B':
                        piece = 7;
                        break;
                    case 'q':
                        piece = 8;
                        break;
                    case 'Q':
                        piece = 9;
                        break;
                    case 'k':
                        piece = 10;
                        break;
                    case 'K':
                        piece = 11;
                        break;
                }

                //Key not changed by empty positions
                if (piece != -1) {
                    zobristKey ^= zobristPositionAndPiece[row][column][piece];
                }
            }
        }
        return zobristKey;
    }

    public TranspositionTableEntry retrieve(State state) {
        long zobristKey = generateZobristKey(state);
        int index = (int) (zobristKey % tableSize);
        if (index < 0) {
            index *= -1;
        }

        if (zobristKey == table[index].zobristKey) {
            return table[index];
        } else {
            return new TranspositionTableEntry();
        }
    }

    public void store(State state, int depth, TranspositionTable.nodeType nodeType, int evalScore) {
        long zobristKey = generateZobristKey(state);
        int index = (int) (zobristKey % tableSize);
        if (index < 0) {
            index *= -1;
        }
        if (table[index].depth <= depth) {
            table[index] = new TranspositionTableEntry(zobristKey, depth, evalScore, nodeType);
        }
    }
}