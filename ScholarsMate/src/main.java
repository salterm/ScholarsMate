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
        int numGames = 2;
        int depth = 3;
        int duration = 0;
        System.out.println("Negamax calls: " + playGame("negamax", depth, duration, numGames));
        System.out.println("Alphabeta calls: " + playGame("alphabeta", depth, duration, numGames));
        System.out.println("Alphabeta with Transposition Tables calls: " + playGame("alphabetaTrans", depth, duration, numGames));


        //ZeroMQ.start();
    }

    public static long playGame(String type, int depth, int duration, int numGames) {
        if (type.equals("alphabetaTrans")) {
            ChessEngine.useTranspositionTables = true;
        } else {
            ChessEngine.useTranspositionTables = false;
        }

        long avgEvalCalls = 0;

        for (int i = 0; i < numGames; i++) {
            ChessEngine.reset();
            while (ChessEngine.winner() == '?') {
                if (type.equals("negamax")) {
                    ChessEngine.moveNegamax(depth, duration);
                } else if (type.equals("alphabeta") || type.equals("alphabetaTrans")) {
                    ChessEngine.moveAlphabeta(depth, duration);
                }
            }
            avgEvalCalls += ChessEngine.evalCalls;
        }

        return avgEvalCalls / numGames;
    }
}