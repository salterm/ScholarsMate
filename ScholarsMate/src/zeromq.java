/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

import java.util.Vector;

import org.json.JSONObject;
import org.zeromq.ZMQ;

public class ZeroMQ {
    public static boolean boolRunning = false;

    public static void start() throws ChessError {
        ZeroMQ.boolRunning = true;

        ZMQ.Context contextHandle = ZMQ.context(1);
        ZMQ.Socket socketHandle = contextHandle.socket(ZMQ.PAIR);

        socketHandle.bind("tcp://*:" + main.intZeromq);

        do {
            JSONObject jsonobjectIn = null;
            JSONObject jsonobjectOut = new JSONObject();

            jsonobjectIn = new JSONObject(socketHandle.recvStr());

            if (jsonobjectIn.getString("strFunction").equals("ping")) {
                jsonobjectOut.put("strOut", main.clientName);

            } else if (jsonobjectIn.getString("strFunction").equals("chess_reset")) {
                ChessEngine.reset();

            } else if (jsonobjectIn.getString("strFunction").equals("chess_boardGet")) {
                jsonobjectOut.put("strOut", ChessEngine.boardGet());

            } else if (jsonobjectIn.getString("strFunction").equals("chess_boardSet")) {
                ChessEngine.boardSet(jsonobjectIn.getString("strIn"));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_winner")) {
                jsonobjectOut.put("strReturn", ChessEngine.winner() + "\0");

            } else if (jsonobjectIn.getString("strFunction").equals("chess_isValid")) {
                jsonobjectOut.put("boolReturn", ChessEngine.isValid(jsonobjectIn.getInt("intX"), jsonobjectIn.getInt("intY")));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_isEnemy")) {
                jsonobjectOut.put("boolReturn", ChessEngine.isEnemy(jsonobjectIn.getString("strPiece").charAt(0)));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_isOwn")) {
                jsonobjectOut.put("boolReturn", ChessEngine.isOwn(jsonobjectIn.getString("strPiece").charAt(0)));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_isNothing")) {
                jsonobjectOut.put("boolReturn", ChessEngine.isNothing(jsonobjectIn.getString("strPiece").charAt(0)));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_eval")) {
                jsonobjectOut.put("intReturn", ChessEngine.eval());

            } else if (jsonobjectIn.getString("strFunction").equals("chess_moves")) {
                Vector<String> strOut = ChessEngine.moves();

                jsonobjectOut.put("intOut", strOut.size());
                jsonobjectOut.put("strOut", "");

                for (String aStrOut : strOut) {
                    jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + aStrOut);
                }

            } else if (jsonobjectIn.getString("strFunction").equals("chess_movesShuffled")) {
                Vector<String> strOut = ChessEngine.movesShuffled();

                jsonobjectOut.put("intOut", strOut.size());
                jsonobjectOut.put("strOut", "");

                for (String aStrOut : strOut) {
                    jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + aStrOut);
                }

            } else if (jsonobjectIn.getString("strFunction").equals("chess_movesEvaluated")) {
                Vector<String> strOut = ChessEngine.movesEvaluated();

                jsonobjectOut.put("intOut", strOut.size());
                jsonobjectOut.put("strOut", "");

                for (String aStrOut : strOut) {
                    jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + aStrOut);
                }

            } else if (jsonobjectIn.getString("strFunction").equals("chess_move")) {
                ChessEngine.move(jsonobjectIn.getString("strIn"));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_moveRandom")) {
                jsonobjectOut.put("strOut", ChessEngine.moveRandom());

            } else if (jsonobjectIn.getString("strFunction").equals("chess_moveGreedy")) {
                jsonobjectOut.put("strOut", ChessEngine.moveGreedy());

            } else if (jsonobjectIn.getString("strFunction").equals("chess_moveNegamax")) {
                jsonobjectOut.put("strOut", ChessEngine.moveNegamax(jsonobjectIn.getInt("intDepth"), jsonobjectIn.getInt("intDuration")));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_moveAlphabeta")) {
                jsonobjectOut.put("strOut", ChessEngine.moveAlphabeta(jsonobjectIn.getInt("intDepth"), jsonobjectIn.getInt("intDuration")));

            } else if (jsonobjectIn.getString("strFunction").equals("chess_undo")) {
                ChessEngine.undo();

            }

            socketHandle.send(jsonobjectOut.toString());
        } while (ZeroMQ.boolRunning);

        socketHandle.close();
        contextHandle.term();
    }

    public static void stop() {
        ZeroMQ.boolRunning = false;
    }
}
