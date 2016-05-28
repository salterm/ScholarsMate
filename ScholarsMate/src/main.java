/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

public class main {
    public static int intZeromq = 54372; // CHANGE THIS - OPTIONAL
    public static String clientName = "ScholarsMate";

    public static void main(String[] args) {
        assert main.intZeromq > 1024;
        assert main.intZeromq < 65535;

        assert main.clientName.length() > 2;
        assert main.clientName.length() < 16;
        assert !main.clientName.contains(" ");


        //DEBUG
        /*
        int numGames = 25;
        int depth = 6;
        int duration = 0;
        long startTime, endTime, totalStartTime, totalEndTime;

        totalStartTime = System.nanoTime();

        startTime = System.nanoTime();
        System.out.println("init start");
        ChessEngine.reset();
        endTime = System.nanoTime();
        System.out.println("init done " + ((endTime - startTime) / 1000000) + " ms");

        startTime = System.nanoTime();
        System.out.println("ab start");
        tuple alphabeta = playGame("alphabeta", depth, duration, numGames);
        endTime = System.nanoTime();
        System.out.println("ab done " + ((endTime - startTime) / 1000000) + " ms");

        startTime = System.nanoTime();
        System.out.println("abt start");
        tuple alphabetatrans = playGame("alphabetaTrans", depth, duration, numGames);
        endTime = System.nanoTime();
        System.out.println("abt done " + ((endTime - startTime) / 1000000) + " ms");

        totalEndTime = System.nanoTime();
        System.out.println("total: " + ((totalEndTime - totalStartTime) / 1000000) + " ms");

        System.out.println();
        System.out.println("Alphabeta calls: " + alphabeta.avgEvalCalls);
        System.out.println("Alphabeta with Transposition Tables calls: " + alphabetatrans.avgEvalCalls);
        System.out.println();
        System.out.println("Alphabeta moves: " + alphabeta.avgMoves);
        System.out.println("Alphabeta with Transposition Tables moves: " + alphabetatrans.avgMoves);
        */

        ZeroMQ.start();
    }

    private static class tuple {
        public long avgMoves;
        public long avgEvalCalls;

        tuple (long avgMoves, long avgEvalCalls) {
            this.avgMoves = avgMoves;
            this.avgEvalCalls = avgEvalCalls;
        }
    }

    public static tuple playGame(String type, int depth, int duration, int numGames) {
        ChessEngine.useTranspositionTables = type.equals("alphabetaTrans");

        long totalEvalCalls = 0;
        long totalMoves = 0;

        for (int i = 0; i < numGames; i++) {
            ChessEngine.reset();
            while (ChessEngine.winner() == '?') {
                if (type.equals("negamax")) {
                    ChessEngine.moveNegamax(depth, duration);
                } else if (type.equals("alphabeta") || type.equals("alphabetaTrans")) {
                    ChessEngine.moveAlphabeta(depth, duration);
                }
                totalMoves++;
            }
            System.out.println("Win: " + ChessEngine.winner() + " Move: " + ChessEngine.gameState.getMoveNumber());
            totalEvalCalls += ChessEngine.evalCalls;
        }

        return new tuple(totalMoves / numGames, totalEvalCalls / numGames);
    }
}