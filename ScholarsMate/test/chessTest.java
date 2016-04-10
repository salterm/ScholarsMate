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
        assertTrue(movesCompare(chess.moves(), "a5-a4\nb5-b4\nc5-c4\nd5-d4\ne5-e4\nb6-a4\nb6-c4\n"));

        chess.boardSet("18 W\n..b.r\n.k.pp\n..pP.\n.q..B\npPRQP\nn..NK\n");
        assertTrue(movesCompare(chess.moves(), "d3-e2\ne4-e3\ne4-d4\nc5-c4\nc5-c3\nc5-c6\nd5-d4\nd5-c4\nd5-b3\nd5-a2\nd5-c6\nd6-c4\n"));

        chess.boardSet("14 B\n..qn.\np...r\nkpPPb\nP....\n.P.B.\n.R.QK\n");
        assertTrue(movesCompare(chess.moves(), "c1-b1\nc1-a1\nc1-c2\nc1-c3\nc1-b2\nc1-d2\nd1-b2\nd1-c3\ne2-e1\ne2-d2\ne2-c2\ne2-b2\na3-a4\na3-b2\na3-b4\nb3-b4\nb3-a4\ne3-d2\ne3-d4\ne3-c5\ne3-b6\ne3-e4\n"));

        chess.boardSet("18 W\n.k.B.\nqp.Np\n..p.K\npb..P\nP....\nR..Q.\n");
        assertTrue(movesCompare(chess.moves(), "d1-c2\nd1-b3\nd1-a4\nd1-e2\nd1-c1\nd1-e1\nd2-b1\nd2-b3\nd2-c4\ne3-e2\ne3-d3\ne3-d4\na5-b4\na6-b6\na6-c6\nd6-d5\nd6-d4\nd6-d3\nd6-c6\nd6-b6\nd6-e6\nd6-c5\nd6-b4\nd6-e5\n"));

        chess.boardSet("17 W\n.k..r\n....p\npPn.p\nQ.P.b\n.P.B.\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "b3-b2\na4-a3\na4-b4\na4-a5\nb5-b4\nd5-e4\nd5-c6\nd5-d4\nd5-c5\nd5-e5\nd5-d6\na6-a5\na6-b6\na6-c6\na6-d6\ne6-e5\ne6-d6\n"));

        chess.boardSet("12 W\nkqr..\n.ppQ.\n.....\n..PB.\nPp.KP\nRN...\n");
        assertTrue(movesCompare(chess.moves(), "d2-d1\nd2-c2\nd2-e2\nd2-d3\nd2-c1\nd2-e1\nd2-c3\nd2-b4\nd2-e3\nc4-c3\nd4-c3\nd4-b2\nd4-e3\nd4-c5\nd4-d3\nd4-e4\na5-a4\nd5-c5\nd5-d6\nd5-e4\nd5-c6\nd5-e6\ne5-e4\nb6-a4\n"));

        chess.boardSet("11 B\n.b..r\nk.ppp\npp.qN\nP..PP\nRPPB.\n...QK\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\ne1-d1\ne1-c1\na2-a1\na2-b2\nc2-c3\nd2-e3\nb3-b4\nb3-a4\nd3-c3\nd3-e3\nd3-d4\nd3-c4\nd3-b5\nd3-e4\n"));

        chess.boardSet("18 W\nkrn..\n..pbp\n.P.pP\npP.P.\nR.PQK\n.....\n");
        assertTrue(movesCompare(chess.moves(), "b3-b2\nb3-c2\ne3-d2\na5-a4\na5-b5\na5-a6\nc5-c4\nd5-d6\nd5-c4\nd5-e4\nd5-c6\nd5-e6\ne5-e4\ne5-e6\ne5-d6\n"));

        chess.boardSet("18 B\nk.q.r\np...p\n..pb.\nPPP..\nRNB..\nQ..K.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-b2\nc1-b1\nc1-d1\nc1-c2\nc1-b2\nc1-a3\nc1-d2\nc1-e3\ne1-d1\na2-a3\ne2-e3\nc3-b4\nd3-c2\nd3-b1\nd3-c4\nd3-e4\nd3-d2\nd3-e3\nd3-d4\n"));

        chess.boardSet("13 B\nk..nr\n.p..p\npq.P.\nPP.b.\n..PQK\nR.NB.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nd1-c3\nd1-e3\ne2-e3\ne2-d3\na3-b4\nb3-c3\nb3-d3\nb3-b4\nb3-a2\nb3-c2\nb3-a4\nb3-c4\nb3-d5\nd4-c3\nd4-e3\nd4-c5\nd4-e5\nd4-c4\nd4-e4\n"));

        chess.boardSet("15 W\n....r\np.pQp\nbkq..\n.P...\nP..np\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "d2-d1\nd2-c2\nd2-e2\nd2-d3\nd2-d4\nd2-d5\nd2-c1\nd2-e1\nd2-c3\nd2-e3\nb4-a3\nb4-c3\na5-a4\na6-b6\na6-c6\na6-d6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("13 B\n.q.r.\npk.QP\n.....\n....b\npPP.K\nR.B..\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-c2\nb1-d3\nd1-c1\nd1-e1\nd1-d2\na2-a3\nb2-c2\nb2-b3\nb2-a1\nb2-c1\nb2-a3\nb2-c3\ne4-d3\ne4-c2\ne4-d5\ne4-c6\ne4-e3\ne4-d4\n"));

        chess.boardSet("12 W\nknqbr\np.P..\n....P\n..N..\n.Pp.Q\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "c2-b1\nc2-d1\ne3-e2\nc4-a3\nc4-b2\nc4-d2\nc4-a5\nc4-b6\nc4-d6\nb5-b4\ne5-e4\ne5-d5\ne5-c5\ne5-d4\ne5-c3\ne5-b2\ne5-a1\ne5-d6\na6-a5\na6-a4\na6-a3\na6-a2\na6-b6\na6-c6\na6-d6\ne6-d6\ne6-d5\n"));

        chess.boardSet("16 W\n.Q.nr\nbk...\n.P.pp\nN..PP\nR.PK.\n.Q...\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-d1\nb1-b2\nb1-a2\nb1-c2\nb1-d3\nb3-a2\na4-c3\na4-b2\nd4-e3\ne4-d3\na5-b5\na5-a6\nc5-c4\nd5-e5\nd5-d6\nd5-c4\nd5-c6\nd5-e6\nb6-b5\nb6-b4\nb6-a6\nb6-c6\nb6-d6\nb6-e6\n"));

        chess.boardSet("13 B\nk...r\n.pq.p\npp..b\nP.p..\nR.BPn\n.Q..K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\ne1-d1\ne1-c1\ne1-b1\nc2-c1\nc2-d2\nc2-c3\nc2-b1\nc2-d1\nc2-d3\nc2-e4\nb3-b4\nb3-a4\ne3-d2\ne3-c1\ne3-d4\ne3-c5\ne3-d3\ne3-e4\nc4-d5\ne5-d3\ne5-c6\n"));

        chess.boardSet("18 B\n.k..r\n.p..p\n..ppB\nnp...\nP..QP\nR..K.\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-a2\nb1-c2\ne1-d1\ne1-c1\nb2-b3\nc3-c4\nd3-d4\na4-c5\na4-b6\nb4-b5\nb4-a5\n"));

        chess.boardSet("20 B\n.qbr.\n...N.\npQ..n\nk.PpB\n....P\nR..K.\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-b2\nb1-b3\nb1-a2\nb1-c2\nb1-d3\nb1-e4\nc1-b2\nc1-d2\nc1-c2\nd1-e1\nd1-d2\ne3-c2\ne3-c4\ne3-d5\na4-b4\na4-a5\na4-b3\na4-b5\nd4-d5\nd4-e5\n"));

        chess.boardSet("20 W\n...r.\nk.q.p\np...P\n.p.KN\n.P.pP\n.R.B.\n");
        assertTrue(movesCompare(chess.moves(), "d4-d3\nd4-c4\nd4-d5\nd4-c3\nd4-c5\ne4-c3\ne4-d2\ne4-c5\nb6-a6\nb6-c6\nd6-c5\nd6-b4\nd6-c6\nd6-e6\n"));

        chess.boardSet("16 B\nk..b.\n.q.Nr\np...p\nR..BP\n..PQ.\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nd1-c2\nd1-b3\nd1-a4\nd1-c1\nd1-e1\nb2-b1\nb2-a2\nb2-c2\nb2-d2\nb2-b3\nb2-b4\nb2-b5\nb2-b6\nb2-c1\nb2-c3\nb2-d4\ne2-e1\ne2-d2\ne3-d4\n"));

        chess.boardSet("20 W\n...nN\n.....\npk..b\nqpPPP\nR....\n..B.K\n");
        assertTrue(movesCompare(chess.moves(), "e1-c2\ne1-d3\nc4-c3\nc4-b3\nd4-d3\nd4-e3\na5-a4\na5-b5\na5-c5\na5-d5\na5-e5\na5-a6\nc6-b5\nc6-a4\nc6-d5\nc6-c5\nc6-b6\nc6-d6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("14 W\nb...r\nkp.pp\np....\nnP..q\nR.P.Q\n.NKB.\n");
        assertTrue(movesCompare(chess.moves(), "b4-b3\nb4-a3\na5-a4\na5-b5\na5-a6\nc5-c4\ne5-e4\ne5-d5\ne5-e6\ne5-d4\ne5-c3\ne5-b2\nb6-a4\nb6-d5\nb6-c4\nc6-b5\nc6-d5\nd6-d5\nd6-e6\n"));

        chess.boardSet("11 B\n..knr\n.p.pp\npbP..\nP.qPP\n.BP.K\nR..Q.\n");
        assertTrue(movesCompare(chess.moves(), "c1-b1\nc1-c2\nd1-c3\nd1-e3\nb2-c3\nd2-d3\nd2-c3\ne2-e3\nb3-a2\nb3-c2\nb3-a4\nb3-b4\nc4-c3\nc4-b4\nc4-a4\nc4-d4\nc4-c5\nc4-d3\nc4-b5\nc4-d5\nc4-e6\n"));

        chess.boardSet("19 W\n..r..\np.k.p\nn.p.p\np..Pb\nP....\n..R.K\n");
        assertTrue(movesCompare(chess.moves(), "d4-d3\nd4-c3\nd4-e3\nc6-c5\nc6-c4\nc6-c3\nc6-b6\nc6-a6\nc6-d6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("15 B\n.k.br\n.N..p\n.qp..\n..PpP\np..KB\nR....\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\nb1-a2\nb1-c2\nd1-c2\nd1-c1\nd1-d2\ne2-e3\nb3-b2\nb3-a3\nb3-b4\nb3-b5\nb3-b6\nb3-a2\nb3-c2\nb3-a4\nb3-c4\nd4-e5\n"));

        chess.boardSet("19 B\n.kqnB\n.N..r\npb..p\nP.P..\nR..P.\n..q.K\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-b2\nb1-a2\nb1-c2\nc1-c2\nc1-c3\nc1-c4\nc1-b2\nc1-d2\nd1-b2\nd1-c3\ne2-e1\ne2-d2\ne2-c2\ne2-b2\nb3-a2\nb3-c2\nb3-a4\nb3-c4\nb3-c3\nb3-b4\ne3-e4\nc6-c5\nc6-c4\nc6-b6\nc6-a6\nc6-d6\nc6-e6\nc6-b5\nc6-a4\nc6-d5\n"));

        chess.boardSet("16 W\nkq...\npr.np\n.pP.N\n..p.P\nP..P.\n..RQK\n");
        assertTrue(movesCompare(chess.moves(), "c3-c2\nc3-b2\nc3-d2\ne3-c2\ne3-d1\ne3-c4\na5-a4\nd5-d4\nd5-c4\nc6-c5\nc6-c4\nc6-b6\nc6-a6\nd6-c5\nd6-b4\nd6-a3\nd6-e5\ne6-e5\n"));

        chess.boardSet("13 W\n.k.nr\np.ppp\nb....\n..P.P\npPQqK\n.B...\n");
        assertTrue(movesCompare(chess.moves(), "c4-c3\ne4-e3\nb5-b4\nc5-d5\nc5-c6\nc5-b4\nc5-a3\nc5-d4\nc5-e3\nc5-d6\ne5-d5\ne5-e6\ne5-d4\ne5-d6\nb6-a5\nb6-a6\nb6-c6\n"));

        chess.boardSet("15 B\n...n.\n.ppbp\nq..p.\npPkP.\nPRP.P\n.BQ.K\n");
        assertTrue(movesCompare(chess.moves(), "d1-c3\nd1-e3\nb2-b3\nc2-c3\nd2-c1\nd2-e1\nd2-c3\nd2-b4\nd2-e3\ne2-e3\na3-a2\na3-a1\na3-b3\na3-c3\na3-b4\na4-b5\nc4-c3\nc4-b4\nc4-d4\nc4-c5\nc4-b3\nc4-b5\nc4-d5\n"));

        chess.boardSet("16 W\nk.b.r\nP.n.p\n..pKp\np..q.\nR.P.B\n.N.Q.\n");
        assertTrue(movesCompare(chess.moves(), "d3-d2\nd3-c3\nd3-e3\nd3-d4\nd3-c2\nd3-e2\nd3-c4\nd3-e4\na5-a4\na5-b5\na5-a6\nc5-c4\nc5-d4\ne5-d4\ne5-e4\ne5-d5\ne5-e6\nb6-a4\nb6-d5\nb6-c4\nd6-d5\nd6-d4\nd6-c6\nd6-e6\n"));

        chess.boardSet("17 B\n..r..\n.kP.p\np...K\n..p.B\nP..P.\nQ....\n");
        assertTrue(movesCompare(chess.moves(), "c1-b1\nc1-a1\nc1-d1\nc1-e1\nc1-c2\nb2-b1\nb2-a2\nb2-c2\nb2-b3\nb2-a1\nb2-c3\na3-a4\nc4-c5\nc4-d5\n"));

        chess.boardSet("18 W\n....r\nkp..p\n.....\n..B..\nP.P.K\nNRqQ.\n");
        assertTrue(movesCompare(chess.moves(), "c4-b3\nc4-a2\nc4-d3\nc4-e2\nc4-b5\nc4-d5\nc4-e6\nc4-c3\nc4-b4\nc4-d4\na5-a4\ne5-e4\ne5-d5\ne5-e6\ne5-d4\na6-b4\nb6-b5\nb6-b4\nb6-b3\nb6-b2\nb6-c6\nd6-d5\nd6-d4\nd6-d3\nd6-d2\nd6-d1\nd6-c6\nd6-e6\n"));

        chess.boardSet("13 W\nkqb..\n.....\np.NPp\n.p..P\nBPrPQ\nR...K\n");
        assertTrue(movesCompare(chess.moves(), "c3-a2\nc3-b1\nc3-e2\nc3-d1\nc3-a4\nd3-d2\na5-b4\na5-b6\na5-a4\nd5-d4\ne5-d4\ne5-d6\na6-b6\na6-c6\na6-d6\ne6-d6\n"));

        chess.boardSet("17 W\n..b..\nk.p..\nppNp.\nP.K.r\n.Bq..\nRQ...\n");
        assertTrue(movesCompare(chess.moves(), "c3-a2\nc3-b1\nc3-e2\nc3-d1\nc3-e4\nc3-d5\na4-b3\nc4-b4\nc4-d4\nc4-c5\nc4-b3\nc4-d3\nc4-d5\nb5-c6\nb5-b4\nb5-a5\na6-a5\nb6-c6\nb6-d6\nb6-e6\nb6-a5\nb6-c5\n"));

        chess.boardSet("15 W\n..b..\nk..rp\n..p.P\n.nPq.\nPPQ..\n.RB.K\n");
        assertTrue(movesCompare(chess.moves(), "e3-d2\na5-a4\na5-b4\nc5-d5\nc5-e5\nc5-b4\nc5-d4\nc5-d6\nb6-a6\nc6-d5\nc6-e4\nc6-d6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("16 W\nknqr.\np..Pb\n....P\np.p.Q\nP.P..\nR..BK\n");
        assertTrue(movesCompare(chess.moves(), "d2-c1\ne4-d4\ne4-c4\ne4-e5\ne4-d3\ne4-c2\ne4-b1\ne4-d5\ne4-c6\na6-b6\na6-c6\nd6-e5\nd6-d5\nd6-c6\ne6-e5\ne6-d5\n"));

        chess.boardSet("18 W\nk..n.\nr....\nppP.p\nPRbK.\n.....\n..B.Q\n");
        assertTrue(movesCompare(chess.moves(), "c3-c2\na4-b3\nb4-b3\nb4-c4\nb4-b5\nb4-b6\nd4-d3\nd4-c4\nd4-e4\nd4-d5\nd4-e3\nd4-c5\nd4-e5\nc6-b5\nc6-d5\nc6-e4\nc6-c5\nc6-b6\nc6-d6\ne6-e5\ne6-e4\ne6-e3\ne6-d6\ne6-d5\ne6-c4\n"));

        chess.boardSet("20 B\nk.Nr.\n.n..p\npQpp.\np..q.\n.R...\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nd1-c1\nd1-e1\nd1-d2\nb2-c4\ne2-e3\nc3-c4\na4-a5\na4-b5\nd4-c4\nd4-b4\nd4-e4\nd4-d5\nd4-d6\nd4-e3\nd4-c5\nd4-b6\nd4-e5\n"));

        chess.boardSet("13 B\n...nr\nkqP.p\np.b..\nPP.PP\n..R..\n.NBK.\n");
        assertTrue(movesCompare(chess.moves(), "d1-e3\na2-a1\na2-b1\na2-b3\nb2-b1\nb2-c2\nb2-b3\nb2-b4\nb2-a1\nb2-c1\ne2-e3\na3-b4\nc3-d2\nc3-b4\nc3-d4\nc3-b3\nc3-d3\nc3-c4\n"));

        chess.boardSet("15 B\n.B..r\nqp...\nPk...\n...pQ\nP.P.P\nRN.K.\n");
        assertTrue(movesCompare(chess.moves(), "e1-d1\ne1-c1\ne1-b1\ne1-e2\ne1-e3\ne1-e4\na2-a1\na2-a3\na2-b1\nb2-a3\nb3-a3\nb3-c3\nb3-b4\nb3-c2\nb3-a4\nb3-c4\nd4-d5\nd4-c5\nd4-e5\n"));

        chess.boardSet("16 B\n.k..r\np..pN\n.....\nB..Pp\n.P...\nRn..K\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\nb1-c2\ne1-d1\ne1-c1\ne1-e2\na2-a3\nd2-d3\ne4-e5\nb6-a4\nb6-d5\nb6-c4\n"));

        chess.boardSet("17 B\nk.nr.\n.pbp.\n..Qp.\n..p..\nP..KP\nR....\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nc1-a2\nc1-b3\nc1-e2\nd1-e1\nb2-b3\nb2-c3\nc2-b1\nc2-b3\nc2-a4\nd2-c3\nd3-d4\nc4-c5\nc4-d5\n"));

        chess.boardSet("20 W\nk.r..\np...p\np...P\nP...P\nRqK..\n.Q...\n");
        assertTrue(movesCompare(chess.moves(), "a5-b5\na5-a6\nc5-c4\nc5-b5\nc5-d5\nc5-c6\nc5-b4\nc5-d4\nc5-d6\nb6-b5\nb6-a6\nb6-c6\nb6-d6\nb6-e6\n"));

        chess.boardSet("15 B\nk..nr\np....\n..ppb\nB...K\nP.P..\nRQ...\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-b2\nd1-b2\ne1-e2\na2-a3\nc3-c4\nd3-d4\nd3-e4\ne3-d2\ne3-c1\ne3-d4\ne3-c5\ne3-e2\n"));

        chess.boardSet("15 W\n...r.\nk.pB.\nP...P\nR..q.\n.n..P\n.N..K\n");
        assertTrue(movesCompare(chess.moves(), "d2-c1\nd2-e1\nd2-c3\nd2-b4\nd2-a5\nd2-e2\nd2-d3\ne3-e2\na4-b4\na4-c4\na4-d4\na4-a5\na4-a6\ne5-e4\ne5-d4\nb6-d5\nb6-c4\ne6-d6\ne6-d5\n"));

        chess.boardSet("13 B\nk.q.r\n.p..n\np.p..\nPPPP.\n...PK\nRBQ..\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nc1-b1\nc1-d1\nc1-c2\nc1-d2\nc1-e3\ne1-d1\nb2-b3\ne2-d4\na3-b4\nc3-b4\nc3-d4\n"));

        chess.boardSet("11 B\nk..n.\npb.pr\n.qN.P\n.P...\nPP.KP\nR.B.Q\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\nd1-c3\nd1-e3\na2-a3\nb2-c1\nb2-a3\nb2-c3\nb2-b1\nb2-c2\nd2-d3\nd2-c3\nd2-e3\ne2-e1\ne2-e3\nb3-a3\nb3-c3\nb3-b4\nb3-c2\nb3-a4\nb3-c4\nb3-d5\n"));

        chess.boardSet("11 B\n.k.bQ\n.nP..\nppN.p\n.P..B\nP.P.P\n.R..K\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-a2\nb1-c2\nd1-c2\nd1-e2\nd1-c1\nd1-d2\nb2-a4\nb2-d3\nb2-c4\na3-a4\na3-b4\n"));

        chess.boardSet("13 W\n.qb..\nk.Kpr\n.Pn.p\np.Q.P\nP..P.\nRN..B\n");
        assertTrue(movesCompare(chess.moves(), "c2-c1\nc2-b2\nc2-d2\nc2-c3\nc2-b1\nc2-d1\nc2-d3\nb3-b2\nb3-a2\nc4-c3\nc4-b4\nc4-a4\nc4-d4\nc4-c5\nc4-c6\nc4-d3\nc4-e2\nc4-b5\nd5-d4\nb6-a4\ne6-e5\ne6-d6\n"));

        chess.boardSet("14 W\n..br.\n.kppp\npq.N.\n..PKP\nPP.P.\nRB...\n");
        assertTrue(movesCompare(chess.moves(), "d3-b2\nd3-c1\nd3-e1\nd3-b4\nd3-c5\nd3-e5\nc4-c3\nc4-b3\nd4-c3\nd4-e3\nd4-c5\nd4-e5\ne4-e3\na5-a4\nb5-b4\nb6-c5\nb6-c6\n"));

        chess.boardSet("15 B\nk..Nr\nq...p\npp.b.\nP.P..\n..K.P\nq....\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-b2\ne1-d1\na2-b2\na2-c2\na2-d2\na2-b1\ne2-e3\nb3-b4\nb3-a4\nb3-c4\nd3-c2\nd3-b1\nd3-c4\nd3-e4\nd3-d2\nd3-c3\nd3-e3\nd3-d4\na6-a5\na6-a4\na6-b6\na6-c6\na6-d6\na6-e6\na6-b5\na6-c4\n"));

        chess.boardSet("20 W\nk.bnr\n.pqp.\n..p.p\npPP..\nP.B.K\nRNQ..\n");
        assertTrue(movesCompare(chess.moves(), "b4-b3\nb4-c3\nc5-d4\nc5-e3\nc5-d6\nc5-b5\nc5-d5\ne5-e4\ne5-d5\ne5-e6\ne5-d4\ne5-d6\nb6-a4\nb6-d5\nc6-d6\nc6-e6\nc6-b5\nc6-a4\nc6-d5\nc6-e4\n"));

        chess.boardSet("19 W\nk....\n...p.\nN..r.\n.P.Pb\n...B.\n.n.QK\n");
        assertTrue(movesCompare(chess.moves(), "a3-c2\na3-b1\na3-c4\na3-b5\nb4-b3\nd5-c4\nd5-b3\nd5-a2\nd5-e4\nd5-c6\nd5-c5\nd5-e5\nd6-c6\nd6-b6\nd6-c5\nd6-e5\ne6-e5\n"));

        chess.boardSet("20 W\nq.r..\np..Pp\n.p.P.\n..P.K\n..P..\nkRBQ.\n");
        assertTrue(movesCompare(chess.moves(), "d2-d1\nd2-c1\nd3-e2\nc4-c3\nc4-b3\ne4-e3\ne4-d4\ne4-e5\ne4-d5\nb6-b5\nb6-b4\nb6-b3\nb6-a6\nc6-b5\nc6-a4\nc6-d5\nd6-d5\nd6-d4\nd6-e6\nd6-e5\n"));

        chess.boardSet("16 W\n.k..r\npN.P.\nn....\n...q.\nPPp.Q\n....K\n");
        assertTrue(movesCompare(chess.moves(), "b2-d1\nb2-a4\nb2-d3\nb2-c4\nd2-d1\nd2-e1\na5-a4\nb5-b4\ne5-e4\ne5-e3\ne5-e2\ne5-e1\ne5-d5\ne5-c5\ne5-d4\ne5-d6\ne6-d6\ne6-d5\n"));

        chess.boardSet("17 W\nkb.nr\nP....\n.....\n...pN\nqP.K.\n.RqB.\n");
        assertTrue(movesCompare(chess.moves(), "a2-b1\ne4-c3\ne4-d2\ne4-c5\nb5-b4\nd5-d4\nd5-c5\nd5-e5\nd5-c4\nd5-c6\nd5-e6\nb6-a6\nb6-c6\nd6-c5\nd6-b4\nd6-a3\nd6-e5\nd6-e6\n"));

        chess.boardSet("15 B\n.k.nr\np.q..\n.R.Bp\np.p..\n..PPP\n.NQK.\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\nd1-b2\nd1-c3\ne1-e2\na2-a3\na2-b3\nc2-c1\nc2-b2\nc2-d2\nc2-e2\nc2-c3\nc2-b3\nc2-d3\ne3-e4\na4-a5\nc4-d5\n"));

        chess.boardSet("14 B\n...N.\n.r.bp\n..P..\nk...p\n.PP..\nRBQ.K\n");
        assertTrue(movesCompare(chess.moves(), "b2-b1\nb2-a2\nb2-c2\nb2-b3\nb2-b4\nb2-b5\nd2-c1\nd2-e1\nd2-c3\nd2-e3\nd2-c2\nd2-d3\ne2-e3\na4-a3\na4-b4\na4-a5\na4-b3\na4-b5\ne4-e5\n"));

        chess.boardSet("20 B\nkqr..\npp.P.\n.npPp\nPPB.K\n.Q...\n.....\n");
        assertTrue(movesCompare(chess.moves(), "b1-c2\nb1-d3\nc1-d1\nc1-e1\nc1-c2\na2-a3\nb3-d2\nb3-a5\nb3-d4\nb3-c5\nc3-b4\n"));

        chess.boardSet("19 W\n...r.\npk.bp\n...Q.\np.PpP\nP...P\nR.Q.K\n");
        assertTrue(movesCompare(chess.moves(), "d3-d2\nd3-c3\nd3-b3\nd3-a3\nd3-e3\nd3-d4\nd3-c2\nd3-b1\nd3-e2\nc4-c3\ne4-e3\ne5-d4\na6-b6\nc6-c5\nc6-b6\nc6-d6\nc6-b5\nc6-a4\nc6-d5\ne6-d6\ne6-d5\n"));

        chess.boardSet("21 W\n.....\n...rb\n.Ppp.\n.Q...\n..P..\nkB..K\n");
        assertTrue(movesCompare(chess.moves(), "b3-b2\nb4-a4\nb4-c4\nb4-d4\nb4-e4\nb4-b5\nb4-a3\nb4-c3\nb4-a5\nc5-c4\nb6-a5\nb6-b5\nb6-c6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("20 W\nq..nr\n..kp.\n.p...\n.P...\nP..BK\n.....\n");
        assertTrue(movesCompare(chess.moves(), "a5-a4\nd5-c4\nd5-b3\nd5-e4\nd5-c6\nd5-e6\nd5-d4\nd5-c5\nd5-d6\ne5-e4\ne5-e6\ne5-d4\ne5-d6\n"));

        chess.boardSet("17 W\n...nr\npb.p.\nPp.Bp\n.P...\nR..kK\n.N.Q.\n");
        assertTrue(movesCompare(chess.moves(), "a3-b2\nd3-c2\nd3-b1\nd3-e2\nd3-c4\nd3-b5\nd3-a6\nd3-e4\nd3-c3\nd3-d4\na5-a4\na5-b5\na5-c5\na5-d5\na5-a6\ne5-e4\ne5-d5\ne5-e6\ne5-d4\nb6-a4\nb6-d5\nb6-c4\nd6-d5\nd6-c6\nd6-e6\nd6-c5\n"));

        chess.boardSet("19 W\n...n.\n.....\npkp..\n.qN.K\nq.Q..\n...B.\n");
        assertTrue(movesCompare(chess.moves(), "c4-a3\nc4-b2\nc4-e3\nc4-d2\nc4-a5\nc4-b6\nc4-e5\ne4-e3\ne4-d4\ne4-e5\ne4-d3\ne4-d5\nc5-b5\nc5-a5\nc5-d5\nc5-e5\nc5-c6\nc5-b4\nc5-d4\nc5-e3\nc5-b6\nd6-e5\nd6-d5\nd6-c6\nd6-e6\n"));

        chess.boardSet("14 W\nk.br.\np..Pq\n..P.n\n..p..\nP.PQK\n.RB..\n");
        assertTrue(movesCompare(chess.moves(), "d2-c1\nc3-c2\na5-a4\nd5-d4\nd5-d3\nd5-d6\nd5-c4\nd5-e4\nd5-e6\ne5-e4\ne5-e6\ne5-d4\ne5-d6\nb6-b5\nb6-b4\nb6-b3\nb6-b2\nb6-b1\nb6-a6\nc6-b5\nc6-a4\nc6-d6\n"));

        chess.boardSet("13 W\nbq..r\nk...p\np.p..\nP.P..\npPQ.P\n.B..K\n");
        assertTrue(movesCompare(chess.moves(), "b5-b4\nc5-d5\nc5-c6\nc5-b4\nc5-a3\nc5-d4\nc5-e3\nc5-d6\ne5-e4\nb6-a5\nb6-a6\nb6-c6\ne6-d6\ne6-d5\n"));

        chess.boardSet("21 W\n..knr\np.P.p\n....Q\nP.b..\n..PP.\n...qK\n");
        assertTrue(movesCompare(chess.moves(), "c2-d1\ne3-e2\ne3-d3\ne3-c3\ne3-b3\ne3-a3\ne3-e4\ne3-e5\ne3-d2\ne3-c1\ne3-d4\na4-a3\nd5-d4\nd5-c4\ne6-e5\ne6-d6\n"));

        chess.boardSet("13 B\n.bknr\np..pp\np.P..\nP.P.P\n..qP.\n..RBK\n");
        assertTrue(movesCompare(chess.moves(), "b1-c2\nb1-d3\nb1-e4\nb1-a1\nb1-b2\nc1-c2\nc1-b2\nd1-b2\nd1-c3\nd1-e3\nd2-d3\nd2-c3\ne2-e3\nc5-c4\nc5-b5\nc5-a5\nc5-d5\nc5-c6\nc5-b4\nc5-d4\nc5-e3\nc5-b6\nc5-d6\n"));

        chess.boardSet("15 B\nkq...\np.b.p\n.p.K.\nq.p..\nP.PQ.\n....R\n");
        assertTrue(movesCompare(chess.moves(), "a1-b2\nb1-c1\nb1-d1\nb1-e1\nb1-b2\na2-a3\nc2-d1\nc2-d3\nc2-c1\nc2-b2\nc2-d2\nc2-c3\ne2-e3\ne2-d3\nb3-b4\na4-a3\na4-b4\na4-a5\na4-b5\na4-c6\nc4-d5\n"));

        chess.boardSet("18 W\nkq...\n.pp.p\np.P..\nP.bP.\n.R..K\n..Q..\n");
        assertTrue(movesCompare(chess.moves(), "c3-b2\nd4-d3\nb5-b4\nb5-b3\nb5-b2\nb5-a5\nb5-c5\nb5-d5\nb5-b6\ne5-e4\ne5-d5\ne5-e6\ne5-d6\nc6-c5\nc6-c4\nc6-b6\nc6-a6\nc6-d6\nc6-e6\nc6-d5\nc6-e4\n"));

        chess.boardSet("14 B\nq..b.\nkp...\np...r\nP....\nR.pP.\n..NnK\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-c1\nd1-c2\nd1-b3\nd1-a4\nd1-e2\nd1-c1\nd1-e1\nd1-d2\na2-b1\na2-b3\nb2-b3\ne3-e2\ne3-e1\ne3-d3\ne3-c3\ne3-b3\ne3-e4\ne3-e5\ne3-e6\nd6-b5\nd6-c4\nd6-e4\n"));

        chess.boardSet("11 B\nk..br\n...p.\npppq.\n.P.p.\nP.PPP\nRNQ.K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\na1-b2\nd1-c2\nd1-e2\nd1-c1\ne1-e2\ne1-e3\ne1-e4\ne1-e5\na3-a4\na3-b4\nc3-c4\nc3-b4\nd3-e3\nd3-c2\nd3-b1\nd3-e2\nd3-c4\nd3-b5\nd3-a6\nd3-e4\nd4-c5\nd4-e5\n"));

        chess.boardSet("20 B\n....r\n..pPb\npkBR.\nq...n\nP...P\n....K\n");
        assertTrue(movesCompare(chess.moves(), "e1-d1\ne1-c1\ne1-b1\ne1-a1\nc2-d3\ne2-d1\ne2-d3\ne2-e3\nb3-b2\nb3-c3\nb3-b4\nb3-a2\nb3-c4\na4-b4\na4-c4\na4-d4\na4-a5\na4-b5\na4-c6\ne4-c3\ne4-d2\ne4-c5\ne4-d6\n"));

        chess.boardSet("18 W\n...br\nkp.Pp\nN....\nPPq.P\nR....\nB..QK\n");
        assertTrue(movesCompare(chess.moves(), "d2-e1\na3-c2\na3-b1\na3-c4\na3-b5\nb4-b3\ne4-e3\na5-b5\na5-c5\na5-d5\na5-e5\na6-b5\na6-c4\na6-b6\nd6-d5\nd6-d4\nd6-d3\nd6-c6\nd6-b6\nd6-c5\nd6-e5\ne6-e5\ne6-d5\n"));

        chess.boardSet("18 W\nk...r\nRp...\n..Bbp\n.p...\n..NpP\n...QK\n");
        assertTrue(movesCompare(chess.moves(), "a2-a1\na2-b2\na2-a3\na2-a4\na2-a5\na2-a6\nc3-b2\nc3-d2\nc3-e1\nc3-b4\nc3-d4\nc3-c2\nc3-b3\nc3-c4\nc5-a4\nc5-b3\nc5-e4\nc5-d3\nc5-a6\ne5-e4\nd6-d5\nd6-c6\nd6-b6\nd6-a6\ne6-d5\n"));

        chess.boardSet("12 B\nkq.r.\np...p\nbp...\n.nPp.\n..KBP\n.N...\n");
        assertTrue(movesCompare(chess.moves(), "a1-b2\nb1-c1\nb1-b2\nb1-c2\nb1-d3\nb1-e4\nd1-c1\nd1-e1\nd1-d2\nd1-d3\ne2-e3\na3-b2\na3-c1\na3-a4\nb3-c4\nb4-d3\nb4-c2\nb4-a6\nb4-d5\nb4-c6\nd4-c5\nd4-e5\n"));

        chess.boardSet("16 B\nQ..nr\nq..Pp\n.kp..\nPP...\nR..PP\n.N..K\n");
        assertTrue(movesCompare(chess.moves(), "d1-b2\nd1-e3\na2-a1\na2-b2\na2-c2\na2-d2\na2-a3\na2-a4\na2-b1\ne2-e3\nb3-b2\nb3-a3\nb3-b4\nb3-c2\nb3-a4\nb3-c4\nc3-c4\nc3-b4\n"));

        chess.boardSet("19 W\n...r.\n.k.pp\n.bp..\n..PQP\n...n.\nR.B.K\n");
        assertTrue(movesCompare(chess.moves(), "c4-b3\nd4-d3\nd4-d2\nd4-d5\nd4-c3\nd4-e3\nd4-c5\nd4-b6\nd4-e5\ne4-e3\na6-a5\na6-a4\na6-a3\na6-a2\na6-a1\na6-b6\nc6-b5\nc6-a4\nc6-d5\nc6-c5\nc6-b6\nc6-d6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("12 B\nk...r\n.pqbp\np....\nP.P.p\n..K..\nRN.n.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\ne1-d1\ne1-c1\ne1-b1\nb2-b3\nc2-c1\nc2-c3\nc2-c4\nc2-b1\nc2-d1\nc2-b3\nc2-a4\nc2-d3\nd2-c1\nd2-c3\nd2-b4\nd2-a5\nd2-e3\nd2-d1\nd2-d3\ne2-e3\ne4-e5\nd6-b5\nd6-c4\n"));

        chess.boardSet("19 B\n..kr.\nNp...\n..Kpn\n.....\nP.P..\n.q...\n");
        assertTrue(movesCompare(chess.moves(), "c1-b1\nc1-c2\nc1-d2\nd1-e1\nd1-d2\nb2-b3\nb2-c3\nd3-d4\ne3-c2\ne3-c4\ne3-d5\nb6-b5\nb6-b4\nb6-b3\nb6-a6\nb6-c6\nb6-d6\nb6-e6\nb6-a5\nb6-c5\n"));

        chess.boardSet("19 B\n.....\n.kqpr\nRPn.p\nN.P.P\n.B..K\n.....\n");
        assertTrue(movesCompare(chess.moves(), "b2-b1\nb2-a2\nb2-b3\nb2-a1\nb2-c1\nb2-a3\nc2-c1\nc2-b1\nc2-d1\nc2-b3\nc2-d3\nc2-e4\nd2-d3\ne2-e1\nc3-a2\nc3-b1\nc3-d1\nc3-a4\nc3-b5\nc3-e4\nc3-d5\n"));

        chess.boardSet("12 B\n.k.nr\npq.p.\n.Bb.p\n.P.PP\n.R...\n.N.QK\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-c2\ne1-e2\na2-a3\na2-b3\nb2-c2\nb2-b3\nb2-a1\nb2-c1\nb2-a3\nd2-d3\nc3-b4\nc3-d4\nc3-c2\nc3-d3\nc3-c4\ne3-d4\n"));

        chess.boardSet("16 W\n..b..\nP...B\n..kq.\n....r\nP.PNP\nR..QK\n");
        assertTrue(movesCompare(chess.moves(), "a2-a1\ne2-d1\ne2-d3\ne2-e1\ne2-d2\ne2-e3\na5-a4\nc5-c4\nd5-b4\nd5-c3\nd5-e3\nd5-b6\na6-b6\na6-c6\nd6-c6\nd6-b6\n"));

        chess.boardSet("12 B\nkq.r.\npNp..\np.b.p\n..PpP\n..PP.\nRB.QK\n");
        assertTrue(movesCompare(chess.moves(), "a1-b2\nb1-c1\nb1-b2\nd1-c1\nd1-e1\nd1-d2\nd1-d3\na3-a4\nc3-b2\nc3-d2\nc3-e1\nc3-b4\nc3-a5\nc3-b3\nc3-d3\nd4-c5\n"));

        chess.boardSet("16 W\n.r...\nkp.bp\nRP.qn\n.....\n.QPP.\n.q..K\n");
        assertTrue(movesCompare(chess.moves(), "a3-a2\na3-a4\na3-a5\na3-a6\nb3-a2\nb5-b4\nb5-a5\nb5-b6\nb5-a4\nb5-c4\nb5-d3\nb5-a6\nb5-c6\nc5-c4\nd5-d4\ne6-e5\ne6-d6\n"));

        chess.boardSet("17 W\n.kb..\n.pp..\n.q.Pr\nB.PQ.\nPn..K\nRN...\n");
        assertTrue(movesCompare(chess.moves(), "d3-d2\nd3-c2\na4-b3\na4-b5\na4-a3\na4-b4\nc4-c3\nc4-b3\nd4-e4\nd4-d5\nd4-d6\nd4-c3\nd4-b2\nd4-e3\nd4-c5\ne5-e4\ne5-d5\ne5-e6\ne5-d6\nb6-d5\n"));

        chess.boardSet("20 B\nk.b.r\n.npp.\n..R..\n.PPPB\n....Q\n...K.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nc1-b1\nc1-d1\ne1-d1\ne1-e2\ne1-e3\ne1-e4\nb2-d1\nb2-a4\nb2-d3\nb2-c4\nd2-d3\nd2-c3\n"));

        chess.boardSet("16 W\nq..nr\n.p...\npPk.p\n.P.P.\n..P.P\nRB.K.\n");
        assertTrue(movesCompare(chess.moves(), "b4-a3\nb4-c3\nd4-d3\nd4-c3\nd4-e3\nc5-c4\ne5-e4\na6-a5\na6-a4\na6-a3\nb6-a5\nb6-b5\nb6-c6\nd6-d5\nd6-c6\nd6-e6\n"));

        chess.boardSet("13 B\n..b.r\n.kq.p\np.n..\npPPK.\n...P.\nRNB.Q\n");
        assertTrue(movesCompare(chess.moves(), "c1-d2\nc1-e3\nc1-b1\nc1-d1\ne1-d1\nb2-b1\nb2-a2\nb2-b3\nb2-a1\nc2-d2\nc2-b1\nc2-d1\nc2-b3\nc2-d3\nc2-e4\ne2-e3\na3-b4\nc3-a2\nc3-b1\nc3-d1\nc3-b5\nc3-e4\nc3-d5\na4-a5\n"));

        chess.boardSet("17 W\n.Qqr.\nk.p..\nQ....\nP.p.p\n...KP\nR....\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\nb1-b3\nb1-b4\nb1-b5\nb1-b6\nb1-a2\nb1-c2\na3-a2\na3-b3\na3-c3\na3-d3\na3-e3\na3-b2\na3-c1\na3-b4\na3-c5\na3-d6\nd5-d4\nd5-c5\nd5-d6\nd5-c4\nd5-e4\nd5-c6\nd5-e6\na6-a5\na6-b6\na6-c6\na6-d6\na6-e6\n"));

        chess.boardSet("19 B\n...b.\nk.pp.\n..Rr.\np..PP\n.BP..\n..K..\n");
        assertTrue(movesCompare(chess.moves(), "d1-e2\nd1-c1\nd1-e1\na2-a1\na2-b2\na2-a3\na2-b1\na2-b3\nd2-c3\nd3-c3\nd3-e3\nd3-d4\na4-a5\na4-b5\n"));

        chess.boardSet("17 B\nk....\npp..p\n..Q..\n.bpP.\nPP..P\nRNQK.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na2-a3\nb2-b3\nb2-c3\ne2-e3\nb4-a3\nb4-c3\nb4-a5\nb4-c5\nb4-d6\nb4-b3\nb4-a4\nc4-c5\nc4-b5\n"));

        chess.boardSet("16 B\nk.bnr\n.q..p\nR.pBP\n.P.P.\n..P.K\n.N.Q.\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\nc1-d2\nc1-e3\nc1-b1\nc1-c2\nd1-e3\nb2-b1\nb2-a2\nb2-c2\nb2-d2\nb2-b3\nb2-b4\nb2-a3\ne2-d3\nc3-c4\nc3-b4\nc3-d4\n"));

        chess.boardSet("17 B\n....r\npq.p.\nk.p..\nb.P.P\nP...K\nRQ...\n");
        assertTrue(movesCompare(chess.moves(), "e1-d1\ne1-c1\ne1-b1\ne1-a1\ne1-e2\ne1-e3\ne1-e4\nb2-b1\nb2-c2\nb2-b3\nb2-b4\nb2-b5\nb2-b6\nb2-a1\nb2-c1\nd2-d3\na3-b3\na3-b4\na4-b3\na4-c2\na4-d1\na4-b5\na4-c6\na4-b4\n"));

        chess.boardSet("14 B\n....r\nk.b.p\nppp.q\nPP..B\n.QpKP\n....R\n");
        assertTrue(movesCompare(chess.moves(), "e1-d1\ne1-c1\ne1-b1\ne1-a1\na2-a1\na2-b2\na2-b1\nc2-b1\nc2-d1\nc2-d3\nc2-e4\nc2-c1\nc2-b2\nc2-d2\na3-b4\nb3-a4\nc3-c4\nc3-b4\ne3-d3\ne3-e4\ne3-d2\ne3-c1\ne3-d4\nc5-c6\n"));

        chess.boardSet("16 B\nk..n.\n...r.\np.Bp.\n.Pp..\nP.p.P\nR.Q.K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-a2\na1-b2\nd1-b2\nd1-c3\nd1-e3\nd2-c2\nd2-b2\nd2-a2\nd2-e2\na3-a4\na3-b4\nd3-d4\n"));

        chess.boardSet("13 B\n.q.n.\np.pp.\nPpk..\n..P.P\nPN...\nRQ..K\n");
        assertTrue(movesCompare(chess.moves(), "b1-a1\nb1-c1\nb1-b2\nd1-b2\nd1-e3\nd2-d3\nb3-b4\nb3-c4\nc3-d3\nc3-c4\nc3-b2\nc3-b4\nc3-d4\n"));

        chess.boardSet("14 W\n...br\npk.pp\n.P.q.\n.P.P.\n..QKn\nR..B.\n");
        assertTrue(movesCompare(chess.moves(), "b3-a2\nc5-c4\nc5-c3\nc5-c2\nc5-c1\nc5-b5\nc5-a5\nc5-c6\nc5-b6\nd5-e5\nd5-c4\nd5-e4\nd5-c6\nd5-e6\na6-a5\na6-a4\na6-a3\na6-a2\na6-b6\na6-c6\nd6-e5\nd6-c6\nd6-e6\n"));

        chess.boardSet("13 B\nkq.nr\n..ppP\nppN..\n.P..P\nQ....\nb..BK\n");
        assertTrue(movesCompare(chess.moves(), "a1-a2\na1-b2\nb1-c1\nb1-b2\nb1-a2\nd1-b2\nd1-c3\nd1-e3\ne1-e2\nd2-d3\nd2-c3\na3-a4\na3-b4\na6-b5\na6-c4\na6-d3\na6-e2\na6-b6\n"));

        chess.boardSet("20 W\n.q..r\n.k..b\np....\nB..pP\nRn...\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a4-b3\na4-c2\na4-d1\na4-b5\na4-b4\ne4-e3\na5-b5\na5-a6\ne6-e5\ne6-d6\ne6-d5\n"));

        chess.boardSet("14 B\nk...b\np.p.p\n..p..\nP.N..\nR.pPQ\n....K\n");
        assertTrue(movesCompare(chess.moves(), "a1-b1\na1-b2\ne1-d2\ne1-d1\na2-a3\ne2-e3\nc5-c6\n"));
    }

    @Test
    public void movesShuffled() throws Exception {

    }

    @Test
    public void movesEvaluated() throws Exception {

    }

    @Test
    public void move() throws Exception {
        chess.reset();
        chess.move("b5-b4");
        assertEquals(chess.boardGet(), "1 B\nkqbnr\nppppp\n.....\n.P...\nP.PPP\nRNBQK\n");

        chess.boardSet("20 W\n.....\nPk...\n...R.\nNbPrp\nBQ.nP\n....K\n");
        chess.move("a5-b6");
        assertEquals(chess.boardGet(), "20 B\n.....\nPk...\n...R.\nNbPrp\n.Q.nP\n.B..K\n");

        chess.boardSet("12 B\nkq..r\n.Nb..\np.ppp\n..PP.\nP..KP\nR....\n");
        chess.move("a1-b2");
        assertEquals(chess.boardGet(), "13 W\n.q..r\n.kb..\np.ppp\n..PP.\nP..KP\nR....\n");

        chess.boardSet("18 W\nk....\nq.b.p\nppP.P\nBP.r.\nP.p.P\n.RK..\n");
        chess.move("a4-b3");
        assertEquals(chess.boardGet(), "18 B\nk....\nq.b.p\npBP.P\n.P.r.\nP.p.P\n.RK..\n");

        chess.boardSet("20 B\nk...Q\n.p...\nbp..P\n.B.K.\nP....\nRn...\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "21 W\n.k..Q\n.p...\nbp..P\n.B.K.\nP....\nRn...\n");

        chess.boardSet("18 B\nkr..b\n.p...\np.ppq\nPPK..\n..P.n\n..R..\n");
        chess.move("e5-c6");
        assertEquals(chess.boardGet(), "19 W\nkr..b\n.p...\np.ppq\nPPK..\n..P..\n..n..\n");

        chess.boardSet("19 W\n.k..r\n.p.qP\n.PN..\n.p.Pp\nPBp.P\n..R.K\n");
        chess.move("c3-d1");
        assertEquals(chess.boardGet(), "19 B\n.k.Nr\n.p.qP\n.P...\n.p.Pp\nPBp.P\n..R.K\n");

        chess.boardSet("15 B\nqk.rQ\n..pp.\np.b..\n...Qn\nPPPB.\nR..K.\n");
        chess.move("b1-b2");
        assertEquals(chess.boardGet(), "16 W\nq..rQ\n.kpp.\np.b..\n...Qn\nPPPB.\nR..K.\n");

        chess.boardSet("12 W\n.b..r\np.ppp\n.p..B\nk.P..\nPP.PP\nn..QK\n");
        chess.move("e3-c5");
        assertEquals(chess.boardGet(), "12 B\n.b..r\np.ppp\n.p...\nk.P..\nPPBPP\nn..QK\n");

        chess.boardSet("19 B\nB...k\np.P.p\n....P\nb...K\n.....\n..RQ.\n");
        chess.move("a4-b3");
        assertEquals(chess.boardGet(), "20 W\nB...k\np.P.p\n.b..P\n....K\n.....\n..RQ.\n");

        chess.boardSet("21 W\n.kbQ.\n.....\n.....\nq.N.r\n...Pp\n.R..K\n");
        chess.move("c4-d2");
        assertEquals(chess.boardGet(), "21 B\n.kbQ.\n...N.\n.....\nq...r\n...Pp\n.R..K\n");

        chess.boardSet("15 B\n.k.r.\nB.bp.\np.p.p\nP....\n..Pqn\nRN..K\n");
        chess.move("c2-e4");
        assertEquals(chess.boardGet(), "16 W\n.k.r.\nB..p.\np.p.p\nP...b\n..Pqn\nRN..K\n");

        chess.boardSet("13 W\n..b..\npqppr\nPB.k.\n...Qn\n..P.p\nR...K\n");
        chess.move("c5-c4");
        assertEquals(chess.boardGet(), "13 B\n..b..\npqppr\nPB.k.\n..PQn\n....p\nR...K\n");

        chess.boardSet("19 W\n....b\n.....\nkpp..\nPPNP.\n...Q.\nRB..K\n");
        chess.move("b4-a3");
        assertEquals(chess.boardGet(), "19 B\n....b\n.....\nPpp..\nP.NP.\n...Q.\nRB..K\n");

        chess.boardSet("15 W\nk...r\nB.q..\npp..p\n....P\nPbP..\nR..K.\n");
        chess.move("a6-c6");
        assertEquals(chess.boardGet(), "15 B\nk...r\nB.q..\npp..p\n....P\nPbP..\n..RK.\n");

        chess.boardSet("16 B\n...Qr\npk.pp\n.....\nb....\n.PP.P\n..RQK\n");
        chess.move("b2-a1");
        assertEquals(chess.boardGet(), "17 W\nk..Qr\np..pp\n.....\nb....\n.PP.P\n..RQK\n");

        chess.boardSet("15 W\nq..nr\nkp...\n...pp\nb..K.\n..P.P\nR..Q.\n");
        chess.move("a6-a5");
        assertEquals(chess.boardGet(), "15 B\nq..nr\nkp...\n...pp\nb..K.\nR.P.P\n...Q.\n");

        chess.boardSet("15 W\n....r\nkp..q\n.PN.p\nP...b\n.K..p\nR...Q\n");
        chess.move("a6-c6");
        assertEquals(chess.boardGet(), "15 B\n....r\nkp..q\n.PN.p\nP...b\n.K..p\n..R.Q\n");

        chess.boardSet("17 B\nk.q..\np.b.r\nP.pP.\n.....\n.pBK.\nR....\n");
        chess.move("c2-b3");
        assertEquals(chess.boardGet(), "18 W\nk.q..\np...r\nPbpP.\n.....\n.pBK.\nR....\n");

        chess.boardSet("20 B\nq.b..\nk..pr\nP.pn.\nP.p.p\n..QBP\n.NR.K\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "21 W\n.qb..\nk..pr\nP.pn.\nP.p.p\n..QBP\n.NR.K\n");

        chess.boardSet("17 W\n.....\nq.kbr\npP.pn\nP.pQP\n.BP..\nR...K\n");
        chess.move("d4-c3");
        assertEquals(chess.boardGet(), "17 B\n.....\nq.kbr\npPQpn\nP.p.P\n.BP..\nR...K\n");

        chess.boardSet("15 W\nk..br\n.N.pp\nn....\nP...q\n.Q.KP\n...R.\n");
        chess.move("b5-d3");
        assertEquals(chess.boardGet(), "15 B\nk..br\n.N.pp\nn..Q.\nP...q\n...KP\n...R.\n");

        chess.boardSet("13 W\n..qbr\nkppNB\n....p\n....P\nP.pP.\n.R.KQ\n");
        chess.move("b6-b5");
        assertEquals(chess.boardGet(), "13 B\n..qbr\nkppNB\n....p\n....P\nPRpP.\n...KQ\n");

        chess.boardSet("15 W\nkq...\np..p.\nbpp..\n.PnPr\nB...P\n.R.QK\n");
        chess.move("a5-a6");
        assertEquals(chess.boardGet(), "15 B\nkq...\np..p.\nbpp..\n.PnPr\n....P\nBR.QK\n");

        chess.boardSet("12 B\n..b..\npkprB\nP.pPp\n....p\n..P..\n.R.QK\n");
        chess.move("c1-b1");
        assertEquals(chess.boardGet(), "13 W\n.b...\npkprB\nP.pPp\n....p\n..P..\n.R.QK\n");

        chess.boardSet("14 W\nkb..q\n...rp\nPp.pn\n.pPPQ\n..R.P\n....K\n");
        chess.move("c4-b3");
        assertEquals(chess.boardGet(), "14 B\nkb..q\n...rp\nPP.pn\n.p.PQ\n..R.P\n....K\n");

        chess.boardSet("21 W\n.Q...\np...Q\n..n.r\n..pP.\nPkPKP\nR....\n");
        chess.move("e2-e1");
        assertEquals(chess.boardGet(), "21 B\n.Q..Q\np....\n..n.r\n..pP.\nPkPKP\nR....\n");

        chess.boardSet("15 B\nkqB.r\npp.bp\nP..p.\n.....\n.RPPP\n..Q.K\n");
        chess.move("e2-e3");
        assertEquals(chess.boardGet(), "16 W\nkqB.r\npp.b.\nP..pp\n.....\n.RPPP\n..Q.K\n");

        chess.boardSet("15 W\nkq.br\nppp.p\n..n..\n..PPp\n....Q\n..R.K\n");
        chess.move("e5-b5");
        assertEquals(chess.boardGet(), "15 B\nkq.br\nppp.p\n..n..\n..PPp\n.Q...\n..R.K\n");

        chess.boardSet("11 B\n.k.nr\npp.pp\n..P..\nN.p.P\nP.qB.\nQ.R.K\n");
        chess.move("b1-c1");
        assertEquals(chess.boardGet(), "12 W\n..knr\npp.pp\n..P..\nN.p.P\nP.qB.\nQ.R.K\n");

        chess.boardSet("17 W\n.k..r\n.n..p\n..Pp.\nQ...B\nPP.N.\nRb..K\n");
        chess.move("b5-b4");
        assertEquals(chess.boardGet(), "17 B\n.k..r\n.n..p\n..Pp.\nQP..B\nP..N.\nRb..K\n");

        chess.boardSet("16 B\n.k.N.\n...P.\n..bP.\n.p..r\nPP...\nR.B.K\n");
        chess.move("b1-a2");
        assertEquals(chess.boardGet(), "17 W\n...N.\nk..P.\n..bP.\n.p..r\nPP...\nR.B.K\n");

        chess.boardSet("16 B\n...nr\n.p..p\n...P.\nPPkbp\n.RB..\nqNK.Q\n");
        chess.move("a6-b5");
        assertEquals(chess.boardGet(), "17 W\n...nr\n.p..p\n...P.\nPPkbp\n.qB..\n.NK.Q\n");

        chess.boardSet("19 W\n.b..r\np.ppp\n.k..K\n..nP.\n.R.P.\nB.Q..\n");
        chess.move("a6-b6");
        assertEquals(chess.boardGet(), "19 B\n.b..r\np.ppp\n.k..K\n..nP.\n.R.P.\n.BQ..\n");

        chess.boardSet("14 W\n..qr.\nkbp..\n..pp.\n..PpP\nP...K\nRBQ..\n");
        chess.move("b6-d4");
        assertEquals(chess.boardGet(), "14 B\n..qr.\nkbp..\n..pp.\n..PBP\nP...K\nR.Q..\n");

        chess.boardSet("17 B\n.k..r\n.pp.Q\nPqN..\n..PBP\n...nK\n.....\n");
        chess.move("b3-b5");
        assertEquals(chess.boardGet(), "18 W\n.k..r\n.pp.Q\nP.N..\n..PBP\n.q.nK\n.....\n");

        chess.boardSet("12 B\nk.br.\npRn.p\nP.pN.\n....P\n..PPK\n..BQ.\n");
        chess.move("c2-b4");
        assertEquals(chess.boardGet(), "13 W\nk.br.\npR..p\nP.pN.\n.n..P\n..PPK\n..BQ.\n");

        chess.boardSet("17 W\n.k.b.\n.p.Rr\n....n\nN.PqB\nP...P\n....K\n");
        chess.move("e4-c6");
        assertEquals(chess.boardGet(), "17 B\n.k.b.\n.p.Rr\n....n\nN.Pq.\nP...P\n..B.K\n");

        chess.boardSet("19 B\n.k..r\n.p...\np.n.p\nbqPpP\nPQBKN\n.....\n");
        chess.move("b1-a1");
        assertEquals(chess.boardGet(), "20 W\nk...r\n.p...\np.n.p\nbqPpP\nPQBKN\n.....\n");

        chess.boardSet("17 B\nk....\nq....\n.bP.r\np.B.p\nP....\nRN..K\n");
        chess.move("e3-e1");
        assertEquals(chess.boardGet(), "18 W\nk...r\nq....\n.bP..\np.B.p\nP....\nRN..K\n");

        chess.boardSet("12 B\nk..nr\np..p.\n.q.pP\n..pB.\nP..p.\nR.b.K\n");
        chess.move("b3-b1");
        assertEquals(chess.boardGet(), "13 W\nkq.nr\np..p.\n...pP\n..pB.\nP..p.\nR.b.K\n");

        chess.boardSet("13 B\nk..nr\n....p\n..pp.\nbQ...\nP..PP\n...BK\n");
        chess.move("a1-b2");
        assertEquals(chess.boardGet(), "14 W\n...nr\n.k..p\n..pp.\nbQ...\nP..PP\n...BK\n");

        chess.boardSet("16 W\nk.b.r\n....q\n..pP.\nBP.Qn\n...P.\nRq..K\n");
        chess.move("e6-e5");
        assertEquals(chess.boardGet(), "16 B\nk.b.r\n....q\n..pP.\nBP.Qn\n...PK\nRq...\n");

        chess.boardSet("14 B\nkb...\n.pp.r\np....\nP...N\nB..P.\nR.Q.K\n");
        chess.move("b1-a2");
        assertEquals(chess.boardGet(), "15 W\nk....\nbpp.r\np....\nP...N\nB..P.\nR.Q.K\n");

        chess.boardSet("12 W\nkq...\n..r.p\nbPn..\npNPpP\nP..P.\n.RBQK\n");
        chess.move("b6-a6");
        assertEquals(chess.boardGet(), "12 B\nkq...\n..r.p\nbPn..\npNPpP\nP..P.\nR.BQK\n");

        chess.boardSet("20 W\nk.q..\n..pBp\nPQ.r.\n...b.\nP.R.P\n...K.\n");
        chess.move("b3-b1");
        assertEquals(chess.boardGet(), "20 B\nkQq..\n..pBp\nP..r.\n...b.\nP.R.P\n...K.\n");

        chess.boardSet("19 B\n.....\nqkpB.\n.p.pr\npP.P.\nPnP..\nR...K\n");
        chess.move("b2-a1");
        assertEquals(chess.boardGet(), "20 W\nk....\nq.pB.\n.p.pr\npP.P.\nPnP..\nR...K\n");

        chess.boardSet("12 B\nk.br.\nn.ppp\nP....\n.....\n..PKP\nR..q.\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "13 W\n.kbr.\nn.ppp\nP....\n.....\n..PKP\nR..q.\n");

        chess.boardSet("18 W\n...kr\np.b.p\nq....\nP.pP.\n.QpN.\nR.BK.\n");
        chess.move("b5-b6");
        assertEquals(chess.boardGet(), "18 B\n...kr\np.b.p\nq....\nP.pP.\n..pN.\nRQBK.\n");

        chess.boardSet("18 W\n...n.\nkrq.b\nP..Pp\nP..QP\n..P.B\n..R.K\n");
        chess.move("a3-b2");
        assertEquals(chess.boardGet(), "18 B\n...n.\nkPq.b\n...Pp\nP..QP\n..P.B\n..R.K\n");

        chess.boardSet("16 B\nqk.nr\n.p..p\n.Ppp.\nN....\nR.PPP\n..Q.K\n");
        chess.move("a1-a3");
        assertEquals(chess.boardGet(), "17 W\n.k.nr\n.p..p\nqPpp.\nN....\nR.PPP\n..Q.K\n");

        chess.boardSet("19 B\n...qr\nB....\n.kQ.b\n.....\nPp..P\nR..K.\n");
        chess.move("d1-c2");
        assertEquals(chess.boardGet(), "20 W\n....r\nB.q..\n.kQ.b\n.....\nPp..P\nR..K.\n");

        chess.boardSet("14 W\n..bnr\n.k.pp\np.pQ.\nP....\n.PPN.\nR.BK.\n");
        chess.move("c6-b6");
        assertEquals(chess.boardGet(), "14 B\n..bnr\n.k.pp\np.pQ.\nP....\n.PPN.\nRB.K.\n");

        chess.boardSet("17 W\n...r.\nkb.pp\np.p..\nQPnBq\nP..P.\n.R..K\n");
        chess.move("d5-e4");
        assertEquals(chess.boardGet(), "17 B\n...r.\nkb.pp\np.p..\nQPnBP\nP....\n.R..K\n");

        chess.boardSet("18 B\n..r..\npbn.p\nQkPK.\n..P..\nP..P.\nRB...\n");
        chess.move("c2-e3");
        assertEquals(chess.boardGet(), "19 W\n..r..\npb..p\nQkPKn\n..P..\nP..P.\nRB...\n");

        chess.boardSet("16 B\nk..r.\n..P..\nppN.p\n....B\nPqP.P\nR...K\n");
        chess.move("a1-b2");
        assertEquals(chess.boardGet(), "17 W\n...r.\n.kP..\nppN.p\n....B\nPqP.P\nR...K\n");

        chess.boardSet("15 B\nkqb..\np.p.K\n.pPn.\n..B.P\nPP...\nRN..r\n");
        chess.move("c1-e3");
        assertEquals(chess.boardGet(), "16 W\nkq...\np.p.K\n.pPnb\n..B.P\nPP...\nRN..r\n");

        chess.boardSet("13 B\nq.b.r\n.k.pp\np.P.n\nP..KP\nRP...\n.NB..\n");
        chess.move("b2-b1");
        assertEquals(chess.boardGet(), "14 W\nqkb.r\n...pp\np.P.n\nP..KP\nRP...\n.NB..\n");

        chess.boardSet("13 W\nk.b.r\n.qppp\np.nP.\n...KP\npPP.B\nRNQ..\n");
        chess.move("c6-e6");
        assertEquals(chess.boardGet(), "13 B\nk.b.r\n.qppp\np.nP.\n...KP\npPP.B\nRN..Q\n");

        chess.boardSet("14 W\n..knr\n.pp..\nq..Qp\nP.NP.\nR.P.K\n...B.\n");
        chess.move("d6-c6");
        assertEquals(chess.boardGet(), "14 B\n..knr\n.pp..\nq..Qp\nP.NP.\nR.P.K\n..B..\n");

        chess.boardSet("13 B\n.Qq.r\np..pp\n.k..P\np.PQ.\nPP..K\n.RB..\n");
        chess.move("c1-a3");
        assertEquals(chess.boardGet(), "14 W\n.Q..r\np..pp\nqk..P\np.PQ.\nPP..K\n.RB..\n");

        chess.boardSet("13 W\n.q.br\n.kp.p\n.pPp.\npP.PP\nn.Q..\nRN.BK\n");
        chess.move("b6-d5");
        assertEquals(chess.boardGet(), "13 B\n.q.br\n.kp.p\n.pPp.\npP.PP\nn.QN.\nR..BK\n");

        chess.boardSet("13 W\nkn...\n..p.r\n....p\n..Pp.\nP..PP\n.qB.K\n");
        chess.move("e5-d4");
        assertEquals(chess.boardGet(), "13 B\nkn...\n..p.r\n....p\n..PP.\nP..P.\n.qB.K\n");

        chess.boardSet("20 B\n...r.\n.Bk..\n....n\np.P..\n..P..\n..Q.K\n");
        chess.move("d1-a1");
        assertEquals(chess.boardGet(), "21 W\nr....\n.Bk..\n....n\np.P..\n..P..\n..Q.K\n");

        chess.boardSet("21 W\n.....\nkP...\nnQ..r\nN.PKb\nP..P.\n.RB..\n");
        chess.move("d4-e4");
        assertEquals(chess.boardGet(), "21 B\n.....\nkP...\nnQ..r\nN.P.K\nP..P.\n.RB..\n");

        chess.boardSet("18 W\nk....\n.q...\nP..P.\nP.n..\n.....\nRNB.K\n");
        chess.move("d3-d2");
        assertEquals(chess.boardGet(), "18 B\nk....\n.q.P.\nP....\nP.n..\n.....\nRNB.K\n");

        chess.boardSet("19 B\n.k..r\n..p.p\n.pnPq\nN..P.\nP.B..\nR..QK\n");
        chess.move("e3-d3");
        assertEquals(chess.boardGet(), "20 W\n.k..r\n..p.p\n.pnq.\nN..P.\nP.B..\nR..QK\n");

        chess.boardSet("18 B\nkN..r\np...p\n..ppP\nq....\n..PPQ\n.RbK.\n");
        chess.move("a1-b1");
        assertEquals(chess.boardGet(), "19 W\n.k..r\np...p\n..ppP\nq....\n..PPQ\n.RbK.\n");

        chess.boardSet("12 B\nk.q.r\nbp..p\np.np.\nPPPPP\nR....\n....K\n");
        chess.move("b2-b3");
        assertEquals(chess.boardGet(), "13 W\nk.q.r\nb...p\nppnp.\nPPPPP\nR....\n....K\n");

        chess.boardSet("12 B\nkq..r\n.pb.p\nR.ppP\n.....\n.PBPQ\n.N.K.\n");
        chess.move("d3-d4");
        assertEquals(chess.boardGet(), "13 W\nkq..r\n.pb.p\nR.p.P\n...p.\n.PBPQ\n.N.K.\n");

        chess.boardSet("11 B\nk.r..\n.qppp\np.P.P\nnP.P.\n.PQ.K\nR.B..\n");
        chess.move("b2-c3");
        assertEquals(chess.boardGet(), "12 W\nk.r..\n..ppp\np.q.P\nnP.P.\n.PQ.K\nR.B..\n");

        chess.boardSet("18 W\nk..b.\n..p.r\np.p.p\nN.Q.P\nP.BP.\nR..K.\n");
        chess.move("a6-c6");
        assertEquals(chess.boardGet(), "18 B\nk..b.\n..p.r\np.p.p\nN.Q.P\nP.BP.\n..RK.\n");

        chess.boardSet("16 W\nk.b..\n.Q.p.\n..p..\n..P..\nPp...\n.RK.r\n");
        chess.move("c6-b5");
        assertEquals(chess.boardGet(), "16 B\nk.b..\n.Q.p.\n..p..\n..P..\nPK...\n.R..r\n");

        chess.boardSet("11 B\nk..r.\npppNp\nP.P.b\n.....\nRP.KP\n..B.Q\n");
        chess.move("b2-b3");
        assertEquals(chess.boardGet(), "12 W\nk..r.\np.pNp\nPpP.b\n.....\nRP.KP\n..B.Q\n");

        chess.boardSet("13 W\n.q.br\nk...p\nRQ.pn\n.PpPP\n..P..\n.NBK.\n");
        chess.move("d6-d5");
        assertEquals(chess.boardGet(), "13 B\n.q.br\nk...p\nRQ.pn\n.PpPP\n..PK.\n.NB..\n");

        chess.boardSet("20 W\nk..nr\np...P\n..B..\nN..p.\nRP.K.\n.....\n");
        chess.move("a4-b2");
        assertEquals(chess.boardGet(), "20 B\nk..nr\npN..P\n..B..\n...p.\nRP.K.\n.....\n");

        chess.boardSet("20 W\nk..r.\n..p.B\n....b\nPp..P\n.Q.pK\nRnq..\n");
        chess.move("e2-e1");
        assertEquals(chess.boardGet(), "20 B\nk..rB\n..p..\n....b\nPp..P\n.Q.pK\nRnq..\n");

        chess.boardSet("13 W\nk...q\npbp.p\n...rP\n...n.\nP...B\nRN..K\n");
        chess.move("b6-a4");
        assertEquals(chess.boardGet(), "13 B\nk...q\npbp.p\n...rP\nN..n.\nP...B\nR...K\n");

        chess.boardSet("12 B\nkb.q.\n.pPp.\np.P..\nNP...\n..P.Q\nR..BK\n");
        chess.move("d1-e1");
        assertEquals(chess.boardGet(), "13 W\nkb..q\n.pPp.\np.P..\nNP...\n..P.Q\nR..BK\n");

        chess.boardSet("19 B\n...N.\nbk.p.\n.....\n.R..r\n....P\n....K\n");
        chess.move("e4-c4");
        assertEquals(chess.boardGet(), "20 W\n...N.\nbk.p.\n.....\n.Rr..\n....P\n....K\n");

        chess.boardSet("11 B\nk....\nppqbp\nP.p.P\n.RN..\n..Q.K\n..B..\n");
        chess.move("c2-c1");
        assertEquals(chess.boardGet(), "12 W\nk.q..\npp.bp\nP.p.P\n.RN..\n..Q.K\n..B..\n");

        chess.boardSet("18 B\n...nr\nkp..p\npq..K\n..P..\nP.Q..\n....R\n");
        chess.move("b3-b4");
        assertEquals(chess.boardGet(), "19 W\n...nr\nkp..p\np...K\n.qP..\nP.Q..\n....R\n");

        chess.boardSet("15 B\n..b..\n.qkp.\nppp..\n..P..\nPPR.Q\n..B.K\n");
        chess.move("b2-b1");
        assertEquals(chess.boardGet(), "16 W\n.qb..\n..kp.\nppp..\n..P..\nPPR.Q\n..B.K\n");

        chess.boardSet("17 W\nkb.n.\n.Q...\n.Pp..\n..P.p\n..R.P\n.q..K\n");
        chess.move("b2-c1");
        assertEquals(chess.boardGet(), "17 B\nkbQn.\n.....\n.Pp..\n..P.p\n..R.P\n.q..K\n");

        chess.boardSet("19 W\n.k.nr\n..bp.\npPpq.\nP....\n..K..\nNR.B.\n");
        chess.move("b6-b5");
        assertEquals(chess.boardGet(), "19 B\n.k.nr\n..bp.\npPpq.\nP....\n.RK..\nN..B.\n");

        chess.boardSet("19 B\nk.qrB\n.p...\n.N.pn\nP..PP\n.bP.K\n.R.Q.\n");
        chess.move("c1-d2");
        assertEquals(chess.boardGet(), "20 W\nk..rB\n.p.q.\n.N.pn\nP..PP\n.bP.K\n.R.Q.\n");

        chess.boardSet("18 B\n.k.r.\n.bn.Q\n.p.P.\n.PBP.\nP....\nR...K\n");
        chess.move("c2-a1");
        assertEquals(chess.boardGet(), "19 W\nnk.r.\n.b..Q\n.p.P.\n.PBP.\nP....\nR...K\n");

        chess.boardSet("13 W\nk.bnr\nq....\nNp.pp\nPP.P.\n..PBP\nR..QK\n");
        chess.move("a4-b3");
        assertEquals(chess.boardGet(), "13 B\nk.bnr\nq....\nNP.pp\n.P.P.\n..PBP\nR..QK\n");

        chess.boardSet("13 B\nq...r\nkpp.p\n...b.\nPPp.P\nR.PP.\n.Q.K.\n");
        chess.move("c2-c3");
        assertEquals(chess.boardGet(), "14 W\nq...r\nkp..p\n..pb.\nPPp.P\nR.PP.\n.Q.K.\n");

        chess.boardSet("11 B\nk.bNr\n...p.\npp...\n..PP.\nPP...\nR.BKQ\n");
        chess.move("e1-e4");
        assertEquals(chess.boardGet(), "12 W\nk.bN.\n...p.\npp...\n..PPr\nPP...\nR.BKQ\n");

        chess.boardSet("13 W\nk.bnr\n.p.pp\nQPN..\n..PqP\nP....\nR.BK.\n");
        chess.move("c3-d1");
        assertEquals(chess.boardGet(), "13 B\nk.bNr\n.p.pp\nQP...\n..PqP\nP....\nR.BK.\n");

        chess.boardSet("21 W\nk.b..\np...p\nN..q.\nPP.KP\n..R..\n.B...\n");
        chess.move("d4-c4");
        assertEquals(chess.boardGet(), "21 B\nk.b..\np...p\nN..q.\nPPK.P\n..R..\n.B...\n");

        chess.boardSet("14 W\nk.r..\npQp.b\n.pPpp\nNB.Rq\nPP.KP\n.....\n");
        chess.move("b4-a3");
        assertEquals(chess.boardGet(), "14 B\nk.r..\npQp.b\nBpPpp\nN..Rq\nPP.KP\n.....\n");

        chess.boardSet("18 B\nqb..r\n.kpp.\np.P..\npP.pK\n..QP.\n.N...\n");
        chess.move("e1-e4");
        assertEquals(chess.boardGet(), "19 W\nqb...\n.kpp.\np.P..\npP.pr\n..QP.\n.N...\n");

        chess.boardSet("13 B\nqk..r\npb..p\nQ.ppB\nP.PPP\nRP...\n....K\n");
        chess.move("d3-e4");
        assertEquals(chess.boardGet(), "14 W\nqk..r\npb..p\nQ.p.B\nP.PPp\nRP...\n....K\n");

        chess.boardSet("15 W\nk.q..\np.N.r\n.p..P\nnP.b.\nP.Q.P\nR.B.K\n");
        chess.move("c5-c3");
        assertEquals(chess.boardGet(), "15 B\nk.q..\np.N.r\n.pQ.P\nnP.b.\nP...P\nR.B.K\n");

        chess.boardSet("11 B\nk.q.r\n...b.\npp.Qn\n.P..B\n....P\nRN..K\n");
        chess.move("a1-b2");
        assertEquals(chess.boardGet(), "12 W\n..q.r\n.k.b.\npp.Qn\n.P..B\n....P\nRN..K\n");

        chess.boardSet("19 B\n.....\nknQ..\n.q..b\nP.P..\n.rB..\n.R..K\n");
        chess.move("b5-b6");
        assertEquals(chess.boardGet(), "20 W\n.....\nknQ..\n.q..b\nP.P..\n..B..\n.r..K\n");

        chess.boardSet("11 B\n.q.r.\n.k..p\np.p.P\nPPpQb\n..P.P\nR...K\n");
        chess.move("b2-c2");
        assertEquals(chess.boardGet(), "12 W\n.q.r.\n..k.p\np.p.P\nPPpQb\n..P.P\nR...K\n");

        chess.boardSet("17 B\n..kbr\n...pp\np.pP.\n.N..P\nP.B.K\nR....\n");
        chess.move("d1-a4");
        assertEquals(chess.boardGet(), "18 W\n..k.r\n...pp\np.pP.\nbN..P\nP.B.K\nR....\n");
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