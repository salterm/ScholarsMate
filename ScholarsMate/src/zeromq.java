/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

import java.util.Vector;

import org.json.JSONObject;
import org.zeromq.ZMQ;

public class zeromq {
    public static boolean boolRunning = false;

    public static void start() {
        {
            zeromq.boolRunning = true;
        }

        {
            ZMQ.Context contextHandle = ZMQ.context(1);
            ZMQ.Socket socketHandle = contextHandle.socket(ZMQ.PAIR);

            {
                socketHandle.bind("tcp://*:" + main.intZeromq);
            }

            {
                do {
                    JSONObject jsonobjectIn = null;
                    JSONObject jsonobjectOut = new JSONObject();

                    {
                        jsonobjectIn = new JSONObject(socketHandle.recvStr());
                    }

                    {
                        if (jsonobjectIn.getString("strFunction").equals("ping") == true) {
                            jsonobjectOut.put("strOut", main.strName);
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_reset") == true) {
                            chess.reset();

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_boardGet") == true) {
                            jsonobjectOut.put("strOut", chess.boardGet());
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_boardSet") == true) {
                            System.out.println(jsonobjectIn.getString("strFunction") + " in: " + jsonobjectIn.getString("strIn")); //DEBUG
                            chess.boardSet(jsonobjectIn.getString("strIn"));

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_winner") == true) {
                            jsonobjectOut.put("strReturn", chess.winner() + "\0");
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_isValid") == true) {
                            jsonobjectOut.put("boolReturn", chess.isValid(jsonobjectIn.getInt("intX"), jsonobjectIn.getInt("intY")));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_isEnemy") == true) {
                            jsonobjectOut.put("boolReturn", chess.isEnemy(jsonobjectIn.getString("strPiece").charAt(0)));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_isOwn") == true) {
                            jsonobjectOut.put("boolReturn", chess.isOwn(jsonobjectIn.getString("strPiece").charAt(0)));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_isNothing") == true) {
                            jsonobjectOut.put("boolReturn", chess.isNothing(jsonobjectIn.getString("strPiece").charAt(0)));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_eval") == true) {
                            jsonobjectOut.put("intReturn", chess.eval());
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_moves") == true) {
                            Vector<String> strOut = chess.moves();

                            jsonobjectOut.put("intOut", strOut.size());
                            jsonobjectOut.put("strOut", "");

                            for (int intFor1 = 0; intFor1 < strOut.size(); intFor1 += 1) {
                                jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + strOut.get(intFor1));
                            }
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_movesShuffled") == true) {
                            Vector<String> strOut = chess.movesShuffled();

                            jsonobjectOut.put("intOut", strOut.size());
                            jsonobjectOut.put("strOut", "");

                            for (int intFor1 = 0; intFor1 < strOut.size(); intFor1 += 1) {
                                jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + strOut.get(intFor1));
                            }
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_movesEvaluated") == true) {
                            Vector<String> strOut = chess.movesEvaluated();

                            jsonobjectOut.put("intOut", strOut.size());
                            jsonobjectOut.put("strOut", "");

                            for (int intFor1 = 0; intFor1 < strOut.size(); intFor1 += 1) {
                                jsonobjectOut.put("strOut", jsonobjectOut.get("strOut") + strOut.get(intFor1));
                            }
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_move") == true) {
                            System.out.println(jsonobjectIn.getString("strFunction") + " in: " + jsonobjectIn.getString("strIn")); //DEBUG
                            chess.move(jsonobjectIn.getString("strIn"));

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_moveRandom") == true) {
                            jsonobjectOut.put("strOut", chess.moveRandom());
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_moveGreedy") == true) {
                            jsonobjectOut.put("strOut", chess.moveGreedy());
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_moveNegamax") == true) {
                            jsonobjectOut.put("strOut", chess.moveNegamax(jsonobjectIn.getInt("intDepth"), jsonobjectIn.getInt("intDuration")));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_moveAlphabeta") == true) {
                            jsonobjectOut.put("strOut", chess.moveAlphabeta(jsonobjectIn.getInt("intDepth"), jsonobjectIn.getInt("intDuration")));
                            System.out.println(jsonobjectIn.getString("strFunction") + " out: " + jsonobjectOut.toString()); //DEBUG

                        } else if (jsonobjectIn.getString("strFunction").equals("chess_undo") == true) {
                            chess.undo();

                        }
                    }

                    {
                        socketHandle.send(jsonobjectOut.toString());
                    }
                } while (zeromq.boolRunning == true);
            }

            socketHandle.close();
            contextHandle.term();
        }
    }

    public static void stop() {
        {
            zeromq.boolRunning = false;
        }
    }
}
