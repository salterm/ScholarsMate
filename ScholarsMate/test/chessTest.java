/*
  CS 442 - Advanced AI: Combinatorial Games
  Chess player, Homework 1
  Michael Salter
  04/07/16
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import static org.junit.Assert.*;

public class chessTest {
    @Test
    public void boardGetSet() throws Exception {
        String charBuffer;

        chess.reset();
        assertEquals(chess.boardGet(), "1 W\nkqbnr\nppppp\n.....\n.....\nPPPPP\nRNBQK\n");

        chess.boardSet("12 B\n.Qbq.\np.p.r\np.B.p\n..p..\nP..PP\nR...K\n");
        assertEquals(chess.boardGet(), "12 B\n.Qbq.\np.p.r\np.B.p\n..p..\nP..PP\nR...K\n");

        chess.boardSet("16 W\nkqr..\np.p..\nB.bPP\n..Q..\nPP.KP\nR....\n");
        assertEquals(chess.boardGet(), "16 W\nkqr..\np.p..\nB.bPP\n..Q..\nPP.KP\nR....\n");

        chess.boardSet("17 B\nQ.r..\np....\n....b\n.p..p\nPPB.P\n.R.qK\n");
        assertEquals(chess.boardGet(), "17 B\nQ.r..\np....\n....b\n.p..p\nPPB.P\n.R.qK\n");

        chess.boardSet("9 B\nQ...r\npqp..\nbpP.p\nB...P\nP.PP.\nRN..K\n");
        assertEquals(chess.boardGet(), "9 B\nQ...r\npqp..\nbpP.p\nB...P\nP.PP.\nRN..K\n");

        chess.boardSet("13 W\nkq...\np..p.\n...p.\nP.n..\nR.b..\n.B..r\n");
        assertEquals(chess.boardGet(), "13 W\nkq...\np..p.\n...p.\nP.n..\nR.b..\n.B..r\n");

        chess.boardSet("14 B\nQ..n.\np..P.\n...rB\nP.q.b\n.P..P\n..RqK\n");
        assertEquals(chess.boardGet(), "14 B\nQ..n.\np..P.\n...rB\nP.q.b\n.P..P\n..RqK\n");

        chess.boardSet("12 W\nk.Bnr\n...p.\np.p.p\nP.P..\n....P\nRN..q\n");
        assertEquals(chess.boardGet(), "12 W\nk.Bnr\n...p.\np.p.p\nP.P..\n....P\nRN..q\n");

        chess.boardSet("13 B\nk..nr\np..p.\n....p\nb.pP.\nP...K\nRQ...\n");
        assertEquals(chess.boardGet(), "13 B\nk..nr\np..p.\n....p\nb.pP.\nP...K\nRQ...\n");

        chess.boardSet("15 W\nk....\n.QpB.\n.pn.r\n..pPp\nP...P\nRNQ.K\n");
        assertEquals(chess.boardGet(), "15 W\nk....\n.QpB.\n.pn.r\n..pPp\nP...P\nRNQ.K\n");

        chess.boardSet("12 W\nk..r.\npqnbp\n..P..\nB.PpP\nP..P.\nRQ..K\n");
        assertEquals(chess.boardGet(), "12 W\nk..r.\npqnbp\n..P..\nB.PpP\nP..P.\nRQ..K\n");

        chess.boardSet("13 B\n.b.n.\nk..p.\npBp.r\nP.P.p\n.R.PP\n..N.K\n");
        assertEquals(chess.boardGet(), "13 B\n.b.n.\nk..p.\npBp.r\nP.P.p\n.R.PP\n..N.K\n");

        chess.boardSet("20 W\n...nr\n...b.\nk.p.p\nB.PqP\n...P.\n.Q..K\n");
        assertEquals(chess.boardGet(), "20 W\n...nr\n...b.\nk.p.p\nB.PqP\n...P.\n.Q..K\n");

        chess.boardSet("10 W\nk...r\n.b.pp\np..Pn\nP...P\n..P.N\nRB.Qq\n");
        assertEquals(chess.boardGet(), "10 W\nk...r\n.b.pp\np..Pn\nP...P\n..P.N\nRB.Qq\n");

        chess.boardSet("17 B\n.q...\nnQpb.\np...p\nP.r.p\n.PK.N\nR.B..\n");
        assertEquals(chess.boardGet(), "17 B\n.q...\nnQpb.\np...p\nP.r.p\n.PK.N\nR.B..\n");

        chess.boardSet("15 W\nkqbnr\n..p..\npp...\nP.P.p\n.P.pK\n.RBQ.\n");
        assertEquals(chess.boardGet(), "15 W\nkqbnr\n..p..\npp...\nP.P.p\n.P.pK\n.RBQ.\n");

        chess.boardSet("11 W\nk..br\npN.pp\n..p..\nP....\n....q\nnRBQ.\n");
        assertEquals(chess.boardGet(), "11 W\nk..br\npN.pp\n..p..\nP....\n....q\nnRBQ.\n");

        chess.boardSet("12 W\nkqbn.\np..r.\nRB.P.\n....p\n..PP.\n.N.QK\n");
        assertEquals(chess.boardGet(), "12 W\nkqbn.\np..r.\nRB.P.\n....p\n..PP.\n.N.QK\n");

        chess.boardSet("19 B\nk..qr\n..PPp\n.....\n.p.p.\nP...K\n.RB..\n");
        assertEquals(chess.boardGet(), "19 B\nk..qr\n..PPp\n.....\n.p.p.\nP...K\n.RB..\n");

        chess.boardSet("15 W\nk.r..\np..p.\nBN...\nPPbpn\nR.P.P\n.....\n");
        assertEquals(chess.boardGet(), "15 W\nk.r..\np..p.\nBN...\nPPbpn\nR.P.P\n.....\n");

        chess.boardSet("18 B\nk..N.\nr....\np..pK\nPpP..\nR.P.Q\n..B..\n");
        assertEquals(chess.boardGet(), "18 B\nk..N.\nr....\np..pK\nPpP..\nR.P.Q\n..B..\n");

        chess.boardSet("15 W\nk....\npN..p\nb.r.p\n.pPQp\n.PB..\nR....\n");
        assertEquals(chess.boardGet(), "15 W\nk....\npN..p\nb.r.p\n.pPQp\n.PB..\nR....\n");

        chess.boardSet("12 W\nkqbr.\n.p...\npp.pp\nN.BP.\n..P.P\nR.Q.K\n");
        assertEquals(chess.boardGet(), "12 W\nkqbr.\n.p...\npp.pp\nN.BP.\n..P.P\nR.Q.K\n");

        chess.boardSet("5 B\n.q.nr\n.Nbpp\np.p..\n.....\nPPPPP\n.RBQK\n");
        assertEquals(chess.boardGet(), "5 B\n.q.nr\n.Nbpp\np.p..\n.....\nPPPPP\n.RBQK\n");

        chess.boardSet("12 B\nk..br\npp..p\n....P\nPpNp.\nR.BQP\n....K\n");
        assertEquals(chess.boardGet(), "12 B\nk..br\npp..p\n....P\nPpNp.\nR.BQP\n....K\n");

        chess.boardSet("6 B\nQqbnr\np.pp.\n....p\np...P\nPPPP.\nR.B.K\n");
        assertEquals(chess.boardGet(), "6 B\nQqbnr\np.pp.\n....p\np...P\nPPPP.\nR.B.K\n");

        chess.boardSet("14 W\n.q..r\n..p.p\nRpnp.\n.kPP.\n...BP\n.N..K\n");
        assertEquals(chess.boardGet(), "14 W\n.q..r\n..p.p\nRpnp.\n.kPP.\n...BP\n.N..K\n");

        chess.boardSet("15 W\nkr...\np.p..\n.qP.p\n.NPB.\nP...P\nR...K\n");
        assertEquals(chess.boardGet(), "15 W\nkr...\np.p..\n.qP.p\n.NPB.\nP...P\nR...K\n");

        chess.boardSet("15 W\n...r.\n..pQ.\npk..p\n.B...\n.P.pP\nR..n.\n");
        assertEquals(chess.boardGet(), "15 W\n...r.\n..pQ.\npk..p\n.B...\n.P.pP\nR..n.\n");

        chess.boardSet("14 B\n.qb.r\n.p...\npPP.p\nPQ..P\n...n.\nRB..K\n");
        assertEquals(chess.boardGet(), "14 B\n.qb.r\n.p...\npPP.p\nPQ..P\n...n.\nRB..K\n");

        chess.boardSet("20 B\nk..nK\np..b.\nr.qP.\nPPPp.\n.....\nRBQ..\n");
        assertEquals(chess.boardGet(), "20 B\nk..nK\np..b.\nr.qP.\nPPPp.\n.....\nRBQ..\n");

        chess.boardSet("19 W\nk.r..\n...qp\n.p.KP\npbQ.P\n.PP..\nR.BN.\n");
        assertEquals(chess.boardGet(), "19 W\nk.r..\n...qp\n.p.KP\npbQ.P\n.PP..\nR.BN.\n");

        chess.boardSet("12 W\nkq.br\n.pp.p\npP..P\nR..p.\nn.PPK\n.NBQ.\n");
        assertEquals(chess.boardGet(), "12 W\nkq.br\n.pp.p\npP..P\nR..p.\nn.PPK\n.NBQ.\n");

        chess.boardSet("17 W\n..kN.\n.p.p.\npP...\nB.Ppb\nP...K\nR....\n");
        assertEquals(chess.boardGet(), "17 W\n..kN.\n.p.p.\npP...\nB.Ppb\nP...K\nR....\n");

        chess.boardSet("14 W\nk...r\nqp.pp\n..p.n\n.PP.b\nP.BPP\nR.K..\n");
        assertEquals(chess.boardGet(), "14 W\nk...r\nqp.pp\n..p.n\n.PP.b\nP.BPP\nR.K..\n");

        chess.boardSet("13 W\n...nr\n.k...\npppqp\n....P\nPp.PK\nR.B.Q\n");
        assertEquals(chess.boardGet(), "13 W\n...nr\n.k...\npppqp\n....P\nPp.PK\nR.B.Q\n");

        chess.boardSet("14 W\nk..r.\np....\np.p.p\nq.P.P\n.R.P.\n.NBnK\n");
        assertEquals(chess.boardGet(), "14 W\nk..r.\np....\np.p.p\nq.P.P\n.R.P.\n.NBnK\n");

        chess.boardSet("4 B\nQqbnr\n..ppp\n.p...\n..P..\nPP.PP\nRNB.K\n");
        assertEquals(chess.boardGet(), "4 B\nQqbnr\n..ppp\n.p...\n..P..\nPP.PP\nRNB.K\n");

        chess.boardSet("12 W\nk..b.\n.nQ.r\np.N..\nPp...\nRPP.P\n....K\n");
        assertEquals(chess.boardGet(), "12 W\nk..b.\n.nQ.r\np.N..\nPp...\nRPP.P\n....K\n");

        chess.boardSet("17 B\n...qr\np...p\n..kb.\n..pP.\nP..PP\nR...K\n");
        assertEquals(chess.boardGet(), "17 B\n...qr\np...p\n..kb.\n..pP.\nP..PP\nR...K\n");

        chess.boardSet("16 W\nk...Q\n.Ppp.\nB...r\n..p..\nR...p\n.N..K\n");
        assertEquals(chess.boardGet(), "16 W\nk...Q\n.Ppp.\nB...r\n..p..\nR...p\n.N..K\n");

        chess.boardSet("14 W\n...nr\nqk..p\np....\nNQ...\nPPPbP\nR.KB.\n");
        assertEquals(chess.boardGet(), "14 W\n...nr\nqk..p\np....\nNQ...\nPPPbP\nR.KB.\n");

        chess.boardSet("19 B\n.r...\npk.Pq\n.pP.n\n.....\nPP...\n..R.K\n");
        assertEquals(chess.boardGet(), "19 B\n.r...\npk.Pq\n.pP.n\n.....\nPP...\n..R.K\n");

        chess.boardSet("9 W\nkq.nr\n...bp\n.p.p.\n...PB\nP...Q\nRN.q.\n");
        assertEquals(chess.boardGet(), "9 W\nkq.nr\n...bp\n.p.p.\n...PB\nP...Q\nRN.q.\n");

        chess.boardSet("13 B\nk..qr\np...p\nP.pPn\nR....\n.pP.P\n....K\n");
        assertEquals(chess.boardGet(), "13 B\nk..qr\np...p\nP.pPn\nR....\n.pP.P\n....K\n");

        chess.boardSet("14 B\nkN.nr\n.....\n.p..p\np..KP\np.PP.\nR.B..\n");
        assertEquals(chess.boardGet(), "14 B\nkN.nr\n.....\n.p..p\np..KP\np.PP.\nR.B..\n");

        chess.boardSet("19 W\nqk..r\n.n.p.\nP..Pp\n...b.\n..PK.\nRNB.Q\n");
        assertEquals(chess.boardGet(), "19 W\nqk..r\n.n.p.\nP..Pp\n...b.\n..PK.\nRNB.Q\n");

        chess.boardSet("6 W\nk.br.\npp.pp\n..p.n\n...qP\nPPPP.\nRNBQ.\n");
        assertEquals(chess.boardGet(), "6 W\nk.br.\npp.pp\n..p.n\n...qP\nPPPP.\nRNBQ.\n");

        chess.boardSet("16 B\nk....\np...r\n..R.n\n.pbP.\n.BQ.P\n.N..K\n");
        assertEquals(chess.boardGet(), "16 B\nk....\np...r\n..R.n\n.pbP.\n.BQ.P\n.N..K\n");

        chess.boardSet("18 W\nq....\n.kp..\np..b.\n..KPr\nPP.Q.\nR..N.\n");
        assertEquals(chess.boardGet(), "18 W\nq....\n.kp..\np..b.\n..KPr\nPP.Q.\nR..N.\n");

        chess.boardSet("14 W\n.k.Nr\n.....\n...Bp\n.Rp..\nP.bP.\nQ..qK\n");
        assertEquals(chess.boardGet(), "14 W\n.k.Nr\n.....\n...Bp\n.Rp..\nP.bP.\nQ..qK\n");

        chess.boardSet("16 B\n...b.\n...p.\npqPp.\npQ...\nR..Nr\n....K\n");
        assertEquals(chess.boardGet(), "16 B\n...b.\n...p.\npqPp.\npQ...\nR..Nr\n....K\n");

        chess.boardSet("15 W\nkb.nr\n....p\npp.P.\n.q..P\nP.P.Q\nR...K\n");
        assertEquals(chess.boardGet(), "15 W\nkb.nr\n....p\npp.P.\n.q..P\nP.P.Q\nR...K\n");

        chess.boardSet("15 W\nk....\npq..r\nP.n.p\n.pp..\n.PPKP\n.R..Q\n");
        assertEquals(chess.boardGet(), "15 W\nk....\npq..r\nP.n.p\n.pp..\n.PPKP\n.R..Q\n");

        chess.boardSet("17 B\nq...r\np..bp\n..kpP\np.P..\n...QP\nRNB.K\n");
        assertEquals(chess.boardGet(), "17 B\nq...r\np..bp\n..kpP\np.P..\n...QP\nRNB.K\n");

        chess.boardSet("13 B\n.qbr.\n..ppp\n.p...\n.pPPP\nRn.BK\n.N..Q\n");
        assertEquals(chess.boardGet(), "13 B\n.qbr.\n..ppp\n.p...\n.pPPP\nRn.BK\n.N..Q\n");

        chess.boardSet("19 B\n..q.r\npPQ.p\n...pP\nP..P.\nR..b.\n...nK\n");
        assertEquals(chess.boardGet(), "19 B\n..q.r\npPQ.p\n...pP\nP..P.\nR..b.\n...nK\n");

        chess.boardSet("17 W\nk...r\np..b.\n.q.p.\n..p.P\nPpQ..\nRB...\n");
        assertEquals(chess.boardGet(), "17 W\nk...r\np..b.\n.q.p.\n..p.P\nPpQ..\nRB...\n");

        chess.boardSet("21 W\n.Qk..\npnp..\np..p.\n.....\n....P\n....K\n");
        assertEquals(chess.boardGet(), "21 W\n.Qk..\npnp..\np..p.\n.....\n....P\n....K\n");

        chess.boardSet("14 W\n..knr\np...p\nPp..N\n.Bpp.\n.P.QP\nR...K\n");
        assertEquals(chess.boardGet(), "14 W\n..knr\np...p\nPp..N\n.Bpp.\n.P.QP\nR...K\n");

        chess.boardSet("19 B\n.q.nr\nk.Q..\np.p.p\nP....\n..P.P\n.B..K\n");
        assertEquals(chess.boardGet(), "19 B\n.q.nr\nk.Q..\np.p.p\nP....\n..P.P\n.B..K\n");

        chess.boardSet("20 B\n.kr..\n..p.p\n.p...\nPpp.b\nR.PQK\n.....\n");
        assertEquals(chess.boardGet(), "20 B\n.kr..\n..p.p\n.p...\nPpp.b\nR.PQK\n.....\n");

        chess.boardSet("11 B\nQ..br\n.qp.p\n..Pp.\np..P.\nRB..P\n.N..K\n");
        assertEquals(chess.boardGet(), "11 B\nQ..br\n.qp.p\n..Pp.\np..P.\nRB..P\n.N..K\n");

        chess.boardSet("7 B\nQbqnr\np.p.p\n...p.\nP.p.P\n.PPP.\nRB.K.\n");
        assertEquals(chess.boardGet(), "7 B\nQbqnr\np.p.p\n...p.\nP.p.P\n.PPP.\nRB.K.\n");

        chess.boardSet("20 B\n..r..\n..k..\nB...K\nNP...\n....P\n....R\n");
        assertEquals(chess.boardGet(), "20 B\n..r..\n..k..\nB...K\nNP...\n....P\n....R\n");

        chess.boardSet("16 W\n.kq..\np.p.r\nPbn..\nN..pP\n..qP.\n...K.\n");
        assertEquals(chess.boardGet(), "16 W\n.kq..\np.p.r\nPbn..\nN..pP\n..qP.\n...K.\n");

        chess.boardSet("13 B\nk.r..\npp...\n.b..p\nRPPpq\n...PQ\n.NB.K\n");
        assertEquals(chess.boardGet(), "13 B\nk.r..\npp...\n.b..p\nRPPpq\n...PQ\n.NB.K\n");

        chess.boardSet("19 W\nk...r\npp..p\n....n\n.q..P\nP.KbB\n....R\n");
        assertEquals(chess.boardGet(), "19 W\nk...r\npp..p\n....n\n.q..P\nP.KbB\n....R\n");

        chess.boardSet("17 W\n...nb\nkp...\np...r\nN.P.K\np....\nRB...\n");
        assertEquals(chess.boardGet(), "17 W\n...nb\nkp...\np...r\nN.P.K\np....\nRB...\n");

        chess.boardSet("15 B\nkqb.r\n....p\n..Pp.\np...P\n..PNK\nR...B\n");
        assertEquals(chess.boardGet(), "15 B\nkqb.r\n....p\n..Pp.\np...P\n..PNK\nR...B\n");

        chess.boardSet("17 W\n.kqnr\nQp...\np...p\nPp.PP\n.BP..\n..R.K\n");
        assertEquals(chess.boardGet(), "17 W\n.kqnr\nQp...\np...p\nPp.PP\n.BP..\n..R.K\n");

        chess.boardSet("11 W\nkq.nr\n.p...\n.bppp\nP.PPP\n..p.Q\nRNB..\n");
        assertEquals(chess.boardGet(), "11 W\nkq.nr\n.p...\n.bppp\nP.PPP\n..p.Q\nRNB..\n");

        chess.boardSet("21 W\n.k...\n.p..Q\n...BP\n.q...\n....n\nqN..K\n");
        assertEquals(chess.boardGet(), "21 W\n.k...\n.p..Q\n...BP\n.q...\n....n\nqN..K\n");

        chess.boardSet("13 W\nk....\n.pb.r\n....p\np...N\nPQPPP\n.RBQK\n");
        assertEquals(chess.boardGet(), "13 W\nk....\n.pb.r\n....p\np...N\nPQPPP\n.RBQK\n");

        chess.boardSet("7 W\nkq.nr\np..bp\n.p...\n.Pp.P\nP.PP.\nRNBQ.\n");
        assertEquals(chess.boardGet(), "7 W\nkq.nr\np..bp\n.p...\n.Pp.P\nP.PP.\nRNBQ.\n");

        chess.boardSet("20 W\n..k..\np....\nPp.br\nRQP..\n..P.P\n...K.\n");
        assertEquals(chess.boardGet(), "20 W\n..k..\np....\nPp.br\nRQP..\n..P.P\n...K.\n");

        chess.boardSet("12 B\nq..r.\nk.bpp\np....\n.PNP.\nP.P..\nRBQK.\n");
        assertEquals(chess.boardGet(), "12 B\nq..r.\nk.bpp\np....\n.PNP.\nP.P..\nRBQK.\n");

        chess.boardSet("19 B\n..r..\np.pqp\n.Pk.b\n...P.\n.PQKB\nR....\n");
        assertEquals(chess.boardGet(), "19 B\n..r..\np.pqp\n.Pk.b\n...P.\n.PQKB\nR....\n");

        chess.boardSet("19 B\n..r..\nkq.Pp\nPp.b.\n.PB..\n.RPK.\nQ....\n");
        assertEquals(chess.boardGet(), "19 B\n..r..\nkq.Pp\nPp.b.\n.PB..\n.RPK.\nQ....\n");

        chess.boardSet("16 W\nkq.r.\n.p.bp\np.QpP\nPPB.n\n..P..\nR...K\n");
        assertEquals(chess.boardGet(), "16 W\nkq.r.\n.p.bp\np.QpP\nPPB.n\n..P..\nR...K\n");

        chess.boardSet("11 B\n.b..r\nP.qpp\np.P..\nB.nP.\nP.N.P\nR..QK\n");
        assertEquals(chess.boardGet(), "11 B\n.b..r\nP.qpp\np.P..\nB.nP.\nP.N.P\nR..QK\n");

        chess.boardSet("21 W\n....r\n..Qpp\n.P..q\n.....\npR..P\n...kK\n");
        assertEquals(chess.boardGet(), "21 W\n....r\n..Qpp\n.P..q\n.....\npR..P\n...kK\n");

        chess.boardSet("13 B\n..b..\npkq..\n.p...\n.P.pN\n.BPP.\n..RQK\n");
        assertEquals(chess.boardGet(), "13 B\n..b..\npkq..\n.p...\n.P.pN\n.BPP.\n..RQK\n");

        chess.boardSet("17 W\nkb...\npr...\nPp.p.\n..PPK\n...Q.\nRB...\n");
        assertEquals(chess.boardGet(), "17 W\nkb...\npr...\nPp.p.\n..PPK\n...Q.\nRB...\n");

        chess.boardSet("13 B\n.kb.Q\n.qp.r\np...p\nPPK..\nRB..P\n.....\n");
        assertEquals(chess.boardGet(), "13 B\n.kb.Q\n.qp.r\np...p\nPPK..\nRB..P\n.....\n");

        chess.boardSet("7 B\nq.bnr\nQp.p.\n...pp\np....\nPPP.P\nRNB.K\n");
        assertEquals(chess.boardGet(), "7 B\nq.bnr\nQp.p.\n...pp\np....\nPPP.P\nRNB.K\n");

        chess.boardSet("21 W\nr....\nq.p.p\n...b.\nN.QPB\nk...P\nnR.K.\n");
        assertEquals(chess.boardGet(), "21 W\nr....\nq.p.p\n...b.\nN.QPB\nk...P\nnR.K.\n");

        chess.boardSet("19 W\nk.B.r\np....\n....p\nbQp.P\n.nqP.\nR..K.\n");
        assertEquals(chess.boardGet(), "19 W\nk.B.r\np....\n....p\nbQp.P\n.nqP.\nR..K.\n");

        chess.boardSet("15 B\n.nb.r\n..p..\npQ..p\np.k.q\nPPPK.\nR.B..\n");
        assertEquals(chess.boardGet(), "15 B\n.nb.r\n..p..\npQ..p\np.k.q\nPPPK.\nR.B..\n");

        chess.boardSet("14 W\n..bnr\nP...p\nk.p..\nQBPp.\nP..P.\n..Rq.\n");
        assertEquals(chess.boardGet(), "14 W\n..bnr\nP...p\nk.p..\nQBPp.\nP..P.\n..Rq.\n");

        chess.boardSet("15 B\n..q.r\nk.p..\nN..pp\nPp.pn\nRP..K\n...Q.\n");
        assertEquals(chess.boardGet(), "15 B\n..q.r\nk.p..\nN..pp\nPp.pn\nRP..K\n...Q.\n");

        chess.boardSet("14 W\nk..br\nq.p.p\nB.p..\nN.P..\n.P.PP\nR.K..\n");
        assertEquals(chess.boardGet(), "14 W\nk..br\nq.p.p\nB.p..\nN.P..\n.P.PP\nR.K..\n");

        chess.boardSet("11 B\nk..nr\n.BbNp\np....\n.Pq.P\nP..P.\nR..QK\n");
        assertEquals(chess.boardGet(), "11 B\nk..nr\n.BbNp\np....\n.Pq.P\nP..P.\nR..QK\n");

        chess.boardSet("12 B\nkq..r\n.pp.p\np..pb\nPPKP.\nR.Q.P\n.N..n\n");
        assertEquals(chess.boardGet(), "12 B\nkq..r\n.pp.p\np..pb\nPPKP.\nR.Q.P\n.N..n\n");

        chess.boardSet("5 W\nk.bnr\npp.p.\n..p.p\nNP...\nP.PP.\nRB.Qq\n");
        assertEquals(chess.boardGet(), "5 W\nk.bnr\npp.p.\n..p.p\nNP...\nP.PP.\nRB.Qq\n");

        chess.boardSet("14 W\nqkb.r\n.p..p\nppn.N\n....P\nP.PPp\nR.Q..\n");
        assertEquals(chess.boardGet(), "14 W\nqkb.r\n.p..p\nppn.N\n....P\nP.PPp\nR.Q..\n");

        chess.boardSet("13 B\n...N.\npP.br\n..pP.\n...R.\n.PBpP\n...QK\n");
        assertEquals(chess.boardGet(), "13 B\n...N.\npP.br\n..pP.\n...R.\n.PBpP\n...QK\n");

        chess.boardSet("10 B\n.q.nr\n.Pp.p\n.p.p.\nN..B.\nPPbPP\nR...K\n");
        assertEquals(chess.boardGet(), "10 B\n.q.nr\n.Pp.p\n.p.p.\nN..B.\nPPbPP\nR...K\n");

        chess.boardSet("15 B\n.k..r\nQ.b.P\np.nP.\n....P\nP..N.\nR..K.\n");
        assertEquals(chess.boardGet(), "15 B\n.k..r\nQ.b.P\np.nP.\n....P\nP..N.\nR..K.\n");

        chess.boardSet("14 W\nk.b.r\nppq.p\n..p.n\n....P\nPPBQ.\nRN...\n");
        assertEquals(chess.boardGet(), "14 W\nk.b.r\nppq.p\n..p.n\n....P\nPPBQ.\nRN...\n");
    }

    @Test
    public void winner() throws Exception {
        chess.reset();
        assertEquals(chess.winner(), '?');

        chess.boardSet("16 W\n..br.\n.n..p\nk..p.\nR.p..\n..PP.\n.NB.K\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("11 B\n.q..r\nkpbpp\np..P.\nnB...\nR.PNP\n...QK\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("13 B\n..kNr\np.p.p\n..np.\nP.bP.\n.PK.P\nR.BQ.\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("15 W\nkq..r\n.pp.p\np..Q.\nnPP..\nR.bN.\n...BK\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("14 B\n.kbQr\n.P...\n...P.\nq....\n...BP\n.q.K.\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("11 B\n.qQn.\n.Np.r\np...p\nk.P.P\nPP...\nR..BK\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("11 B\n.k.n.\np.pp.\n..b.r\n..PPp\n.B.NP\nR..KQ\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("13 B\nk..n.\np.b.p\n.pqN.\n...P.\n..PBP\n.R.QK\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("14 W\n.r...\nkqPp.\n..p.p\n..p.Q\nP.P.P\nR.B.K\n");
        assertEquals(chess.winner(), '?');

        chess.boardSet("17 B\n.Q.r.\np....\np...p\nq....\nP...K\nR..B.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\nk..b.\n....p\n....P\n...P.\nrK...\nqR...\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("25 W\nq..b.\np...p\n.k..P\nnQp..\nPR...\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("39 B\n...r.\nR.b..\n.....\nNKp..\n.....\n.Q...\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\n....b\n.....\nkp..p\n....P\n..K..\n..Nr.\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("23 W\n.kb..\n..P..\np...p\nP.p.P\n...r.\nR....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\nQ....\n.k...\np....\nQ....\n..pnK\n....R\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("36 B\n..Q..\n....P\n.....\np..K.\np....\nq....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("20 W\nk....\np.pp.\n..P..\nnP...\n.P..N\n...Qq\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("17 B\n...br\nq.pN.\nBpP.p\n....P\nq..P.\nR...K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("12 W\nk..br\np..pp\n..p..\np.BPP\nR.P..\n....q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("26 W\nk....\nq.r..\np...n\nN.pp.\nP....\nRB...\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("31 B\n.....\nqrB..\nP.ppp\nR..pP\n.....\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("10 B\n.bq.r\npN.p.\n.p..p\nPPPP.\n...B.\nR..QK\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("18 W\n..bnr\npq.P.\n.kpPp\n...qP\nP....\n.N.RB\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("17 B\n....r\n...Bp\npPp..\nN..qp\np..K.\nR.Q..\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("7 W\nkqbr.\np.ppp\n.p...\nN..P.\n.PPnP\n.RBQ.\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n.....\nQ..k.\n..p..\n..P..\n....K\n.N...\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("21 W\nk...r\n....p\np.p..\nB.P.P\nP....\n....R\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("9 B\n.Q.nr\n...bp\nP....\n.p..P\n.pP.P\nRNB.K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("31 W\n.....\np.Rqr\nk..b.\n...Qp\n..P..\n...n.\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("25 B\n..qQ.\n.r...\np....\n.BPPp\nP....\nR...K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\nQ....\n.....\n.....\n....k\n.....\n...K.\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("28 B\n....b\nR....\n.....\n.....\nq...P\nq...K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("27 B\n..bNr\n..p..\n...P.\nP...P\n..K.q\n.....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("14 W\n.qr..\npkp.b\n.pN.p\n.PpPP\nPBP..\n.R..Q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\nk....\nq....\n.....\n.K...\n.....\n....q\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("10 B\nB...r\np...p\n.P...\nQP..q\nP..Pb\nRN..K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("29 B\nB.Q..\n....p\np..rP\nP....\n.q...\nR...K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("15 B\n.q...\nnB..r\n....p\nP.p.p\n...N.\n.q.K.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\n...q.\n.....\nk..bP\np..p.\nB..K.\n.....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("27 W\n.k...\n.N...\n..q..\n.BQ..\nnP...\n.R...\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("21 W\nk.b.r\n.....\n..qpn\n..q.P\np....\n.N.BQ\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("29 W\n..r..\nkRpbp\n...pn\n...B.\n.....\n....q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\nk...r\np....\n.....\n..K..\n.PB..\n.....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("23 B\n....Q\n.qP..\np....\nP..Pp\n.B...\nRN.K.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("32 W\n.k...\n..rb.\n.....\n.....\n....q\n..q.R\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("4 B\nR.bnr\n.qppp\n.p...\n..N..\n.PPPP\n..BQK\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("17 B\n...qr\nQ.p.P\np...B\n.b..P\nPP..K\n..R..\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("22 W\nkqbnQ\n.p...\n.P...\nP...B\n....p\n.R..q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n.....\n.....\n.....\n..kK.\np....\nQ....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("39 B\n....r\n..K..\n.....\n.....\n...p.\n.....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("31 W\nrk...\np..P.\n...pR\n.....\n.BPP.\n....Q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("27 B\n.....\nr...R\np....\nP...P\n.p...\n..K..\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("37 B\n.R...\n.....\n....p\n.B..P\n..K..\n.....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("15 B\n...qr\np...p\nP.PpP\n..n..\n.Q...\nRB..K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\n.k...\np.K..\n.....\n.....\n..p.q\n.....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("41 W\nn..r.\nk...K\nb.q..\n.....\n.....\nq.B..\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("18 B\nQ..N.\np....\n.pr..\nP.p.P\nRKb.P\nB..n.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("17 W\nkb..r\nR.q.p\n.p.P.\n.PPPn\n.PN.B\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("6 B\n.qbnr\npP...\n.p.pp\nP....\n..PPP\nRNBQK\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("21 B\nB....\nP....\np...b\nPpn..\n..P..\n..R.K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("8 W\nkq.nr\np...p\n..p.b\nNpPP.\nPP.pQ\nR.B..\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("18 B\n.Q...\np.q..\nP.pp.\np.K..\n.RP..\n.NB..\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\nQ..k.\n.....\n....p\n...Q.\n..q.P\n....K\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("31 B\n.....\n.....\n.PP..\nR...B\n.Q...\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("28 B\n..b..\n.R.K.\np.p.p\nP....\n.....\n.....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("27 B\n.r...\n.....\nP..pp\nR...P\n...P.\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("9 B\n.Q.br\n...pp\np..Pn\nq.N..\nPPP.P\nR.BK.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("30 W\n.b...\n.....\n....k\nPNp..\n....P\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("13 B\nq.b.r\n.Pp.p\np..pP\nP...K\n..P.P\n.RBQ.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("12 B\n...nr\nRbppp\n.....\n..QP.\n.P..P\n..B.K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("13 B\nB...r\np..p.\n....n\n.P.P.\nP..b.\n.R..K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("26 B\n.....\n..p.p\nQ...r\n...P.\nP...P\nKn...\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("30 B\n.....\np...p\nP.Q.q\n...Q.\n.R...\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("5 W\nkqb.r\nppp..\n...pp\n..NP.\nPPPnP\nRB.Q.\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("23 B\n..qr.\n..P..\nQ...p\nN..bP\nPR...\nB...K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("21 W\n...kr\n....B\n...Nb\np..P.\nPRppP\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("39 W\n.k...\n.....\n.p..R\n..q..\n....q\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("32 B\n.....\n...P.\nQ.rKb\n..q.P\np....\n.....\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("38 W\n.....\nP..Q.\nB..r.\n...pP\n.p.k.\n.R...\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n...n.\n.p.p.\n.P.kb\nPR..N\n....P\n....K\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("25 W\nkb.nr\n.....\npQ...\nP...p\nR.P.P\n.....\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n.....\n.k...\n.qr..\n.....\n..p..\n.R...\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("14 W\n.k...\np.Prp\nR..PN\n.p.P.\n..P..\n.B.Qb\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n.....\nkqp..\n...r.\n.p..p\n.Kn..\n.....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("34 B\n.....\n.....\np...Q\nP....\nB....\n...K.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("12 W\nk.bnr\n.pp.p\np.Pp.\nN..PP\nPPQ..\n.R..q\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("41 W\n.....\np....\nkq...\n.....\n...K.\n.....\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("31 W\n.....\nkr..p\np...p\nq...p\nP.q..\n....R\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("30 B\n.r.Q.\n.N...\np..R.\n..P.Q\nP....\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("11 B\n..bnr\nQpPpp\n..p..\nRB.q.\n.PP..\n.N..K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("23 B\n.q...\n.Nb..\n.....\nPQp.p\nRPP.K\n..B..\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("41 W\n..Q..\n..k..\np....\nP.r..\nq...P\n.B..K\n");
        assertEquals(chess.winner(), '=');

        chess.boardSet("28 B\n.....\np..rq\nN....\n.PB.p\n...nP\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("7 B\n..bnr\np..pp\nPp...\n..Nq.\nP..PP\nR.BQK\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("30 B\n.N...\n..P.Q\n...B.\nPp..P\n.....\n....K\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("20 B\n..r..\n.Q...\n....P\n.qPP.\nPN...\nR.BK.\n");
        assertEquals(chess.winner(), 'W');

        chess.boardSet("19 W\nk...r\nppp..\n.P..p\nPbR.P\n..Pq.\n.Q...\n");
        assertEquals(chess.winner(), 'B');

        chess.boardSet("21 W\n.k..r\n....Q\nPpN.P\n.....\nP.P.n\n.R...\n");
        assertEquals(chess.winner(), 'B');
    }

    @Test
    public void isValid() throws Exception {
        chess.reset();

        for (int i = -1; i < 6; i++) {
            for (int j = -1; j < 7; j++) {
                boolean valid = true;

                if (i < 0) {
                    valid = false;
                } else if (i > 4) {
                    valid = false;
                }

                if (j < 0) {
                    valid = false;
                } else if (j > 5) {
                    valid = false;
                }

                assertEquals(chess.isValid(i, j), valid);
            }
        }
    }

    @Test
    public void isEnemy() throws Exception {
        chess.reset();
        assertTrue(chess.isEnemy('k'));
        assertTrue(chess.isEnemy('q'));
        assertTrue(chess.isEnemy('b'));
        assertTrue(chess.isEnemy('n'));
        assertTrue(chess.isEnemy('r'));
        assertTrue(chess.isEnemy('p'));
        assertFalse(chess.isEnemy('K'));
        assertFalse(chess.isEnemy('Q'));
        assertFalse(chess.isEnemy('B'));
        assertFalse(chess.isEnemy('N'));
        assertFalse(chess.isEnemy('R'));
        assertFalse(chess.isEnemy('P'));
        assertFalse(chess.isEnemy('.'));

        chess.gameState.setIsWhitesPly(false);
        assertFalse(chess.isEnemy('k'));
        assertFalse(chess.isEnemy('q'));
        assertFalse(chess.isEnemy('b'));
        assertFalse(chess.isEnemy('n'));
        assertFalse(chess.isEnemy('r'));
        assertFalse(chess.isEnemy('p'));
        assertTrue(chess.isEnemy('K'));
        assertTrue(chess.isEnemy('Q'));
        assertTrue(chess.isEnemy('B'));
        assertTrue(chess.isEnemy('N'));
        assertTrue(chess.isEnemy('R'));
        assertTrue(chess.isEnemy('P'));
        assertFalse(chess.isEnemy('.'));
    }

    @Test
    public void isOwn() throws Exception {
        chess.reset();
        assertFalse(chess.isOwn('k'));
        assertFalse(chess.isOwn('q'));
        assertFalse(chess.isOwn('b'));
        assertFalse(chess.isOwn('n'));
        assertFalse(chess.isOwn('r'));
        assertFalse(chess.isOwn('p'));
        assertTrue(chess.isOwn('K'));
        assertTrue(chess.isOwn('Q'));
        assertTrue(chess.isOwn('B'));
        assertTrue(chess.isOwn('N'));
        assertTrue(chess.isOwn('R'));
        assertTrue(chess.isOwn('P'));
        assertFalse(chess.isOwn('.'));

        chess.gameState.setIsWhitesPly(false);
        assertTrue(chess.isOwn('k'));
        assertTrue(chess.isOwn('q'));
        assertTrue(chess.isOwn('b'));
        assertTrue(chess.isOwn('n'));
        assertTrue(chess.isOwn('r'));
        assertTrue(chess.isOwn('p'));
        assertFalse(chess.isOwn('K'));
        assertFalse(chess.isOwn('Q'));
        assertFalse(chess.isOwn('B'));
        assertFalse(chess.isOwn('N'));
        assertFalse(chess.isOwn('R'));
        assertFalse(chess.isOwn('P'));
        assertFalse(chess.isOwn('.'));
    }

    @Test
    public void isNothing() throws Exception {
        chess.reset();
        assertFalse(chess.isNothing('k'));
        assertFalse(chess.isNothing('q'));
        assertFalse(chess.isNothing('b'));
        assertFalse(chess.isNothing('n'));
        assertFalse(chess.isNothing('r'));
        assertFalse(chess.isNothing('p'));
        assertFalse(chess.isNothing('K'));
        assertFalse(chess.isNothing('Q'));
        assertFalse(chess.isNothing('B'));
        assertFalse(chess.isNothing('N'));
        assertFalse(chess.isNothing('R'));
        assertFalse(chess.isNothing('P'));
        assertTrue(chess.isNothing('.'));

        chess.gameState.setIsWhitesPly(false);
        assertFalse(chess.isNothing('k'));
        assertFalse(chess.isNothing('q'));
        assertFalse(chess.isNothing('b'));
        assertFalse(chess.isNothing('n'));
        assertFalse(chess.isNothing('r'));
        assertFalse(chess.isNothing('p'));
        assertFalse(chess.isNothing('K'));
        assertFalse(chess.isNothing('Q'));
        assertFalse(chess.isNothing('B'));
        assertFalse(chess.isNothing('N'));
        assertFalse(chess.isNothing('R'));
        assertFalse(chess.isNothing('P'));
        assertTrue(chess.isNothing('.'));
    }

    @Test
    public void eval() throws Exception {
        chess.reset();
        assertFalse(chess.eval() != 0);

        chess.boardSet("1 B\nkqbnr\nppppp\n.....\n.....\nPPPPP\nRNBQK\n");
        assertFalse(chess.eval() != 0);

        chess.boardSet("1 W\nkqbnr\nppppp\n.....\n.....\nPPPPP\nRNBQ.\n");
        assertFalse(chess.eval() >= 0);

        chess.boardSet("1 B\nkqbnr\nppppp\n.....\n.....\nPPPPP\nRNBQ.\n");
        assertFalse(chess.eval() <= 0);

        chess.boardSet("1 W\n.qbnr\nppppp\n.....\n.....\nPPPPP\nRNBQK\n");
        assertFalse(chess.eval() <= 0);

        chess.boardSet("1 B\n.qbnr\nppppp\n.....\n.....\nPPPPP\nRNBQK\n");
        assertFalse(chess.eval() >= 0);
    }

    private boolean movesCompare(Vector<String> vTest, String sInput) {
        String[] sArray = sInput.split("\n");
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] += "\n";
        }
        Vector<String> vTrue = new Vector<String>(Arrays.asList(sArray));
        Collections.sort(vTrue);
        Collections.sort(vTest);

        return vTrue.equals(vTest);
    }

    @Test
    public void moves() throws Exception {
        chess.reset();
        assertTrue(movesCompare(chess.moves(), "a2-a3\nb2-b3\nc2-c3\nd2-d3\ne2-e3\nb1-a3\nb1-c3\n"));

        chess.boardSet("15 B\nk.bnr\n..N.p\nBp...\n.p.q.\nP..P.\n.R.K.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\na6-b5\nc6-b5\nc6-a4\nc6-d5\nc6-e4\nc6-b6\nd6-b5\nd6-c4\nd6-e4\ne5-e4\nb3-b2\nb3-a2\nd3-d4\nd3-d5\nd3-c3\nd3-e3\nd3-d2\nd3-c4\nd3-b5\nd3-e4\nd3-c2\nd3-b1\nd3-e2\n"));

        chess.boardSet("12 B\nkb..r\n..p.p\nQ.PPP\nP....\n.B.P.\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\na6-b5\nb6-a5\nb6-c6\nb6-b5\ne6-d6\ne6-c6\nc5-d4\ne5-d4\n"));

        chess.boardSet("12 W\n.Nb..\n.k..r\n.ppPp\n....P\nPPPQ.\nR.B.K\n");
        assertTrue(movesCompare(chess.moves(), "b6-a4\nb6-d5\nb6-c4\nd4-d5\nd4-e5\na2-a3\nb2-b3\nc2-c3\nd2-d3\nd2-e2\nd2-d1\nd2-c3\nd2-b4\na1-b1\nc1-b1\nc1-d1\ne1-e2\ne1-d1\n"));

        chess.boardSet("12 B\n.k.nr\nppbqp\n.P..P\nP.pB.\nR.PK.\n.N...\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nd6-c4\nd6-e4\na5-a4\na5-b4\nc5-b4\nc5-d4\nc5-e3\nc5-c6\nc5-c4\nd5-d4\nd5-d3\nd5-c6\nd5-c4\nd5-b3\nd5-a2\nd5-e4\nc3-d2\n"));

        chess.boardSet("13 W\n....r\n..p.p\nqkp..\n...b.\nP.PBP\n..RK.\n");
        assertTrue(movesCompare(chess.moves(), "a2-a3\nc2-c3\nc2-d3\nd2-c3\nd2-b4\nd2-e3\nd2-e1\ne2-e3\ne2-d3\nc1-b1\nc1-a1\nd1-e1\n"));

        chess.boardSet("21 W\n.....\n.k.b.\n.pP.N\np.nrB\nP..R.\n....K\n");
        assertTrue(movesCompare(chess.moves(), "c4-c5\nc4-b5\nc4-d5\ne4-c5\ne4-d6\ne4-c3\ne3-d4\ne3-c5\ne3-b6\ne3-e2\nd2-d3\nd2-c2\nd2-b2\nd2-e2\nd2-d1\ne1-e2\ne1-d1\n"));

        chess.boardSet("18 B\n..rb.\n..k.p\n.p.p.\nPPRP.\n...K.\n...Q.\n");
        assertTrue(movesCompare(chess.moves(), "c6-b6\nc6-a6\nd6-e6\nd6-d5\nc5-b5\nc5-d5\nc5-c4\nc5-b6\ne5-e4\nb4-a3\nb4-c3\nd4-c3\n"));

        chess.boardSet("19 W\nk....\n.pp.r\n..K.b\n.ppn.\n....R\nqNB.Q\n");
        assertTrue(movesCompare(chess.moves(), "c4-c5\nc4-b4\nc4-d4\nc4-c3\nc4-b5\nc4-d5\nc4-b3\nc4-d3\ne2-e3\ne2-e4\ne2-d2\ne2-c2\ne2-b2\ne2-a2\nb1-a3\nb1-d2\nb1-c3\nc1-b2\nc1-a3\nc1-d2\nc1-e3\nc1-c2\nc1-d1\ne1-d1\ne1-d2\ne1-c3\n"));

        chess.boardSet("11 B\nk...r\nppb..\n....p\nP.pPP\n..P.B\n.R.QK\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\ne6-d6\ne6-c6\ne6-b6\ne6-e5\na5-a4\nb5-b4\nc5-b6\nc5-d6\nc5-b4\nc5-a3\nc5-d4\nc5-e3\nc5-c6\nc5-d5\nc5-c4\ne4-d3\n"));

        chess.boardSet("18 B\n...q.\nRkpbp\n..PrP\n...p.\n...PK\n...n.\n");
        assertTrue(movesCompare(chess.moves(), "d6-c6\nd6-b6\nd6-a6\nd6-e6\nb5-b6\nb5-a5\nb5-b4\nb5-a6\nb5-c6\nb5-a4\nb5-c4\nd5-c6\nd5-e6\nd5-c4\nd5-e4\nd4-c4\nd4-e4\nd3-e2\nd1-b2\nd1-c3\nd1-e3\n"));

        chess.boardSet("20 W\n.k..r\n..P.p\nB....\nR.p..\n...KP\n.N...\n");
        assertTrue(movesCompare(chess.moves(), "c5-c6\nc5-b6\na4-b5\na4-c6\na4-b3\na4-c2\na4-d1\na4-a5\na4-b4\na3-b3\na3-c3\na3-a2\na3-a1\nd2-d3\nd2-c2\nd2-d1\nd2-c3\nd2-e3\nd2-c1\nd2-e1\ne2-e3\nb1-c3\n"));

        chess.boardSet("16 B\n.qk..\npr...\n...p.\nP.PBp\n.P..p\nRN.K.\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c5\nc6-d6\nc6-c5\nc6-d5\na5-a4\nb5-c5\nb5-d5\nb5-e5\nb5-b4\nb5-b3\nb5-b2\nd4-c3\ne2-e1\ne2-d1\n"));

        chess.boardSet("15 W\nkb.nr\n....p\n.pN..\np.p.P\nPP..K\nR.B..\n");
        assertTrue(movesCompare(chess.moves(), "c4-a5\nc4-b6\nc4-e5\nc4-d6\nc4-a3\nc4-d2\ne3-e4\nb2-b3\nb2-a3\nb2-c3\ne2-d2\ne2-e1\ne2-d3\ne2-d1\na1-b1\nc1-d2\nc1-c2\nc1-b1\nc1-d1\n"));

        chess.boardSet("11 B\nk..br\n.p..p\np.p.P\nB...p\nP.qN.\nRQ..K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nd6-c5\nd6-b4\nd6-a3\nd6-c6\nd6-d5\nb5-b4\nc4-c3\ne3-e2\ne3-d2\nc2-c3\nc2-b2\nc2-a2\nc2-d2\nc2-c1\nc2-b3\nc2-d3\nc2-e4\nc2-b1\nc2-d1\n"));

        chess.boardSet("12 B\nk..nr\n.qp.p\npP...\nP.Q.P\nRP.K.\n....B\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nd6-c4\nd6-e4\nb5-b6\nb5-a5\nb5-b4\nb5-c6\nb5-c4\nb5-d3\nb5-e2\nc5-c4\nc5-b4\ne5-e4\n"));

        chess.boardSet("18 W\nkr..b\np..N.\n.Bpp.\n.q..P\nP...P\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "d5-b6\nd5-c3\nb4-a5\nb4-c5\nb4-d6\nb4-a3\nb4-c3\nb4-d2\nb4-b5\nb4-a4\ne3-e4\ne3-d4\na2-a3\na2-b3\nb1-b2\nb1-b3\nb1-a1\nb1-c1\nb1-d1\ne1-d1\ne1-d2\n"));

        chess.boardSet("13 W\nk.q.r\np...p\n...pb\np..P.\nPBpQP\n.R.K.\n");
        assertTrue(movesCompare(chess.moves(), "d3-e4\nb2-a3\nb2-c3\nb2-d4\nb2-a1\nb2-c1\nb2-b3\nd2-c2\nd2-c3\nd2-b4\nd2-a5\nd2-e3\nd2-c1\nd2-e1\ne2-e3\nb1-a1\nb1-c1\nd1-c1\nd1-e1\nd1-c2\n"));

        chess.boardSet("15 B\nk.br.\n..q..\n.p..Q\nn....\np.PPB\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\na6-b5\nc6-b5\nc6-a4\nc6-d5\nc6-e4\nc6-b6\nd6-e6\nd6-d5\nd6-d4\nd6-d3\nd6-d2\nc5-b5\nc5-a5\nc5-d5\nc5-e5\nc5-c4\nc5-c3\nc5-c2\nc5-b6\nc5-d4\nc5-e3\nb4-b3\na3-c4\na3-b5\na3-c2\na3-b1\na2-a1\n"));

        chess.boardSet("14 B\nkr...\n..QPp\n.P...\n..q..\nPBPn.\n.R.bK\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\na6-b5\nb6-c6\nb6-d6\nb6-e6\nb6-b5\nb6-b4\ne5-e4\nc3-c4\nc3-c5\nc3-b3\nc3-a3\nc3-d3\nc3-e3\nc3-c2\nc3-b4\nc3-d4\nc3-b2\nd2-b3\nd2-c4\nd2-e4\nd2-b1\nd1-c2\nd1-e2\nd1-c1\n"));

        chess.boardSet("13 W\n.q.nr\nkp..p\n..p..\n..b..\n..PQP\nq.RK.\n");
        assertTrue(movesCompare(chess.moves(), "d2-d3\nd2-d4\nd2-d5\nd2-d6\nd2-c3\nd2-e3\nd2-e1\ne2-e3\nc1-b1\nc1-a1\nd1-e1\n"));

        chess.boardSet("14 B\nk....\n.pbpr\n.P..P\n.Pp..\n..P.Q\nqN..K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nc5-b6\nc5-d6\nc5-b4\nc5-d4\nc5-e3\nc5-c6\nc5-c4\nd5-d4\nd5-e4\ne5-e6\ne5-e4\na1-a2\na1-a3\na1-a4\na1-a5\na1-b1\na1-b2\n"));

        chess.boardSet("12 B\n.k.N.\np.r..\nb...Q\npP..P\n..P.P\nR.B.K\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-b5\nc5-c6\nc5-b5\nc5-d5\nc5-e5\nc5-c4\nc5-c3\nc5-c2\na4-b5\na4-c6\na4-b3\na4-b4\na3-a2\n"));

        chess.boardSet("15 W\nk..br\n..p..\n..p.p\nRP..P\n..p.K\n..B..\n");
        assertTrue(movesCompare(chess.moves(), "a3-a4\na3-a5\na3-a6\na3-a2\na3-a1\nb3-b4\nb3-c4\ne2-d2\ne2-e1\ne2-d3\ne2-d1\nc1-b2\nc1-d2\nc1-b1\nc1-d1\n"));

        chess.boardSet("16 B\nk..nr\np.p.p\nP....\npQpP.\n..P..\nR.qK.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-b5\nd6-b5\nd6-c4\nd6-e4\nc5-c4\ne5-e4\na3-a2\nc1-c2\nc1-b1\nc1-a1\nc1-d1\nc1-b2\nc1-d2\nc1-e3\n"));

        chess.boardSet("13 B\nkqbr.\n.ppp.\nP.PB.\nP....\n...Pn\n...RK\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\nb6-a5\nd6-e6\nb5-b4\nb5-a4\nb5-c4\nc5-d4\nd5-c4\ne2-c3\ne2-d4\ne2-c1\n"));

        chess.boardSet("19 W\n...nr\nQk.p.\np.PPp\nP....\n.pP.N\n..RBK\n");
        assertTrue(movesCompare(chess.moves(), "a5-a6\na5-b5\na5-a4\na5-b6\na5-b4\na5-c3\na5-d2\nc4-c5\nc4-b5\nc4-d5\nc2-c3\ne2-c3\nc1-b1\nc1-a1\nd1-d2\ne1-d2\n"));

        chess.boardSet("20 W\nk....\np...p\n..QpP\nP..P.\n.r.K.\nRN.q.\n");
        assertTrue(movesCompare(chess.moves(), "c4-c5\nc4-c6\nc4-b4\nc4-a4\nc4-d4\nc4-c3\nc4-c2\nc4-c1\nc4-b5\nc4-a6\nc4-d5\nc4-e6\nc4-b3\nc4-a2\na3-a4\nd2-c2\nd2-e2\nd2-d1\nd2-c3\nd2-e3\nd2-c1\nd2-e1\na1-a2\nb1-c3\n"));

        chess.boardSet("15 W\nk..b.\npp.r.\n.R.Kp\nB.P..\nPnPq.\n.....\n");
        assertTrue(movesCompare(chess.moves(), "b4-b5\nb4-a4\nb4-c4\nb4-b3\nb4-b2\nd4-d5\nd4-c4\nd4-e4\nd4-d3\nd4-c5\nd4-e5\nd4-e3\na3-b2\na3-a4\na3-b3\nc3-c4\n"));

        chess.boardSet("17 W\n.....\np.pNB\nQp..p\n.bk.P\n.P..q\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "d5-b6\nd5-b4\nd5-c3\ne5-d6\ne5-d4\ne5-c3\ne5-e6\na4-a5\na4-b4\na4-a3\na4-a2\na4-a1\na4-b5\na4-c6\na4-b3\nb2-c3\nb1-a1\nb1-c1\nb1-d1\ne1-e2\ne1-d1\ne1-d2\n"));

        chess.boardSet("18 W\nq...r\nk.n..\np...P\n.bp..\nP.Bp.\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "e4-e5\na2-a3\na2-b3\nc2-b3\nc2-d3\nc2-d1\nc2-b2\nc2-c1\nb1-b2\nb1-b3\nb1-a1\nb1-c1\nb1-d1\ne1-e2\ne1-d1\ne1-d2\n"));

        chess.boardSet("19 W\nk...r\n...qp\npR.P.\nP.Kb.\n...BP\n.Q...\n");
        assertTrue(movesCompare(chess.moves(), "b4-b5\nb4-b6\nb4-a4\nb4-c4\nb4-b3\nb4-b2\nd4-e5\nc3-c4\nc3-b3\nc3-d3\nc3-c2\nc3-b2\nd2-e3\nd2-c1\nd2-e1\nd2-c2\nd2-d1\ne2-e3\ne2-d3\nb1-b2\nb1-b3\nb1-a1\nb1-c1\nb1-d1\nb1-e1\nb1-a2\nb1-c2\nb1-d3\n"));

        chess.boardSet("19 B\n..r..\n.k.pb\n.Q...\n..n.P\nP..KP\nRN...\n");
        assertTrue(movesCompare(chess.moves(), "c6-b6\nc6-a6\nc6-d6\nc6-e6\nc6-c5\nc6-c4\nb5-b6\nb5-a5\nb5-c5\nb5-b4\nb5-a6\nb5-a4\nb5-c4\nd5-d4\ne5-d6\ne5-d4\ne5-e6\ne5-e4\nc3-a4\nc3-e4\nc3-a2\nc3-b1\nc3-e2\nc3-d1\n"));

        chess.boardSet("15 W\nk.qnr\n..p.P\np....\n.BQp.\nP..P.\nRq..K\n");
        assertTrue(movesCompare(chess.moves(), "e5-d6\nb3-a4\nb3-c4\nb3-d5\nb3-e6\nb3-c2\nb3-d1\nb3-b4\nb3-a3\nb3-b2\nc3-c4\nc3-c5\nc3-d3\nc3-c2\nc3-c1\nc3-b4\nc3-a5\nc3-d4\nc3-b2\na2-a3\na1-b1\ne1-e2\ne1-d1\n"));

        chess.boardSet("21 W\n....r\n....Q\np.k.q\np.P.P\nRp...\n.NB.K\n");
        assertTrue(movesCompare(chess.moves(), "e5-e6\ne5-d5\ne5-c5\ne5-b5\ne5-a5\ne5-e4\ne5-d6\ne5-d4\na2-a3\na2-b2\na2-a1\nb1-a3\nb1-d2\nc1-b2\nc1-d2\nc1-c2\nc1-d1\ne1-e2\ne1-d1\ne1-d2\n"));

        chess.boardSet("17 B\nk...r\n.N.qP\n.....\np..pP\n..bK.\n.R.n.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\na6-b5\ne6-d6\ne6-c6\ne6-b6\ne6-e5\nd5-d6\nd5-c5\nd5-b5\nd5-e5\nd5-d4\nd5-c6\nd5-c4\nd5-b3\nd5-a2\nd5-e4\na3-a2\nc2-b3\nc2-a4\nc2-b1\nc2-c3\nc2-b2\nc2-c1\nd1-b2\nd1-c3\nd1-e3\n"));

        chess.boardSet("12 W\nkq.br\n..p.p\n.p.pn\nP.pPP\n..Q..\nRN.BK\n");
        assertTrue(movesCompare(chess.moves(), "a3-a4\na3-b4\nd3-e4\ne3-d4\nc2-c3\nc2-b2\nc2-a2\nc2-d2\nc2-e2\nc2-c1\nc2-b3\nc2-a4\na1-a2\nb1-d2\nb1-c3\nd1-e2\nd1-d2\nd1-c1\ne1-e2\ne1-d2\n"));

        chess.boardSet("17 W\nk..qr\n...pp\np..b.\n.P...\n..Pn.\nR..QK\n");
        assertTrue(movesCompare(chess.moves(), "b3-b4\nb3-a4\nc2-c3\na1-a2\na1-a3\na1-a4\na1-b1\na1-c1\nd1-d2\nd1-c1\nd1-b1\nd1-e2\ne1-e2\ne1-d2\n"));

        chess.boardSet("13 W\nk.qbr\n.Np.p\n.pP..\nP..p.\n.P.KP\n..Bn.\n");
        assertTrue(movesCompare(chess.moves(), "b5-d6\nb5-d4\nb5-c3\na3-a4\na3-b4\nb2-b3\nd2-d3\nd2-c2\nd2-d1\nd2-c3\nd2-e3\nd2-e1\ne2-e3\ne2-d3\nc1-c2\nc1-b1\n"));

        chess.boardSet("17 B\n...Q.\nk..pr\nR..Pp\n..NK.\n.nP..\n..B.Q\n");
        assertTrue(movesCompare(chess.moves(), "a5-a6\na5-b5\na5-a4\na5-b6\na5-b4\ne5-e6\ne4-e3\ne4-d3\nb2-a4\nb2-d3\nb2-c4\nb2-d1\n"));

        chess.boardSet("17 W\nk...r\nPpN.b\n....p\nR..p.\n.p.BP\n...QK\n");
        assertTrue(movesCompare(chess.moves(), "c5-a6\nc5-e6\nc5-a4\nc5-b3\nc5-e4\nc5-d3\na3-a4\na3-b3\na3-c3\na3-d3\na3-a2\na3-a1\nd2-c3\nd2-b4\nd2-e3\nd2-c1\nd2-c2\ne2-e3\ne2-d3\nd1-c1\nd1-b1\nd1-a1\nd1-c2\nd1-b3\nd1-a4\n"));

        chess.boardSet("17 W\n.k.r.\np...p\nP.Q.P\n..p..\n..B.P\nq...K\n");
        assertTrue(movesCompare(chess.moves(), "c4-c5\nc4-c6\nc4-b4\nc4-d4\nc4-c3\nc4-b5\nc4-a6\nc4-d5\nc4-e6\nc4-b3\nc4-a2\nc4-d3\nc2-b3\nc2-d3\nc2-b1\nc2-d1\nc2-b2\nc2-d2\nc2-c1\ne2-e3\ne1-d1\ne1-d2\n"));

        chess.boardSet("21 W\n.n...\n.kPPQ\npp...\nbP..P\nP.B.K\n..q..\n");
        assertTrue(movesCompare(chess.moves(), "c5-c6\nc5-b6\nd5-d6\ne5-e6\ne5-e4\ne5-d6\ne5-d4\ne5-c3\ne5-b2\ne5-a1\nb3-a4\ne3-e4\nc2-d3\nc2-e4\nc2-b1\nc2-d1\nc2-c3\nc2-b2\nc2-d2\ne2-d2\ne2-e1\ne2-d3\ne2-d1\n"));

        chess.boardSet("20 W\nk..b.\n..p.r\npq..p\n.p.PK\nP...N\n...BR\n");
        assertTrue(movesCompare(chess.moves(), "d3-d4\nd3-e4\ne3-e4\ne3-d4\ne3-d2\na2-a3\na2-b3\ne2-c3\ne2-d4\ne2-c1\nd1-c2\nd1-b3\nd1-d2\nd1-c1\n"));

        chess.boardSet("17 W\n.k.br\np...p\nP.pp.\n..n.P\nR..PQ\n.NB.K\n");
        assertTrue(movesCompare(chess.moves(), "e3-e4\ne3-d4\na2-a3\na2-b2\na2-c2\na2-a1\nd2-d3\nd2-c3\ne2-d3\ne2-c4\ne2-d1\nb1-a3\nb1-c3\nc1-b2\nc1-a3\nc1-c2\nc1-d1\ne1-d1\n"));

        chess.boardSet("11 B\nkq..K\n..p..\np...p\nP...P\nP.P.b\n.RBQ.\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\na6-b5\nb6-c6\nb6-d6\nb6-e6\nb6-b5\nb6-b4\nb6-b3\nb6-b2\nb6-b1\nb6-a5\nc5-c4\ne2-d3\ne2-c4\ne2-b5\ne2-d1\ne2-d2\ne2-e1\n"));

        chess.boardSet("18 W\nk.b.r\n..pp.\nNp...\n...pP\nP.PK.\nRQq..\n");
        assertTrue(movesCompare(chess.moves(), "a4-c5\na4-b6\na4-c3\na4-b2\ne3-e4\na2-a3\nc2-c3\nc2-d3\nd2-d3\nd2-e2\nd2-d1\nd2-c3\nd2-c1\nd2-e1\nb1-b2\nb1-b3\nb1-b4\nb1-c1\n"));

        chess.boardSet("11 B\nkb..r\npp.qp\n..p.P\n.PP..\nPBN.Q\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "b6-c5\nb6-d4\nb6-e3\nb6-c6\ne6-d6\ne6-c6\na5-a4\nb5-b4\nd5-d6\nd5-c5\nd5-d4\nd5-d3\nd5-d2\nd5-d1\nd5-c6\nd5-e4\nc4-b3\n"));

        chess.boardSet("12 B\nk.qr.\n.pp..\n.P...\npb..p\nP.PQP\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nc6-b6\nc6-d5\nc6-e4\nd6-e6\nd6-d5\nd6-d4\nd6-d3\nd6-d2\nc5-c4\nc5-b4\nb3-a4\nb3-c4\nb3-d5\nb3-e6\nb3-a2\nb3-c2\nb3-c3\nb3-b2\ne3-d2\n"));

        chess.boardSet("16 B\n.b...\nk.p.r\n..PPP\np.P..\nP..NK\n..R.q\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-b5\na5-a6\na5-b5\na5-a4\na5-b4\nc5-d4\ne5-e6\ne5-d5\ne5-e4\ne1-e2\ne1-d1\ne1-c1\ne1-d2\n"));

        chess.boardSet("19 B\n.k.r.\nP...p\np..P.\n.P...\nRP...\n..B.K\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-b5\nb6-a5\nb6-c5\nd6-c6\nd6-e6\nd6-d5\nd6-d4\ne5-e4\ne5-d4\na4-a3\na4-b3\n"));

        chess.boardSet("13 B\nk..nr\nPqQ.b\np.p..\n.....\nPBP.P\n.R.K.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nd6-e4\nb5-b6\nb5-a5\nb5-c5\nb5-b4\nb5-b3\nb5-b2\nb5-c6\ne5-d4\ne5-c3\ne5-b2\ne5-d5\ne5-e4\na4-a3\nc4-c3\n"));

        chess.boardSet("16 W\n.br..\nkq.R.\np....\n..p.B\nP.P.K\n.n.Q.\n");
        assertTrue(movesCompare(chess.moves(), "d5-d6\nd5-c5\nd5-b5\nd5-e5\nd5-d4\nd5-d3\nd5-d2\ne3-d4\ne3-c5\ne3-b6\ne3-d2\ne3-c1\ne3-e4\ne3-d3\na2-a3\ne2-d2\ne2-e1\ne2-d3\nd1-d2\nd1-d3\nd1-d4\nd1-c1\nd1-b1\nd1-e1\n"));

        chess.boardSet("15 B\n..r..\nkNq.b\np....\n...p.\nPnP.K\nRQ...\n");
        assertTrue(movesCompare(chess.moves(), "c6-b6\nc6-a6\nc6-d6\nc6-e6\na5-a6\na5-b5\na5-b6\na5-b4\nc5-b5\nc5-d5\nc5-c4\nc5-c3\nc5-c2\nc5-b6\nc5-d6\nc5-b4\nc5-a3\nc5-d4\nc5-e3\ne5-d6\ne5-d4\ne5-c3\ne5-e6\ne5-d5\ne5-e4\na4-a3\nd3-d2\nd3-c2\nd3-e2\nb2-c4\nb2-d1\n"));

        chess.boardSet("15 B\n.kb..\n...rQ\npp..p\nQ...P\np.PP.\n.R.K.\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-b5\nb6-a5\nb6-c5\nc6-b5\nc6-d6\nc6-c5\nd5-d6\nd5-c5\nd5-b5\nd5-a5\nd5-e5\nd5-d4\nd5-d3\nd5-d2\nb4-b3\nb4-a3\na2-a1\na2-b1\n"));

        chess.boardSet("18 B\nk..n.\np.rq.\n.PR.p\n....P\n...PK\n...Q.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-b5\nd6-b5\nd6-c4\na5-a4\na5-b4\nc5-c6\nc5-b5\nc5-c4\nd5-e5\nd5-d4\nd5-d3\nd5-d2\nd5-c6\nd5-e6\nd5-c4\n"));

        chess.boardSet("16 B\nkb.qr\npp.Qp\nBR..n\nP.p.N\n..P.p\n...K.\n");
        assertTrue(movesCompare(chess.moves(), "b6-c5\nb6-d4\nb6-e3\nb6-c6\nd6-c6\nd6-d5\nd6-c5\nd6-b4\na5-b4\nb5-a4\ne4-c5\ne4-d2\ne2-e1\ne2-d1\n"));

        chess.boardSet("13 B\n..b.r\n.nk.p\npPpQ.\nP....\n.P.P.\nRNB.K\n");
        assertTrue(movesCompare(chess.moves(), "c6-d5\nc6-e4\nc6-b6\nc6-d6\ne6-d6\nb5-d6\nb5-a3\nb5-d4\nb5-c3\nc5-d5\nc5-b6\nc5-d6\nc5-b4\nc5-d4\ne5-e4\ne5-d4\nc4-c3\n"));

        chess.boardSet("12 W\nk...r\np.b.p\n.pNp.\n.PQP.\nP.P.P\nRBqK.\n");
        assertTrue(movesCompare(chess.moves(), "c4-a5\nc4-b6\nc4-e5\nc4-d6\nc4-a3\nc4-b2\nc4-e3\nc4-d2\nc3-b4\nc3-d4\nc3-b2\nc3-d2\nc3-e1\na2-a3\ne2-e3\nb1-b2\nd1-d2\nd1-c1\nd1-e1\n"));

        chess.boardSet("14 W\nk...r\n.pPbp\np.p..\n.N...\nP.P.K\nR.Bn.\n");
        assertTrue(movesCompare(chess.moves(), "c5-c6\nb3-a5\nb3-d4\nb3-d2\na2-a3\nc2-c3\ne2-e3\ne2-d2\ne2-e1\ne2-d3\ne2-d1\na1-b1\nc1-b2\nc1-a3\nc1-d2\nc1-e3\nc1-b1\n"));

        chess.boardSet("18 W\nbkr..\n..P.Q\n.p.P.\n.p...\nR.PK.\n...B.\n");
        assertTrue(movesCompare(chess.moves(), "c5-b6\ne5-e6\ne5-d5\ne5-e4\ne5-e3\ne5-e2\ne5-e1\ne5-d6\nd4-d5\na2-a3\na2-a4\na2-a5\na2-a6\na2-b2\na2-a1\nc2-c3\nc2-b3\nd2-d3\nd2-e2\nd2-c3\nd2-e3\nd2-c1\nd2-e1\nd1-e2\nd1-c1\nd1-e1\n"));

        chess.boardSet("15 W\nk..r.\nK.P.N\n.....\n...p.\nP.P.P\nR.qQ.\n");
        assertTrue(movesCompare(chess.moves(), "a5-a6\na5-b5\na5-a4\na5-b6\na5-b4\nc5-c6\nc5-d6\ne5-c6\ne5-c4\ne5-d3\na2-a3\nc2-c3\nc2-d3\ne2-e3\ne2-d3\na1-b1\na1-c1\nd1-d2\nd1-d3\nd1-c1\nd1-e1\n"));

        chess.boardSet("17 B\nk.N.r\np.p..\n..n.p\n.p.BP\nP..K.\nR....\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-b5\ne6-d6\ne6-c6\ne6-e5\na5-a4\nc4-b6\nc4-e5\nc4-d6\nc4-a3\nc4-b2\nc4-e3\nc4-d2\ne4-d3\nb3-b2\nb3-a2\n"));

        chess.boardSet("13 B\n..q.r\nPkb..\npBppp\n..N..\n..PPP\n.R.QK\n");
        assertTrue(movesCompare(chess.moves(), "c6-b6\nc6-a6\nc6-d6\nc6-d5\ne6-d6\ne6-e5\nb5-b6\nb5-a5\nb5-b4\nb5-a6\nc5-b6\nc5-d6\nc5-b4\nc5-d5\na4-a3\nd4-d3\nd4-c3\ne4-e3\n"));

        chess.boardSet("15 B\nk....\n.p.b.\n.qnp.\n.PP.r\n....B\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\nd5-c6\nd5-e6\nd5-e4\nd5-d6\nd5-c5\nd5-e5\nb4-a4\nb4-b3\nb4-a5\nb4-c5\nb4-d6\nb4-a3\nb4-c3\nc4-a5\nc4-b6\nc4-e5\nc4-d6\nc4-a3\nc4-b2\nc4-d2\nd4-d3\nd4-c3\ne3-e4\ne3-e5\ne3-e6\ne3-d3\ne3-c3\ne3-e2\n"));

        chess.boardSet("16 B\n...br\nk...p\n.pp.P\n.P...\nq..P.\n.QB.K\n");
        assertTrue(movesCompare(chess.moves(), "d6-c5\nd6-c6\nd6-d5\na5-a6\na5-b5\na5-a4\na5-b6\nc4-c3\nc4-b3\na2-a3\na2-a4\na2-b2\na2-c2\na2-d2\na2-a1\na2-b3\na2-b1\n"));

        chess.boardSet("18 W\nQ.Q..\nk..qp\n.Pp..\nP....\n.n.Pp\nRN..K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\na6-b5\na6-c4\nc6-b6\nc6-d6\nc6-e6\nc6-c5\nc6-c4\nc6-b5\nc6-a4\nc6-d5\nb4-b5\nb4-a5\na3-a4\nd2-d3\na1-a2\nb1-c3\ne1-e2\ne1-d1\n"));

        chess.boardSet("17 W\nq...r\nkp.Bp\nP..b.\n...P.\nP.Pp.\nRNK..\n");
        assertTrue(movesCompare(chess.moves(), "d5-c6\nd5-e6\nd5-c4\nd5-b3\nd5-e4\nd5-d6\nd5-c5\na4-b5\na2-a3\nc2-c3\nb1-a3\nb1-d2\nb1-c3\nc1-d1\nc1-b2\nc1-d2\n"));

        chess.boardSet("12 B\nk.qbr\np..pp\nPpRp.\n.....\n.P.NB\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-b5\nc6-b6\nc6-c5\nc6-c4\nc6-b5\nc6-a4\nd6-c5\nd5-c4\ne5-e4\nb4-b3\nd4-d3\n"));

        chess.boardSet("16 W\n.qb.r\nk.Pp.\n...Pp\n.p..P\n.PN.K\nRQ...\n");
        assertTrue(movesCompare(chess.moves(), "c5-b6\nc2-a3\nc2-b4\nc2-e1\ne2-d2\ne2-e1\ne2-d3\ne2-d1\na1-a2\na1-a3\na1-a4\na1-a5\nb1-c1\nb1-d1\nb1-e1\nb1-a2\n"));

        chess.boardSet("18 B\n.k.r.\n..p..\n.pP.p\n.Q..P\nPpB..\n...RK\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-b5\nb6-a5\nd6-c6\nd6-e6\nd6-d5\nd6-d4\nd6-d3\nd6-d2\nd6-d1\nb2-b1\n"));

        chess.boardSet("20 B\n..qr.\np.p.p\n....N\n.k.Pp\nP...Q\n...RK\n");
        assertTrue(movesCompare(chess.moves(), "c6-b6\nc6-a6\nc6-b5\nc6-a4\nc6-d5\nc6-e4\nd6-e6\nd6-d5\nd6-d4\nd6-d3\na5-a4\nc5-c4\nb3-b4\nb3-a3\nb3-c3\nb3-b2\nb3-a4\nb3-c4\nb3-a2\nb3-c2\n"));

        chess.boardSet("15 B\n.k.n.\n..pp.\n.b...\n.B..P\n.P.K.\n.RQ..\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-b5\nb6-a5\nd6-b5\nd6-c4\nd6-e4\nc5-c4\nd5-d4\nb4-a5\nb4-a3\nb4-c3\nb4-d2\nb4-b5\nb4-a4\nb4-c4\n"));

        chess.boardSet("14 W\nk.br.\n.pp..\n.P.pp\nN.P.P\n.p...\n.R.QK\n");
        assertTrue(movesCompare(chess.moves(), "b4-c5\na3-c4\na3-b5\na3-c2\nc3-c4\nc3-d4\ne3-d4\nb1-b2\nb1-a1\nb1-c1\nd1-d2\nd1-d3\nd1-d4\nd1-c1\nd1-c2\nd1-b3\nd1-a4\nd1-e2\ne1-e2\ne1-d2\n"));

        chess.boardSet("16 W\nq.bnr\n.k.p.\np....\n.P..P\nR.Q..\n.N..K\n");
        assertTrue(movesCompare(chess.moves(), "b3-b4\nb3-a4\ne3-e4\na2-a3\na2-a4\na2-b2\na2-a1\nc2-c3\nc2-c4\nc2-c5\nc2-c6\nc2-b2\nc2-d2\nc2-e2\nc2-c1\nc2-d3\nc2-e4\nc2-d1\nb1-a3\nb1-d2\nb1-c3\ne1-e2\ne1-d1\ne1-d2\n"));

        chess.boardSet("16 W\nkqr..\np....\nP.Pp.\n.bn.p\nQ...P\n.R.BK\n");
        assertTrue(movesCompare(chess.moves(), "c4-c5\na2-a3\na2-b2\na2-c2\na2-d2\na2-a1\na2-b3\nb1-b2\nb1-b3\nb1-a1\nb1-c1\nd1-c2\nd1-b3\nd1-d2\nd1-c1\ne1-d2\n"));

        chess.boardSet("15 W\nk..nr\n....p\npbp..\nP.Pp.\n.PQK.\nR....\n");
        assertTrue(movesCompare(chess.moves(), "a3-b4\nc3-b4\nb2-b3\nc2-c1\nc2-b3\nc2-a4\nc2-d3\nc2-b1\nc2-d1\nd2-d3\nd2-e2\nd2-d1\nd2-e3\nd2-c1\nd2-e1\na1-a2\na1-b1\na1-c1\na1-d1\na1-e1\n"));

        chess.boardSet("13 B\nk..r.\nq.bp.\np.PNp\n.R..P\nP.PPQ\n...K.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-b5\nd6-c6\nd6-b6\nd6-e6\na5-b5\na5-b6\na5-b4\na5-c3\na5-d2\nc5-b6\nc5-b4\nc5-a3\nc5-d4\nc5-c6\nc5-b5\nd5-c4\na4-a3\na4-b3\n"));

        chess.boardSet("11 B\n.kbnr\n.p.qp\np...Q\nN.P..\nPPP.P\nR.BK.\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-a5\nb6-c5\nc6-c5\nd6-c4\nd6-e4\nb5-b4\nd5-c5\nd5-d4\nd5-d3\nd5-d2\nd5-d1\nd5-c4\nd5-b3\nd5-a2\nd5-e4\n"));

        chess.boardSet("17 W\n.q.br\nk..np\n.p..P\n.P.p.\n..PQK\n.B...\n");
        assertTrue(movesCompare(chess.moves(), "e4-d5\nc2-c3\nc2-d3\nd2-d3\nd2-d1\nd2-c3\nd2-b4\nd2-e3\nd2-c1\nd2-e1\ne2-e3\ne2-e1\ne2-d3\ne2-d1\nb1-a2\nb1-b2\nb1-a1\nb1-c1\n"));

        chess.boardSet("13 B\n..bn.\np.p.B\nk.P..\n....p\nP..PP\nRN..K\n");
        assertTrue(movesCompare(chess.moves(), "c6-b5\nc6-d5\nc6-e4\nc6-b6\nd6-b5\nd6-c4\nd6-e4\na4-b4\na4-a3\na4-b5\na4-b3\ne3-d2\n"));

        chess.boardSet("12 W\nk..br\n..pp.\n...Qp\n.q.BP\nPP.pP\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "d4-d5\nd4-c4\nd4-b4\nd4-a4\nd4-e4\nd4-c5\nd4-e5\nd4-c3\nd3-c4\nd3-b5\nd3-a6\nd3-e4\nd3-c2\nd3-b1\nd3-c3\na2-a3\na2-b3\na1-b1\na1-c1\na1-d1\ne1-d1\ne1-d2\n"));

        chess.boardSet("20 B\nkr...\n.n.pp\np....\nNQPP.\nq....\n.bB.K\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\nb6-c6\nb6-d6\nb6-e6\nb5-d6\nb5-a3\nb5-d4\nb5-c3\nd5-d4\ne5-e4\na4-b3\na2-a3\na2-b2\na2-c2\na2-d2\na2-e2\na2-a1\na2-b3\nb1-c2\nb1-d3\nb1-b2\nb1-a1\n"));

        chess.boardSet("20 W\nk.r..\nq...p\npPp.P\nP.KB.\n.b.P.\nn..Q.\n");
        assertTrue(movesCompare(chess.moves(), "b4-b5\nb4-a5\nc3-c4\nc3-b3\nc3-c2\nc3-d4\nc3-b2\nd3-c4\nd3-c2\nd3-b1\nd3-e2\nd3-d4\nd3-e3\nd1-c1\nd1-b1\nd1-a1\nd1-e1\nd1-c2\nd1-b3\nd1-a4\nd1-e2\n"));

        chess.boardSet("18 B\nkr...\n.....\n..PBN\nqp..P\nP..K.\nR..Q.\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\na6-b5\nb6-c6\nb6-d6\nb6-e6\nb6-b5\nb6-b4\na3-a4\na3-a5\na3-a2\na3-b4\na3-c5\na3-d6\na3-b2\na3-c1\nb3-b2\nb3-a2\n"));

        chess.boardSet("18 W\n.Q...\n.kP..\npP..p\n..P..\n.Rq..\n..B.K\n");
        assertTrue(movesCompare(chess.moves(), "b6-a6\nb6-c6\nb6-d6\nb6-e6\nb6-b5\nb6-a5\nc5-c6\nc3-c4\nb2-b3\nb2-a2\nb2-c2\nb2-b1\nc1-d2\nc1-e3\nc1-b1\nc1-d1\ne1-e2\ne1-d1\ne1-d2\n"));

        chess.boardSet("20 W\n...br\nn.pkp\n.B...\nP..P.\n....Q\n..KR.\n");
        assertTrue(movesCompare(chess.moves(), "b4-a5\nb4-c5\nb4-c3\nb4-d2\nb4-e1\nb4-b5\nb4-a4\nb4-c4\nb4-b3\na3-a4\nd3-d4\ne2-e3\ne2-e4\ne2-e5\ne2-d2\ne2-c2\ne2-b2\ne2-a2\ne2-e1\nc1-c2\nc1-b1\nc1-b2\nc1-d2\nd1-d2\nd1-e1\n"));

        chess.boardSet("14 B\nkq.nr\n.pp..\np..Kb\nP.P.P\nR..BQ\n.N...\n");
        assertTrue(movesCompare(chess.moves(), "a6-a5\nb6-c6\nb6-a5\nd6-c4\ne6-e5\nb5-b4\nc5-c4\nc5-d4\ne4-d5\ne4-c6\ne4-d3\ne4-c2\ne4-b1\ne4-e5\n"));

        chess.boardSet("19 W\nrk...\npb.p.\nBPp.q\nN.K.P\nP..P.\n....R\n");
        assertTrue(movesCompare(chess.moves(), "a4-b5\na4-b3\na4-c2\na4-d1\nb4-a5\na3-c4\na3-b5\na3-c2\na3-b1\nc3-c4\nc3-b3\nc3-d3\nc3-c2\nc3-d4\nc3-b2\nd2-d3\ne1-e2\ne1-d1\ne1-c1\ne1-b1\ne1-a1\n"));

        chess.boardSet("19 B\nk.bq.\n..n.r\np.p..\n.R.pp\n.P.BP\n.NQK.\n");
        assertTrue(movesCompare(chess.moves(), "a6-b6\na6-a5\na6-b5\nc6-b5\nc6-d5\nc6-e4\nc6-b6\nd6-e6\nd6-d5\nd6-d4\nc5-e6\nc5-b3\nc5-e4\ne5-e6\ne5-d5\ne5-e4\na4-a3\na4-b3\nc4-c3\nc4-b3\nd3-e2\ne3-d2\n"));

        chess.boardSet("15 W\nq..nr\nkPp..\n..N.p\npb..P\nP....\n.RBQK\n");
        assertTrue(movesCompare(chess.moves(), "b5-b6\nb5-a6\nc4-a5\nc4-b6\nc4-e5\nc4-d6\nc4-a3\nc4-b2\nc4-d2\na2-b3\nb1-b2\nb1-b3\nb1-a1\nc1-b2\nc1-a3\nc1-d2\nc1-c2\nd1-d2\nd1-d3\nd1-d4\nd1-d5\nd1-d6\nd1-c2\nd1-b3\nd1-e2\ne1-e2\ne1-d2\n"));

        chess.boardSet("15 B\nkq..r\np.pn.\nPp.Bp\nb..PP\n...N.\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "a6-b5\nb6-c6\nb6-d6\nb6-b5\ne6-d6\ne6-c6\ne6-e5\nc5-c4\nc5-d4\nd5-c3\nd5-e3\nb4-b3\ne4-d3\na3-b2\na3-c1\na3-b3\na3-a2\n"));

        chess.boardSet("12 B\n...nr\n..b..\npq.p.\nPPk.p\n..P.P\nRB..K\n");
        assertTrue(movesCompare(chess.moves(), "d6-b5\nd6-c4\nd6-e4\ne6-e5\ne6-e4\nc5-b6\nc5-c6\nc5-b5\nc5-d5\nc5-c4\na4-b3\nb4-b5\nb4-b6\nb4-c4\nb4-b3\nb4-a5\nb4-a3\nd4-d3\nc3-c4\nc3-b3\nc3-d3\nc3-c2\nc3-b2\nc3-d2\n"));

        chess.boardSet("13 W\nk..n.\n.p.br\np.Bpp\nP.p..\n..PNK\n.R.Q.\n");
        assertTrue(movesCompare(chess.moves(), "c4-b5\nc4-d5\nc4-b3\nc4-a2\nc4-d3\nc4-c5\nc4-b4\nd2-b3\nd2-e4\ne2-e3\ne2-e1\ne2-d3\nb1-b2\nb1-b3\nb1-b4\nb1-b5\nb1-a1\nb1-c1\nd1-c1\nd1-e1\n"));

        chess.boardSet("20 W\n....r\n.nk.b\n.p.pp\nqK.PB\nR..NP\n....Q\n");
        assertTrue(movesCompare(chess.moves(), "b3-b4\nb3-a3\nb3-c3\nb3-b2\nb3-a4\nb3-c4\nb3-c2\nd3-e4\ne3-d4\na2-a3\na2-b2\na2-c2\na2-a1\nd2-c4\nd2-e4\nd2-b1\ne1-d1\ne1-c1\ne1-b1\ne1-a1\n"));

        chess.boardSet("18 W\nk.b..\npP...\n.p..n\n.....\nP.BpQ\n..RK.\n");
        assertTrue(movesCompare(chess.moves(), "b5-b6\nb5-a6\nb5-c6\na2-a3\nc2-b3\nc2-a4\nc2-d3\nc2-e4\nc2-b1\nc2-c3\nc2-b2\ne2-e3\ne2-e4\ne2-d2\ne2-e1\ne2-d3\ne2-c4\nc1-b1\nc1-a1\nd1-d2\nd1-e1\n"));

        chess.boardSet("12 W\nkqb..\n.p..N\np.p.n\n.PprP\nP..K.\nR.BQ.\n");
        assertTrue(movesCompare(chess.moves(), "e5-c6\ne5-c4\ne5-d3\nb3-b4\nb3-a4\nb3-c4\na2-a3\nd2-d3\nd2-c2\nd2-e2\nd2-c3\nd2-e1\na1-b1\nc1-b2\nc1-a3\nc1-c2\nc1-b1\nd1-e1\nd1-c2\nd1-e2\n"));

        chess.boardSet("14 W\nk.q.r\nn..p.\np...p\nPB.PP\n.PQK.\n.R...\n");
        assertTrue(movesCompare(chess.moves(), "b3-a4\nb3-c4\nb3-d5\nb3-a2\nb3-b4\nb3-c3\nd3-d4\nd3-e4\nc2-c3\nc2-c4\nc2-c5\nc2-c6\nc2-c1\nc2-d1\nd2-e2\nd2-d1\nd2-c3\nd2-c1\nd2-e1\nb1-a1\nb1-c1\nb1-d1\nb1-e1\n"));

        chess.boardSet("13 W\nk..Qr\npq...\nPp.p.\nn..pP\n..P.Q\n..B.K\n");
        assertTrue(movesCompare(chess.moves(), "d6-c6\nd6-b6\nd6-a6\nd6-e6\nd6-d5\nd6-d4\nd6-c5\nd6-b4\nd6-e5\na4-b5\ne3-e4\ne3-d4\nc2-c3\nc2-d3\ne2-d2\ne2-d3\ne2-d1\nc1-b2\nc1-a3\nc1-d2\nc1-b1\nc1-d1\ne1-d1\ne1-d2\n"));

        chess.boardSet("13 W\nk...r\np.p.p\nq....\n...P.\nbPNQP\n.RB.K\n");
        assertTrue(movesCompare(chess.moves(), "d3-d4\nb2-b3\nc2-a3\nc2-b4\nc2-e3\nc2-d4\nc2-a1\nd2-d1\nd2-c3\nd2-b4\nd2-a5\nd2-e3\ne2-e3\nb1-a1\nc1-d1\ne1-d1\n"));
    }

    @Test
    public void move() throws Exception {
        chess.reset();
        chess.move("c2-c3");
        assertEquals(chess.boardGet(), "1 B\nkqbnr\nppppp\n.....\n..P..\nPP.PP\nRNBQK\n");

        chess.boardSet("17 B\nq...r\npkp.p\n...pn\nN.Q..\nR..BP\n....K\n");
        chess.move("a5-a4");
        assertEquals(chess.boardGet(), "18 W\nq...r\n.kp.p\np..pn\nN.Q..\nR..BP\n....K\n");

        chess.boardSet("19 B\nkb...\n.....\n..P.p\n...Pp\n..P.P\n.QK..\n");
        chess.move("b6-d4");
        assertEquals(chess.boardGet(), "20 W\nk....\n.....\n..Pbp\n...Pp\n..P.P\n.QK..\n");

        chess.boardSet("12 W\n.....\nkbqpr\nppp.p\n...PP\nPPPQK\nRB...\n");
        chess.move("c2-c3");
        assertEquals(chess.boardGet(), "12 B\n.....\nkbqpr\nppp.p\n..PPP\nPP.QK\nRB...\n");

        chess.boardSet("13 W\nk.b.r\npp...\n.qpPQ\n...P.\n.BP..\nRN..K\n");
        chess.move("d3-c4");
        assertEquals(chess.boardGet(), "13 B\nk.b.r\npp...\n.qPPQ\n.....\n.BP..\nRN..K\n");

        chess.boardSet("17 B\nk.r..\np.q.p\n.b...\nNPP.K\nP..P.\n.B.RQ\n");
        chess.move("c5-e3");
        assertEquals(chess.boardGet(), "18 W\nk.r..\np...p\n.b...\nNPP.q\nP..P.\n.B.RQ\n");

        chess.boardSet("14 W\n.kb.r\nPp..p\n.Bp.P\n.pNPq\nR..nK\n...Q.\n");
        chess.move("a5-a6");
        assertEquals(chess.boardGet(), "14 B\nQkb.r\n.p..p\n.Bp.P\n.pNPq\nR..nK\n...Q.\n");

        chess.boardSet("14 B\nQk..r\n..bqp\n..ppP\n..p..\n.P.PB\nRN..K\n");
        chess.move("c3-c2");
        assertEquals(chess.boardGet(), "15 W\nQk..r\n..bqp\n..ppP\n.....\n.PpPB\nRN..K\n");

        chess.boardSet("21 W\nk..nr\n.....\n..pqp\nP.PP.\n...Q.\nR...K\n");
        chess.move("d2-c2");
        assertEquals(chess.boardGet(), "21 B\nk..nr\n.....\n..pqp\nP.PP.\n..Q..\nR...K\n");

        chess.boardSet("14 W\n..b..\nk..Nr\npB..n\npq.Pp\n....P\n.R.QK\n");
        chess.move("e1-d2");
        assertEquals(chess.boardGet(), "14 B\n..b..\nk..Nr\npB..n\npq.Pp\n...KP\n.R.Q.\n");

        chess.boardSet("20 B\n.kr..\n...nQ\n.pp.p\n.P.p.\nBR.P.\n...K.\n");
        chess.move("c6-e6");
        assertEquals(chess.boardGet(), "21 W\n.k..r\n...nQ\n.pp.p\n.P.p.\nBR.P.\n...K.\n");

        chess.boardSet("15 W\nkR...\n..p.p\nP.nPb\n....B\nP.P.K\n...Q.\n");
        chess.move("c2-c3");
        assertEquals(chess.boardGet(), "15 B\nkR...\n..p.p\nP.nPb\n..P.B\nP...K\n...Q.\n");

        chess.boardSet("17 B\n.k.n.\np.b..\n..p.N\n.....\nPPp..\nR..qK\n");
        chess.move("c5-b5");
        assertEquals(chess.boardGet(), "18 W\n.k.n.\npb...\n..p.N\n.....\nPPp..\nR..qK\n");

        chess.boardSet("17 W\nk...r\np.b..\n..pp.\nB.P..\nR..q.\n....K\n");
        chess.move("a3-c5");
        assertEquals(chess.boardGet(), "17 B\nk...r\np.B..\n..pp.\n..P..\nR..q.\n....K\n");

        chess.boardSet("20 B\nk..qr\npP..p\n..n..\n.Pp.p\n..P..\n.R.K.\n");
        chess.move("c4-b2");
        assertEquals(chess.boardGet(), "21 W\nk..qr\npP..p\n.....\n.Pp.p\n.nP..\n.R.K.\n");

        chess.boardSet("16 B\nk.r..\nP...p\n..p..\n..P..\n.PpPK\nRb...\n");
        chess.move("a6-b6");
        assertEquals(chess.boardGet(), "17 W\n.kr..\nP...p\n..p..\n..P..\n.PpPK\nRb...\n");

        chess.boardSet("19 W\nk...r\npqp..\nN....\n....n\nRP.KP\n..B..\n");
        chess.move("d2-d1");
        assertEquals(chess.boardGet(), "19 B\nk...r\npqp..\nN....\n....n\nRP..P\n..BK.\n");

        chess.boardSet("21 W\nkn..r\n.bP.p\n...P.\n.....\n..P.P\nq...K\n");
        chess.move("c5-b6");
        assertEquals(chess.boardGet(), "21 B\nkQ..r\n.b..p\n...P.\n.....\n..P.P\nq...K\n");

        chess.boardSet("12 W\nkbr..\np...p\n..npP\npP.PK\nP....\nq.Q.B\n");
        chess.move("e1-b4");
        assertEquals(chess.boardGet(), "12 B\nkbr..\np...p\n.BnpP\npP.PK\nP....\nq.Q..\n");

        chess.boardSet("15 W\nk.r..\n.pqb.\n.PP.p\np.n.Q\nPBp.P\n.R..K\n");
        chess.move("e3-c1");
        assertEquals(chess.boardGet(), "15 B\nk.r..\n.pqb.\n.PP.p\np.n..\nPBp.P\n.RQ.K\n");

        chess.boardSet("13 W\n..qbr\n.kp.p\n.pn.P\n.R.P.\nP..B.\n...QK\n");
        chess.move("a2-a3");
        assertEquals(chess.boardGet(), "13 B\n..qbr\n.kp.p\n.pn.P\nPR.P.\n...B.\n...QK\n");

        chess.boardSet("14 B\n...q.\n..prp\npkP..\nP....\n.BPPK\nR..Q.\n");
        chess.move("d5-d2");
        assertEquals(chess.boardGet(), "15 W\n...q.\n..p.p\npkP..\nP....\n.BPrK\nR..Q.\n");

        chess.boardSet("11 B\nq.br.\n.Qppp\n.k...\n....n\np.PP.\nRNB.K\n");
        chess.move("b4-a4");
        assertEquals(chess.boardGet(), "12 W\nq.br.\n.Qppp\nk....\n....n\np.PP.\nRNB.K\n");

        chess.boardSet("12 B\nk..br\n....p\n.pp.q\nPpPPp\n.RB..\n.N.KQ\n");
        chess.move("a6-a5");
        assertEquals(chess.boardGet(), "13 W\n...br\nk...p\n.pp.q\nPpPPp\n.RB..\n.N.KQ\n");

        chess.boardSet("17 B\nk.b..\n.npp.\n.P..B\npPQ..\n...r.\nR..K.\n");
        chess.move("a3-a2");
        assertEquals(chess.boardGet(), "18 W\nk.b..\n.npp.\n.P..B\n.PQ..\np..r.\nR..K.\n");

        chess.boardSet("12 B\n.kbnr\nq.pp.\nB.NPp\n..p.P\nP..K.\nq.Q..\n");
        chess.move("a1-a2");
        assertEquals(chess.boardGet(), "13 W\n.kbnr\nq.pp.\nB.NPp\n..p.P\nq..K.\n..Q..\n");

        chess.boardSet("12 B\n.qb.r\nk.p.p\np.P.Q\n.....\nP..Pp\n.NR.K\n");
        chess.move("b6-b4");
        assertEquals(chess.boardGet(), "13 W\n..b.r\nk.p.p\npqP.Q\n.....\nP..Pp\n.NR.K\n");

        chess.boardSet("15 B\n...nr\np..kp\nPK...\n.P.Pb\nR.P.q\n.N...\n");
        chess.move("e2-c2");
        assertEquals(chess.boardGet(), "16 W\n...nr\np..kp\nPK...\n.P.Pb\nR.q..\n.N...\n");

        chess.boardSet("12 B\n.q.br\n..p.p\np.k.p\n..P.P\npP.QN\nR.B.K\n");
        chess.move("b6-b2");
        assertEquals(chess.boardGet(), "13 W\n...br\n..p.p\np.k.p\n..P.P\npq.QN\nR.B.K\n");

        chess.boardSet("21 W\n....r\nk..p.\nb.n.P\n.PP.P\n.p...\nR..BK\n");
        chess.move("e4-d5");
        assertEquals(chess.boardGet(), "21 B\n....r\nk..P.\nb.n..\n.PP.P\n.p...\nR..BK\n");

        chess.boardSet("14 W\n.k.nr\nb..p.\n....p\nNp.PP\n..q.Q\n....K\n");
        chess.move("a3-c2");
        assertEquals(chess.boardGet(), "14 B\n.k.nr\nb..p.\n....p\n.p.PP\n..N.Q\n....K\n");

        chess.boardSet("20 W\nk...b\npP..p\n.....\nPPrPN\nR....\n...BK\n");
        chess.move("a2-b2");
        assertEquals(chess.boardGet(), "20 B\nk...b\npP..p\n.....\nPPrPN\n.R...\n...BK\n");

        chess.boardSet("15 B\n..kr.\n..pp.\nQ...p\nP...P\nP.PPK\nR.B..\n");
        chess.move("d5-d4");
        assertEquals(chess.boardGet(), "16 W\n..kr.\n..p..\nQ..pp\nP...P\nP.PPK\nR.B..\n");

        chess.boardSet("18 B\nkb...\n..np.\np.rPp\nNRP.P\n.....\n.Q.K.\n");
        chess.move("a6-a5");
        assertEquals(chess.boardGet(), "19 W\n.b...\nk.np.\np.rPp\nNRP.P\n.....\n.Q.K.\n");

        chess.boardSet("17 W\nNk.br\n....p\nPpnp.\n.P.p.\nBP..P\n..R.K\n");
        chess.move("a6-c5");
        assertEquals(chess.boardGet(), "17 B\n.k.br\n..N.p\nPpnp.\n.P.p.\nBP..P\n..R.K\n");

        chess.boardSet("11 B\n.kbn.\n....Q\n.p...\np...r\nPPPp.\nRB.NK\n");
        chess.move("d6-c4");
        assertEquals(chess.boardGet(), "12 W\n.kb..\n....Q\n.pn..\np...r\nPPPp.\nRB.NK\n");

        chess.boardSet("15 W\n....r\nk....\nRp..p\n.Qp.q\n.P.PP\n.B.K.\n");
        chess.move("a4-a2");
        assertEquals(chess.boardGet(), "15 B\n....r\nk....\n.p..p\n.Qp.q\nRP.PP\n.B.K.\n");

        chess.boardSet("14 W\nk.r..\n.qppp\n.p.KP\nPb...\nPR...\n.NB..\n");
        chess.move("d4-c4");
        assertEquals(chess.boardGet(), "14 B\nk.r..\n.qppp\n.pK.P\nPb...\nPR...\n.NB..\n");

        chess.boardSet("12 B\nk..br\nq.ppp\n.p..N\nPP.BP\n..P..\n.R.QK\n");
        chess.move("d5-e4");
        assertEquals(chess.boardGet(), "13 W\nk..br\nq.p.p\n.p..p\nPP.BP\n..P..\n.R.QK\n");

        chess.boardSet("15 W\nk.b.r\np.K.p\n....q\nPP...\n....P\nRN.Q.\n");
        chess.move("c5-d6");
        assertEquals(chess.boardGet(), "15 B\nk.bKr\np...p\n....q\nPP...\n....P\nRN.Q.\n");

        chess.boardSet("16 W\nq...r\n..kb.\np..Pp\nP..Pn\n...R.\n..BQK\n");
        chess.move("d1-a4");
        assertEquals(chess.boardGet(), "16 B\nq...r\n..kb.\nQ..Pp\nP..Pn\n...R.\n..B.K\n");

        chess.boardSet("16 B\n.q...\nkpb.r\n..p.p\nPQp..\nRP.BP\n....K\n");
        chess.move("b6-c6");
        assertEquals(chess.boardGet(), "17 W\n..q..\nkpb.r\n..p.p\nPQp..\nRP.BP\n....K\n");

        chess.boardSet("15 B\n.kb..\n...pr\np.p..\n..P..\n.P.n.\nRB.K.\n");
        chess.move("c6-c5");
        assertEquals(chess.boardGet(), "16 W\n.k...\n..bpr\np.p..\n..P..\n.P.n.\nRB.K.\n");

        chess.boardSet("13 B\nk..nr\npp.b.\nq....\nQPP.p\nPBP.P\n..R.K\n");
        chess.move("b5-b4");
        assertEquals(chess.boardGet(), "14 W\nk..nr\np..b.\nqp...\nQPP.p\nPBP.P\n..R.K\n");

        chess.boardSet("14 W\n.kbnr\n..qp.\n.ppPp\nP.NBP\n..p.K\nR..Q.\n");
        chess.move("a3-b4");
        assertEquals(chess.boardGet(), "14 B\n.kbnr\n..qp.\n.PpPp\n..NBP\n..p.K\nR..Q.\n");

        chess.boardSet("18 W\nk..nr\n...Q.\np.p.p\nPb..P\n.BPK.\nR....\n");
        chess.move("d2-e1");
        assertEquals(chess.boardGet(), "18 B\nk..nr\n...Q.\np.p.p\nPb..P\n.BP..\nR...K\n");

        chess.boardSet("16 W\nkb...\np...r\n..nPp\nppQ..\nP.p.K\n.R...\n");
        chess.move("b1-b2");
        assertEquals(chess.boardGet(), "16 B\nkb...\np...r\n..nPp\nppQ..\nPRp.K\n.....\n");

        chess.boardSet("18 B\n...br\nk...p\nN....\nq.PP.\n..R.p\n.B..K\n");
        chess.move("d6-c5");
        assertEquals(chess.boardGet(), "19 W\n....r\nk.b.p\nN....\nq.PP.\n..R.p\n.B..K\n");

        chess.boardSet("14 W\nk....\nn.r.p\nN.ppQ\nPq...\n.PP.K\nR..B.\n");
        chess.move("c2-b3");
        assertEquals(chess.boardGet(), "14 B\nk....\nn.r.p\nN.ppQ\nPP...\n.P..K\nR..B.\n");

        chess.boardSet("15 B\nk...r\npP...\n..nqp\n.P...\nB.PP.\n.R.QK\n");
        chess.move("c4-e3");
        assertEquals(chess.boardGet(), "16 W\nk...r\npP...\n...qp\n.P..n\nB.PP.\n.R.QK\n");

        chess.boardSet("14 B\nk..b.\n.ppN.\np...Q\nP....\nP.pK.\nR.B..\n");
        chess.move("c5-c4");
        assertEquals(chess.boardGet(), "15 W\nk..b.\n.p.N.\np.p.Q\nP....\nP.pK.\nR.B..\n");

        chess.boardSet("13 B\nkqrn.\n..p.Q\n.....\n...P.\np.PQ.\n.RK..\n");
        chess.move("c5-c4");
        assertEquals(chess.boardGet(), "14 W\nkqrn.\n....Q\n..p..\n...P.\np.PQ.\n.RK..\n");

        chess.boardSet("18 W\nk....\np...b\nP.np.\n.qp.p\n.QRPP\n..K..\n");
        chess.move("b2-b1");
        assertEquals(chess.boardGet(), "18 B\nk....\np...b\nP.np.\n.qp.p\n..RPP\n.QK..\n");

        chess.boardSet("20 B\n..kr.\np.p.b\n..n.p\np.P..\nP.RPp\n...K.\n");
        chess.move("d6-e6");
        assertEquals(chess.boardGet(), "21 W\n..k.r\np.p.b\n..n.p\np.P..\nP.RPp\n...K.\n");

        chess.boardSet("16 B\nk.Rr.\npN.p.\nP..bp\n...Qq\n.....\n..q.K\n");
        chess.move("c1-e1");
        assertEquals(chess.boardGet(), "17 W\nk.Rr.\npN.p.\nP..bp\n...Qq\n.....\n....q\n");

        chess.boardSet("16 B\n.k..r\n.nb..\n..QPp\npP.PK\nP....\nR....\n");
        chess.move("e6-e5");
        assertEquals(chess.boardGet(), "17 W\n.k...\n.nb.r\n..QPp\npP.PK\nP....\nR....\n");

        chess.boardSet("12 W\n.q.r.\npbppp\n.p..n\n.PkP.\nPQ..P\nR..BK\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "12 B\n.q.r.\npbppp\n.p..n\n.PkP.\nPQ..P\n.R.BK\n");

        chess.boardSet("15 W\n..k..\n.npp.\nqp..P\n.P.P.\nP.PK.\nR....\n");
        chess.move("d2-e2");
        assertEquals(chess.boardGet(), "15 B\n..k..\n.npp.\nqp..P\n.P.P.\nP.P.K\nR....\n");

        chess.boardSet("19 B\nk.bn.\n.p...\np.q.r\nQ...B\nP..p.\nR...K\n");
        chess.move("c4-e2");
        assertEquals(chess.boardGet(), "20 W\nk.bn.\n.p...\np...r\nQ...B\nP..pq\nR...K\n");

        chess.boardSet("12 W\nkq.br\np.Bpp\n.pp..\nP.nP.\n..P..\n.R..K\n");
        chess.move("b1-b2");
        assertEquals(chess.boardGet(), "12 B\nkq.br\np.Bpp\n.pp..\nP.nP.\n.RP..\n....K\n");

        chess.boardSet("11 B\nk.bnr\n..ppp\n...qP\n.P.P.\n..PB.\n.NQ.K\n");
        chess.move("d4-e4");
        assertEquals(chess.boardGet(), "12 W\nk.bnr\n..ppp\n....q\n.P.P.\n..PB.\n.NQ.K\n");

        chess.boardSet("16 W\n....r\nkp..p\np..qQ\nP.PP.\n.nBK.\nRN...\n");
        chess.move("e4-c6");
        assertEquals(chess.boardGet(), "16 B\n..Q.r\nkp..p\np..q.\nP.PP.\n.nBK.\nRN...\n");

        chess.boardSet("20 W\nk..n.\n.qp..\np.N.r\nPP.p.\n..P..\n..R.K\n");
        chess.move("e1-d1");
        assertEquals(chess.boardGet(), "20 B\nk..n.\n.qp..\np.N.r\nPP.p.\n..P..\n..RK.\n");

        chess.boardSet("15 B\nkb.r.\n..p..\npPQpp\nn...P\nPP.P.\n.RBK.\n");
        chess.move("a6-b5");
        assertEquals(chess.boardGet(), "16 W\n.b.r.\n.kp..\npPQpp\nn...P\nPP.P.\n.RBK.\n");

        chess.boardSet("12 W\nk..nr\n..qp.\n.pb.p\nPP.QP\n..q.K\nR....\n");
        chess.move("d3-d2");
        assertEquals(chess.boardGet(), "12 B\nk..nr\n..qp.\n.pb.p\nPP..P\n..qQK\nR....\n");

        chess.boardSet("12 W\nkb...\n.p.p.\n...Pn\nPpp.K\nR.PN.\n.B..Q\n");
        chess.move("e3-d3");
        assertEquals(chess.boardGet(), "12 B\nkb...\n.p.p.\n...Pn\nPppK.\nR.PN.\n.B..Q\n");

        chess.boardSet("12 W\nr....\npknpp\n..B.Q\nP.p..\n.PP..\nR...K\n");
        chess.move("a1-a2");
        assertEquals(chess.boardGet(), "12 B\nr....\npknpp\n..B.Q\nP.p..\nRPP..\n....K\n");

        chess.boardSet("19 W\n..k.r\np...P\n...b.\n.....\nq.nK.\n.BQN.\n");
        chess.move("c1-a3");
        assertEquals(chess.boardGet(), "19 B\n..k.r\np...P\n...b.\nQ....\nq.nK.\n.B.N.\n");

        chess.boardSet("18 B\nkbqn.\np....\n.P.K.\n.pP..\n.P.r.\nRN...\n");
        chess.move("c6-c5");
        assertEquals(chess.boardGet(), "19 W\nkb.n.\np.q..\n.P.K.\n.pP..\n.P.r.\nRN...\n");

        chess.boardSet("19 B\n.....\npk.pr\n.p.Pp\n...PP\nPN...\nR..QK\n");
        chess.move("b5-b6");
        assertEquals(chess.boardGet(), "20 W\n.k...\np..pr\n.p.Pp\n...PP\nPN...\nR..QK\n");

        chess.boardSet("12 W\nk..r.\nP.p.p\np....\n..nPP\n.Pp..\nR.BQK\n");
        chess.move("e1-e2");
        assertEquals(chess.boardGet(), "12 B\nk..r.\nP.p.p\np....\n..nPP\n.Pp.K\nR.BQ.\n");

        chess.boardSet("13 B\nk.br.\npn...\nQppPN\n....P\nPP...\n.R.BK\n");
        chess.move("c6-d5");
        assertEquals(chess.boardGet(), "14 W\nk..r.\npn.b.\nQppPN\n....P\nPP...\n.R.BK\n");

        chess.boardSet("17 B\n..krb\np....\n.p..P\n.pn.P\nB....\nQR..K\n");
        chess.move("c6-d5");
        assertEquals(chess.boardGet(), "18 W\n...rb\np..k.\n.p..P\n.pn.P\nB....\nQR..K\n");

        chess.boardSet("18 W\nNk...\np.r..\n...pn\n....P\nq.P.P\n....K\n");
        chess.move("a6-c5");
        assertEquals(chess.boardGet(), "18 B\n.k...\np.N..\n...pn\n....P\nq.P.P\n....K\n");

        chess.boardSet("17 W\nkb...\npn.r.\nPp...\n.pPBP\n.P..p\n..RK.\n");
        chess.move("d3-d4");
        assertEquals(chess.boardGet(), "17 B\nkb...\npn.r.\nPp.B.\n.pP.P\n.P..p\n..RK.\n");

        chess.boardSet("16 B\n.k..r\n.pb..\n.....\np.n.B\nP...P\n...RK\n");
        chess.move("c5-b4");
        assertEquals(chess.boardGet(), "17 W\n.k..r\n.p...\n.b...\np.n.B\nP...P\n...RK\n");

        chess.boardSet("12 W\nk.Q.r\n.n...\n..b.p\nP...q\n.P.PP\nR.B.K\n");
        chess.move("c1-d1");
        assertEquals(chess.boardGet(), "12 B\nk.Q.r\n.n...\n..b.p\nP...q\n.P.PP\nR..BK\n");

        chess.boardSet("19 B\n...q.\n..P..\n.p..p\npPk.P\nP.p.K\n..R..\n");
        chess.move("d6-a6");
        assertEquals(chess.boardGet(), "20 W\nq....\n..P..\n.p..p\npPk.P\nP.p.K\n..R..\n");

        chess.boardSet("19 W\nk.bnr\n...pp\n.B..q\nP..p.\n.PK.P\nRN...\n");
        chess.move("b4-a5");
        assertEquals(chess.boardGet(), "19 B\nk.bnr\nB..pp\n....q\nP..p.\n.PK.P\nRN...\n");

        chess.boardSet("17 W\n.k..r\nppp.q\n..b..\n.P.BP\nPNP..\nRn..K\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "17 B\n.k..r\nppp.q\n..b..\n.P.BP\nPNP..\n.R..K\n");

        chess.boardSet("17 W\nq..nr\np.k.p\n.p.pN\nPP.Pb\n.RPpB\n....K\n");
        chess.move("a3-b4");
        assertEquals(chess.boardGet(), "17 B\nq..nr\np.k.p\n.P.pN\n.P.Pb\n.RPpB\n....K\n");

        chess.boardSet("19 W\nq....\n.kpbp\nr.n..\nP..KP\n..p..\nRN.B.\n");
        chess.move("d3-c3");
        assertEquals(chess.boardGet(), "19 B\nq....\n.kpbp\nr.n..\nP.K.P\n..p..\nRN.B.\n");

        chess.boardSet("18 W\nkq...\npP...\nR..r.\n..P.p\n..P.K\n....Q\n");
        chess.move("e1-b1");
        assertEquals(chess.boardGet(), "18 B\nkq...\npP...\nR..r.\n..P.p\n..P.K\n.Q...\n");

        chess.boardSet("16 B\n.k.r.\n.p.p.\nB....\n..P.b\nP..QP\nRN..K\n");
        chess.move("b5-a4");
        assertEquals(chess.boardGet(), "17 W\n.k.r.\n...p.\np....\n..P.b\nP..QP\nRN..K\n");

        chess.boardSet("14 W\n.b..r\n.kpp.\n.pn.p\n.P..B\n..NPP\nR.QK.\n");
        chess.move("c2-a3");
        assertEquals(chess.boardGet(), "14 B\n.b..r\n.kpp.\n.pn.p\nNP..B\n...PP\nR.QK.\n");

        chess.boardSet("16 W\nk....\npnp..\nbpNpq\nBPPpr\nP..Q.\nR...K\n");
        chess.move("a1-d1");
        assertEquals(chess.boardGet(), "16 B\nk....\npnp..\nbpNpq\nBPPpr\nP..Q.\n...RK\n");

        chess.boardSet("18 W\n...Q.\n.k..r\nN.pp.\n..P.p\nPP.PP\nR.B.K\n");
        chess.move("d6-a6");
        assertEquals(chess.boardGet(), "18 B\nQ....\n.k..r\nN.pp.\n..P.p\nPP.PP\nR.B.K\n");

        chess.boardSet("21 W\n...Qr\np...q\np...p\nNk...\n.pP.K\n..R..\n");
        chess.move("d6-e5");
        assertEquals(chess.boardGet(), "21 B\n....r\np...Q\np...p\nNk...\n.pP.K\n..R..\n");

        chess.boardSet("20 B\nk.b.r\nn.q.p\npp...\n..PPP\nP.Q.K\nRB...\n");
        chess.move("a6-b5");
        assertEquals(chess.boardGet(), "21 W\n..b.r\nnkq.p\npp...\n..PPP\nP.Q.K\nRB...\n");

        chess.boardSet("20 B\n...qb\nk.rnp\n.pPK.\nNP..P\nP...B\n..R..\n");
        chess.move("d6-b6");
        assertEquals(chess.boardGet(), "21 W\n.q..b\nk.rnp\n.pPK.\nNP..P\nP...B\n..R..\n");

        chess.boardSet("20 W\nqkbn.\n.ppqr\n..p..\nK...P\nPP...\nR..Q.\n");
        chess.move("a3-a4");
        assertEquals(chess.boardGet(), "20 B\nqkbn.\n.ppqr\nK.p..\n....P\nPP...\nR..Q.\n");

        chess.boardSet("13 W\n.k.br\nPp.q.\n..p.p\nPBP.p\nR...K\n.NQ..\n");
        chess.move("a5-b6");
        assertEquals(chess.boardGet(), "13 B\n.Q.br\n.p.q.\n..p.p\nPBP.p\nR...K\n.NQ..\n");

        chess.boardSet("17 B\n.q...\nNk...\n..b.r\n.PP.p\nP....\nR.QBK\n");
        chess.move("e3-e2");
        assertEquals(chess.boardGet(), "18 W\n.q...\nNk...\n..b.r\n.PP..\nP...p\nR.QBK\n");

        chess.boardSet("12 B\n...n.\np.kQ.\nb.p.r\n.P.Kq\nP..P.\nRN...\n");
        chess.move("c4-b3");
        assertEquals(chess.boardGet(), "13 W\n...n.\np.kQ.\nb...r\n.p.Kq\nP..P.\nRN...\n");

        chess.boardSet("15 B\nkbr..\np.q..\n..PQN\nPPp.K\n....P\nRB...\n");
        chess.move("c6-d6");
        assertEquals(chess.boardGet(), "16 W\nkb.r.\np.q..\n..PQN\nPPp.K\n....P\nRB...\n");

        chess.boardSet("13 B\nkqr..\n.pp.b\n.B...\n.PP.p\n..Q.P\nRN..K\n");
        chess.move("c5-c4");
        assertEquals(chess.boardGet(), "14 W\nkqr..\n.p..b\n.Bp..\n.PP.p\n..Q.P\nRN..K\n");

        chess.boardSet("15 W\nk..n.\nB.p..\np.Ppr\nP..P.\nqQ..K\nR...b\n");
        chess.move("b2-c3");
        assertEquals(chess.boardGet(), "15 B\nk..n.\nB.p..\np.Ppr\nP.QP.\nq...K\nR...b\n");

        chess.boardSet("16 B\n...n.\nk...p\np.Qp.\nP....\nR.PP.\nQ..bK\n");
        chess.move("d1-c1");
        assertEquals(chess.boardGet(), "17 W\n...n.\nk...p\np.Qp.\nP....\nR.PP.\nQ.b.K\n");

        chess.boardSet("13 W\n.kb.r\n..ppp\n.....\nPpq..\nR.PQP\n..B.K\n");
        chess.move("a3-a4");
        assertEquals(chess.boardGet(), "13 B\n.kb.r\n..ppp\nP....\n.pq..\nR.PQP\n..B.K\n");

        chess.boardSet("19 W\n.k..r\npbppp\n....B\n.P...\n.p.KP\n.....\n");
        chess.move("e4-e3");
        assertEquals(chess.boardGet(), "19 B\n.k..r\npbppp\n.....\n.P..B\n.p.KP\n.....\n");
    }

    @Test
    public void movesShuffled() throws Exception {

    }

    @Test
    public void movesEvaluated() throws Exception {

    }

    @Test
    public void moveRandom() throws Exception {

    }

    @Test
    public void moveGreedy() throws Exception {

    }

    @Test
    public void moveNegamax() throws Exception {

    }

    @Test
    public void moveAlphabeta() throws Exception {

    }

    @Test
    public void undo() throws Exception {

    }

}