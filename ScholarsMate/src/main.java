/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
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

        try {
            ZeroMQ.start();
        } catch (ChessError e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}