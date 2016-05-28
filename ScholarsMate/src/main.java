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

/*
        //DEBUG
        int numGames = 10;
        int depth = -1;
        int duration = 300000; //5 minutes in milliseconds
        long startTime, endTime;

        startTime = System.nanoTime();
        System.out.println("init start");
        ChessEngine.reset();
        endTime = System.nanoTime();
        System.out.println("init done " + ((endTime - startTime) / 1000000) + " ms");

        startTime = System.nanoTime();
        System.out.println("start depth: " + depth + ", games: " + numGames);
        tuple results = playGame(depth, duration, numGames);
        endTime = System.nanoTime();

        System.out.println("total: " + ((endTime - startTime) / 1000000) + " ms");

        System.out.println();
        System.out.println("Avg eval calls: " + results.avgEvalCalls);
        System.out.println("Avg moves: " + results.avgMoves);
        System.out.println("Avg move time: " + (results.avgMoveTime / 1000000) + " ms / " + (results.avgMoveTime / 1000000000) + " s");
        System.out.println("Max move time: " + (results.maxMoveTime / 1000000) + " ms / " + (results.maxMoveTime / 1000000000) + " s");
        System.out.println("Min move time: " + (results.minMoveTime / 1000000) + " ms / " + (results.minMoveTime / 1000000000) + " s");
        System.out.println("Avg game time: " + (results.avgGameTime / 1000000) + " ms / " + (results.avgGameTime / 1000000000) + " s");
        System.out.println("Max game time: " + (results.maxGameTime / 1000000) + " ms / " + (results.maxGameTime / 1000000000) + " s");
        System.out.println("Min game time: " + (results.minGameTime / 1000000) + " ms / " + (results.minGameTime / 1000000000) + " s");
*/

        ZeroMQ.start();
    }

    private static class tuple {
        public long avgMoves;
        public long avgEvalCalls;
        public long avgMoveTime;
        public long maxMoveTime;
        public long minMoveTime;
        public long avgGameTime;
        public long maxGameTime;
        public long minGameTime;

        tuple(long avgMoves, long avgEvalCalls, long avgMoveTime, long maxMoveTime, long minMoveTime, long avgGameTime, long maxGameTime, long minGameTime) {
            this.avgMoves = avgMoves;
            this.avgEvalCalls = avgEvalCalls;
            this.avgMoveTime = avgMoveTime;
            this.maxMoveTime = maxMoveTime;
            this.minMoveTime = minMoveTime;
            this.avgGameTime = avgGameTime;
            this.maxGameTime = maxGameTime;
            this.minGameTime = minGameTime;
        }
    }

    public static tuple playGame(int depth, int duration, int numGames) {
        long gameStartTime;
        long startTime;
        long endTime;
        long timeDiff;
        long avgMoveTime = 0;
        long maxMoveTime = Long.MIN_VALUE;
        long minMoveTime = Long.MAX_VALUE;
        long avgGameTime = 0;
        long maxGameTime = Long.MIN_VALUE;
        long minGameTime = Long.MAX_VALUE;
        long totalEvalCalls = 0;
        long totalMoves = 0;
        long totalGames = 0;

        Move move = null;

        for (int i = 0; i < numGames; i++) {
            ChessEngine.reset();
            int whiteRemainingTime = duration;
            int blackRemainingTime = duration;
            gameStartTime = System.nanoTime();
            while (ChessEngine.winner() == '?' && whiteRemainingTime > 0 && blackRemainingTime > 0) {
                //White's ply
                startTime = System.nanoTime();

                move = ChessEngine.moveAlphabeta(depth, whiteRemainingTime);

                endTime = System.nanoTime();

                totalMoves++;
                timeDiff = endTime - startTime;

                whiteRemainingTime -= timeDiff / 1000000;

                avgMoveTime = avgMoveTime + (timeDiff - avgMoveTime) / totalMoves;
                maxMoveTime = Math.max(maxMoveTime, timeDiff);
                minMoveTime = Math.min(minMoveTime, timeDiff);

                System.out.print((!ChessEngine.gameState.getIsWhitesPly()? "W":"B") + move.toString());
                System.out.println("Rem time: " + whiteRemainingTime + " ms");
                System.out.println(ChessEngine.gameState);

                //Black's ply
                if (ChessEngine.winner() == '?') {
                    startTime = System.nanoTime();

                    move = ChessEngine.moveAlphabeta(depth, blackRemainingTime);

                    endTime = System.nanoTime();

                    totalMoves++;
                    timeDiff = endTime - startTime;

                    blackRemainingTime -= timeDiff / 1000000;

                    avgMoveTime = avgMoveTime + (timeDiff - avgMoveTime) / totalMoves;
                    maxMoveTime = Math.max(maxMoveTime, timeDiff);
                    minMoveTime = Math.min(minMoveTime, timeDiff);

                    System.out.print((!ChessEngine.gameState.getIsWhitesPly()? "W":"B") + move.toString());
                    System.out.println("Rem time: " + blackRemainingTime + " ms");
                    System.out.println(ChessEngine.gameState);
                } else {
                    break;
                }
            }
            if (blackRemainingTime <= 0) {
                System.out.println("Black ran out of time!");
            } else if (whiteRemainingTime <= 0) {
                System.out.println("White ran out of time!");
            }

            endTime = System.nanoTime();

            totalEvalCalls += ChessEngine.evalCalls;
            totalGames++;

            timeDiff = endTime - gameStartTime;
            avgGameTime = avgGameTime + (timeDiff - avgGameTime) / totalGames;
            maxGameTime = Math.max(maxGameTime, timeDiff);
            minGameTime = Math.min(minGameTime, timeDiff);

            System.out.println("Win: " + ChessEngine.winner() + ", Moves: " + ChessEngine.gameState.getMoveNumber() + ", " + (timeDiff / 1000000) + " ms / " + (timeDiff / 1000000000) + " s");
        }

        return new tuple(totalMoves / numGames, totalEvalCalls / numGames, avgMoveTime, maxMoveTime, minMoveTime, avgGameTime, maxGameTime, minGameTime);
    }
}