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

        ZeroMQe.start();
    }
}