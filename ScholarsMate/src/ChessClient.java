/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

public class ChessClient {
    public static int intZeromq = 54372; // CHANGE THIS - OPTIONAL
    public static String clientName = "ScholarsMate";

    public static void main(String[] args) {
        assert ChessClient.intZeromq > 1024;
        assert ChessClient.intZeromq < 65535;

        assert ChessClient.clientName.length() > 2;
        assert ChessClient.clientName.length() < 16;
        assert !ChessClient.clientName.contains(" ");

        try {
            ZeroMQ.start();
        } catch (ChessError e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}