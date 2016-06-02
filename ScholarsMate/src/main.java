/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

public class main {
    public static int intZeromq = 54372; // 1024 < intZeromq < 65535
    public static String clientName = "ScholarsMate"; // No spaces! 2 < length < 16

    public static void main(String[] args) {
        ZeroMQ.start();
    }
}