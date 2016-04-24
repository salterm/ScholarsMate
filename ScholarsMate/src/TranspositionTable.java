/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 5
  Michael Salter
  05/17/16
*/

import java.security.SecureRandom;

public class TranspositionTable {
    public enum nodeType {EXACT, LOWERBOUND, UPPERBOUND, UNDEFINED}

    public class TranspositionTableEntry {
        public int evalScore = 0;
        public nodeType nodeType = TranspositionTable.nodeType.UNDEFINED;
        public int depth = 0;
    }

    private static int tableSize = 32768;

    //Zobrist key values
    private static long[][][] zobristPositionAndPiece;
    private static long zobristWhitesPly;
    private static long zobristBlacksPly;

    private TranspositionTableEntry[] table;

    public TranspositionTable() {
        zobristPositionAndPiece = new long[State.boardHeight][State.boardWidth][ChessEngine.validPieces.size()];
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < State.boardHeight; i++) {
            for (int j = 0; j < State.boardWidth; j++) {
                for (int k = 0; k < ChessEngine.validPieces.size(); k++) {
                    zobristPositionAndPiece[i][j][k] = random.nextLong();
                }
            }
        }
        zobristWhitesPly = random.nextLong();
        zobristBlacksPly = random.nextLong();

        table = new TranspositionTableEntry[tableSize];
    }

    public static long generateZobristKey(State state) {
        //TODO: Allow update of key without recomputation
        long zobristKey = 0;

        //Key affected by side on move
        if (state.getIsWhitesPly()) {
            zobristKey ^= zobristWhitesPly;
        } else {
            zobristKey ^= zobristBlacksPly;
        }

        //Key affected by position and piece, assuming it is non-empty
        for (int row = 0; row < State.boardHeight; row++) {
            for (int column = 0; column < State.boardWidth; column++) {
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
        return table[(int) (generateZobristKey(state) % tableSize)];
    }

    public void store(State state, int depth, TranspositionTable.nodeType nodeType, int evalScore) {
        int index = (int) (generateZobristKey(state) % tableSize);
        if (table[index].depth <= depth) {
            table[index].depth = depth;
            table[index].nodeType = nodeType;
            table[index].evalScore = evalScore;
        }
    }
}
