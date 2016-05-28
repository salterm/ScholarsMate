/*
  CS 442 - Advanced AI: Combinatorial Games
  Michael Salter
*/

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import static org.junit.Assert.*;

public class chessEngineTest {
    @Test
    public void boardGetSet() throws Exception {
        ChessEngine.reset();
        assertEquals(ChessEngine.boardGet(), "1 W\nkqbnr\nppppp\n.....\n.....\nPPPPP\nRNBQK\n");

        ChessEngine.boardSet("12 B\n.Qbq.\np.p.r\np.B.p\n..p..\nP..PP\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "12 B\n.Qbq.\np.p.r\np.B.p\n..p..\nP..PP\nR...K\n");

        ChessEngine.boardSet("16 W\nkqr..\np.p..\nB.bPP\n..Q..\nPP.KP\nR....\n");
        assertEquals(ChessEngine.boardGet(), "16 W\nkqr..\np.p..\nB.bPP\n..Q..\nPP.KP\nR....\n");

        ChessEngine.boardSet("17 B\nQ.r..\np....\n....b\n.p..p\nPPB.P\n.R.qK\n");
        assertEquals(ChessEngine.boardGet(), "17 B\nQ.r..\np....\n....b\n.p..p\nPPB.P\n.R.qK\n");

        ChessEngine.boardSet("9 B\nQ...r\npqp..\nbpP.p\nB...P\nP.PP.\nRN..K\n");
        assertEquals(ChessEngine.boardGet(), "9 B\nQ...r\npqp..\nbpP.p\nB...P\nP.PP.\nRN..K\n");

        ChessEngine.boardSet("13 W\nkq...\np..p.\n...p.\nP.n..\nR.b..\n.B..r\n");
        assertEquals(ChessEngine.boardGet(), "13 W\nkq...\np..p.\n...p.\nP.n..\nR.b..\n.B..r\n");

        ChessEngine.boardSet("14 B\nQ..n.\np..P.\n...rB\nP.q.b\n.P..P\n..RqK\n");
        assertEquals(ChessEngine.boardGet(), "14 B\nQ..n.\np..P.\n...rB\nP.q.b\n.P..P\n..RqK\n");

        ChessEngine.boardSet("12 W\nk.Bnr\n...p.\np.p.p\nP.P..\n....P\nRN..q\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nk.Bnr\n...p.\np.p.p\nP.P..\n....P\nRN..q\n");

        ChessEngine.boardSet("13 B\nk..nr\np..p.\n....p\nb.pP.\nP...K\nRQ...\n");
        assertEquals(ChessEngine.boardGet(), "13 B\nk..nr\np..p.\n....p\nb.pP.\nP...K\nRQ...\n");

        ChessEngine.boardSet("15 W\nk....\n.QpB.\n.pn.r\n..pPp\nP...P\nRNQ.K\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nk....\n.QpB.\n.pn.r\n..pPp\nP...P\nRNQ.K\n");

        ChessEngine.boardSet("12 W\nk..r.\npqnbp\n..P..\nB.PpP\nP..P.\nRQ..K\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nk..r.\npqnbp\n..P..\nB.PpP\nP..P.\nRQ..K\n");

        ChessEngine.boardSet("13 B\n.b.n.\nk..p.\npBp.r\nP.P.p\n.R.PP\n..N.K\n");
        assertEquals(ChessEngine.boardGet(), "13 B\n.b.n.\nk..p.\npBp.r\nP.P.p\n.R.PP\n..N.K\n");

        ChessEngine.boardSet("20 W\n...nr\n...b.\nk.p.p\nB.PqP\n...P.\n.Q..K\n");
        assertEquals(ChessEngine.boardGet(), "20 W\n...nr\n...b.\nk.p.p\nB.PqP\n...P.\n.Q..K\n");

        ChessEngine.boardSet("10 W\nk...r\n.b.pp\np..Pn\nP...P\n..P.N\nRB.Qq\n");
        assertEquals(ChessEngine.boardGet(), "10 W\nk...r\n.b.pp\np..Pn\nP...P\n..P.N\nRB.Qq\n");

        ChessEngine.boardSet("17 B\n.q...\nnQpb.\np...p\nP.r.p\n.PK.N\nR.B..\n");
        assertEquals(ChessEngine.boardGet(), "17 B\n.q...\nnQpb.\np...p\nP.r.p\n.PK.N\nR.B..\n");

        ChessEngine.boardSet("15 W\nkqbnr\n..p..\npp...\nP.P.p\n.P.pK\n.RBQ.\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nkqbnr\n..p..\npp...\nP.P.p\n.P.pK\n.RBQ.\n");

        ChessEngine.boardSet("11 W\nk..br\npN.pp\n..p..\nP....\n....q\nnRBQ.\n");
        assertEquals(ChessEngine.boardGet(), "11 W\nk..br\npN.pp\n..p..\nP....\n....q\nnRBQ.\n");

        ChessEngine.boardSet("12 W\nkqbn.\np..r.\nRB.P.\n....p\n..PP.\n.N.QK\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nkqbn.\np..r.\nRB.P.\n....p\n..PP.\n.N.QK\n");

        ChessEngine.boardSet("19 B\nk..qr\n..PPp\n.....\n.p.p.\nP...K\n.RB..\n");
        assertEquals(ChessEngine.boardGet(), "19 B\nk..qr\n..PPp\n.....\n.p.p.\nP...K\n.RB..\n");

        ChessEngine.boardSet("15 W\nk.r..\np..p.\nBN...\nPPbpn\nR.P.P\n.....\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nk.r..\np..p.\nBN...\nPPbpn\nR.P.P\n.....\n");

        ChessEngine.boardSet("18 B\nk..N.\nr....\np..pK\nPpP..\nR.P.Q\n..B..\n");
        assertEquals(ChessEngine.boardGet(), "18 B\nk..N.\nr....\np..pK\nPpP..\nR.P.Q\n..B..\n");

        ChessEngine.boardSet("15 W\nk....\npN..p\nb.r.p\n.pPQp\n.PB..\nR....\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nk....\npN..p\nb.r.p\n.pPQp\n.PB..\nR....\n");

        ChessEngine.boardSet("12 W\nkqbr.\n.p...\npp.pp\nN.BP.\n..P.P\nR.Q.K\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nkqbr.\n.p...\npp.pp\nN.BP.\n..P.P\nR.Q.K\n");

        ChessEngine.boardSet("5 B\n.q.nr\n.Nbpp\np.p..\n.....\nPPPPP\n.RBQK\n");
        assertEquals(ChessEngine.boardGet(), "5 B\n.q.nr\n.Nbpp\np.p..\n.....\nPPPPP\n.RBQK\n");

        ChessEngine.boardSet("12 B\nk..br\npp..p\n....P\nPpNp.\nR.BQP\n....K\n");
        assertEquals(ChessEngine.boardGet(), "12 B\nk..br\npp..p\n....P\nPpNp.\nR.BQP\n....K\n");

        ChessEngine.boardSet("6 B\nQqbnr\np.pp.\n....p\np...P\nPPPP.\nR.B.K\n");
        assertEquals(ChessEngine.boardGet(), "6 B\nQqbnr\np.pp.\n....p\np...P\nPPPP.\nR.B.K\n");

        ChessEngine.boardSet("14 W\n.q..r\n..p.p\nRpnp.\n.kPP.\n...BP\n.N..K\n");
        assertEquals(ChessEngine.boardGet(), "14 W\n.q..r\n..p.p\nRpnp.\n.kPP.\n...BP\n.N..K\n");

        ChessEngine.boardSet("15 W\nkr...\np.p..\n.qP.p\n.NPB.\nP...P\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nkr...\np.p..\n.qP.p\n.NPB.\nP...P\nR...K\n");

        ChessEngine.boardSet("15 W\n...r.\n..pQ.\npk..p\n.B...\n.P.pP\nR..n.\n");
        assertEquals(ChessEngine.boardGet(), "15 W\n...r.\n..pQ.\npk..p\n.B...\n.P.pP\nR..n.\n");

        ChessEngine.boardSet("14 B\n.qb.r\n.p...\npPP.p\nPQ..P\n...n.\nRB..K\n");
        assertEquals(ChessEngine.boardGet(), "14 B\n.qb.r\n.p...\npPP.p\nPQ..P\n...n.\nRB..K\n");

        ChessEngine.boardSet("20 B\nk..nK\np..b.\nr.qP.\nPPPp.\n.....\nRBQ..\n");
        assertEquals(ChessEngine.boardGet(), "20 B\nk..nK\np..b.\nr.qP.\nPPPp.\n.....\nRBQ..\n");

        ChessEngine.boardSet("19 W\nk.r..\n...qp\n.p.KP\npbQ.P\n.PP..\nR.BN.\n");
        assertEquals(ChessEngine.boardGet(), "19 W\nk.r..\n...qp\n.p.KP\npbQ.P\n.PP..\nR.BN.\n");

        ChessEngine.boardSet("12 W\nkq.br\n.pp.p\npP..P\nR..p.\nn.PPK\n.NBQ.\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nkq.br\n.pp.p\npP..P\nR..p.\nn.PPK\n.NBQ.\n");

        ChessEngine.boardSet("17 W\n..kN.\n.p.p.\npP...\nB.Ppb\nP...K\nR....\n");
        assertEquals(ChessEngine.boardGet(), "17 W\n..kN.\n.p.p.\npP...\nB.Ppb\nP...K\nR....\n");

        ChessEngine.boardSet("14 W\nk...r\nqp.pp\n..p.n\n.PP.b\nP.BPP\nR.K..\n");
        assertEquals(ChessEngine.boardGet(), "14 W\nk...r\nqp.pp\n..p.n\n.PP.b\nP.BPP\nR.K..\n");

        ChessEngine.boardSet("13 W\n...nr\n.k...\npppqp\n....P\nPp.PK\nR.B.Q\n");
        assertEquals(ChessEngine.boardGet(), "13 W\n...nr\n.k...\npppqp\n....P\nPp.PK\nR.B.Q\n");

        ChessEngine.boardSet("14 W\nk..r.\np....\np.p.p\nq.P.P\n.R.P.\n.NBnK\n");
        assertEquals(ChessEngine.boardGet(), "14 W\nk..r.\np....\np.p.p\nq.P.P\n.R.P.\n.NBnK\n");

        ChessEngine.boardSet("4 B\nQqbnr\n..ppp\n.p...\n..P..\nPP.PP\nRNB.K\n");
        assertEquals(ChessEngine.boardGet(), "4 B\nQqbnr\n..ppp\n.p...\n..P..\nPP.PP\nRNB.K\n");

        ChessEngine.boardSet("12 W\nk..b.\n.nQ.r\np.N..\nPp...\nRPP.P\n....K\n");
        assertEquals(ChessEngine.boardGet(), "12 W\nk..b.\n.nQ.r\np.N..\nPp...\nRPP.P\n....K\n");

        ChessEngine.boardSet("17 B\n...qr\np...p\n..kb.\n..pP.\nP..PP\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "17 B\n...qr\np...p\n..kb.\n..pP.\nP..PP\nR...K\n");

        ChessEngine.boardSet("16 W\nk...Q\n.Ppp.\nB...r\n..p..\nR...p\n.N..K\n");
        assertEquals(ChessEngine.boardGet(), "16 W\nk...Q\n.Ppp.\nB...r\n..p..\nR...p\n.N..K\n");

        ChessEngine.boardSet("14 W\n...nr\nqk..p\np....\nNQ...\nPPPbP\nR.KB.\n");
        assertEquals(ChessEngine.boardGet(), "14 W\n...nr\nqk..p\np....\nNQ...\nPPPbP\nR.KB.\n");

        ChessEngine.boardSet("19 B\n.r...\npk.Pq\n.pP.n\n.....\nPP...\n..R.K\n");
        assertEquals(ChessEngine.boardGet(), "19 B\n.r...\npk.Pq\n.pP.n\n.....\nPP...\n..R.K\n");

        ChessEngine.boardSet("9 W\nkq.nr\n...bp\n.p.p.\n...PB\nP...Q\nRN.q.\n");
        assertEquals(ChessEngine.boardGet(), "9 W\nkq.nr\n...bp\n.p.p.\n...PB\nP...Q\nRN.q.\n");

        ChessEngine.boardSet("13 B\nk..qr\np...p\nP.pPn\nR....\n.pP.P\n....K\n");
        assertEquals(ChessEngine.boardGet(), "13 B\nk..qr\np...p\nP.pPn\nR....\n.pP.P\n....K\n");

        ChessEngine.boardSet("14 B\nkN.nr\n.....\n.p..p\np..KP\np.PP.\nR.B..\n");
        assertEquals(ChessEngine.boardGet(), "14 B\nkN.nr\n.....\n.p..p\np..KP\np.PP.\nR.B..\n");

        ChessEngine.boardSet("19 W\nqk..r\n.n.p.\nP..Pp\n...b.\n..PK.\nRNB.Q\n");
        assertEquals(ChessEngine.boardGet(), "19 W\nqk..r\n.n.p.\nP..Pp\n...b.\n..PK.\nRNB.Q\n");

        ChessEngine.boardSet("6 W\nk.br.\npp.pp\n..p.n\n...qP\nPPPP.\nRNBQ.\n");
        assertEquals(ChessEngine.boardGet(), "6 W\nk.br.\npp.pp\n..p.n\n...qP\nPPPP.\nRNBQ.\n");

        ChessEngine.boardSet("16 B\nk....\np...r\n..R.n\n.pbP.\n.BQ.P\n.N..K\n");
        assertEquals(ChessEngine.boardGet(), "16 B\nk....\np...r\n..R.n\n.pbP.\n.BQ.P\n.N..K\n");

        ChessEngine.boardSet("18 W\nq....\n.kp..\np..b.\n..KPr\nPP.Q.\nR..N.\n");
        assertEquals(ChessEngine.boardGet(), "18 W\nq....\n.kp..\np..b.\n..KPr\nPP.Q.\nR..N.\n");

        ChessEngine.boardSet("14 W\n.k.Nr\n.....\n...Bp\n.Rp..\nP.bP.\nQ..qK\n");
        assertEquals(ChessEngine.boardGet(), "14 W\n.k.Nr\n.....\n...Bp\n.Rp..\nP.bP.\nQ..qK\n");

        ChessEngine.boardSet("16 B\n...b.\n...p.\npqPp.\npQ...\nR..Nr\n....K\n");
        assertEquals(ChessEngine.boardGet(), "16 B\n...b.\n...p.\npqPp.\npQ...\nR..Nr\n....K\n");

        ChessEngine.boardSet("15 W\nkb.nr\n....p\npp.P.\n.q..P\nP.P.Q\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nkb.nr\n....p\npp.P.\n.q..P\nP.P.Q\nR...K\n");

        ChessEngine.boardSet("15 W\nk....\npq..r\nP.n.p\n.pp..\n.PPKP\n.R..Q\n");
        assertEquals(ChessEngine.boardGet(), "15 W\nk....\npq..r\nP.n.p\n.pp..\n.PPKP\n.R..Q\n");

        ChessEngine.boardSet("17 B\nq...r\np..bp\n..kpP\np.P..\n...QP\nRNB.K\n");
        assertEquals(ChessEngine.boardGet(), "17 B\nq...r\np..bp\n..kpP\np.P..\n...QP\nRNB.K\n");

        ChessEngine.boardSet("13 B\n.qbr.\n..ppp\n.p...\n.pPPP\nRn.BK\n.N..Q\n");
        assertEquals(ChessEngine.boardGet(), "13 B\n.qbr.\n..ppp\n.p...\n.pPPP\nRn.BK\n.N..Q\n");

        ChessEngine.boardSet("19 B\n..q.r\npPQ.p\n...pP\nP..P.\nR..b.\n...nK\n");
        assertEquals(ChessEngine.boardGet(), "19 B\n..q.r\npPQ.p\n...pP\nP..P.\nR..b.\n...nK\n");

        ChessEngine.boardSet("17 W\nk...r\np..b.\n.q.p.\n..p.P\nPpQ..\nRB...\n");
        assertEquals(ChessEngine.boardGet(), "17 W\nk...r\np..b.\n.q.p.\n..p.P\nPpQ..\nRB...\n");

        ChessEngine.boardSet("21 W\n.Qk..\npnp..\np..p.\n.....\n....P\n....K\n");
        assertEquals(ChessEngine.boardGet(), "21 W\n.Qk..\npnp..\np..p.\n.....\n....P\n....K\n");

        ChessEngine.boardSet("14 W\n..knr\np...p\nPp..N\n.Bpp.\n.P.QP\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "14 W\n..knr\np...p\nPp..N\n.Bpp.\n.P.QP\nR...K\n");

        ChessEngine.boardSet("19 B\n.q.nr\nk.Q..\np.p.p\nP....\n..P.P\n.B..K\n");
        assertEquals(ChessEngine.boardGet(), "19 B\n.q.nr\nk.Q..\np.p.p\nP....\n..P.P\n.B..K\n");

        ChessEngine.boardSet("20 B\n.kr..\n..p.p\n.p...\nPpp.b\nR.PQK\n.....\n");
        assertEquals(ChessEngine.boardGet(), "20 B\n.kr..\n..p.p\n.p...\nPpp.b\nR.PQK\n.....\n");

        ChessEngine.boardSet("11 B\nQ..br\n.qp.p\n..Pp.\np..P.\nRB..P\n.N..K\n");
        assertEquals(ChessEngine.boardGet(), "11 B\nQ..br\n.qp.p\n..Pp.\np..P.\nRB..P\n.N..K\n");

        ChessEngine.boardSet("7 B\nQbqnr\np.p.p\n...p.\nP.p.P\n.PPP.\nRB.K.\n");
        assertEquals(ChessEngine.boardGet(), "7 B\nQbqnr\np.p.p\n...p.\nP.p.P\n.PPP.\nRB.K.\n");

        ChessEngine.boardSet("20 B\n..r..\n..k..\nB...K\nNP...\n....P\n....R\n");
        assertEquals(ChessEngine.boardGet(), "20 B\n..r..\n..k..\nB...K\nNP...\n....P\n....R\n");

        ChessEngine.boardSet("16 W\n.kq..\np.p.r\nPbn..\nN..pP\n..qP.\n...K.\n");
        assertEquals(ChessEngine.boardGet(), "16 W\n.kq..\np.p.r\nPbn..\nN..pP\n..qP.\n...K.\n");

        ChessEngine.boardSet("13 B\nk.r..\npp...\n.b..p\nRPPpq\n...PQ\n.NB.K\n");
        assertEquals(ChessEngine.boardGet(), "13 B\nk.r..\npp...\n.b..p\nRPPpq\n...PQ\n.NB.K\n");

        ChessEngine.boardSet("19 W\nk...r\npp..p\n....n\n.q..P\nP.KbB\n....R\n");
        assertEquals(ChessEngine.boardGet(), "19 W\nk...r\npp..p\n....n\n.q..P\nP.KbB\n....R\n");

        ChessEngine.boardSet("17 W\n...nb\nkp...\np...r\nN.P.K\np....\nRB...\n");
        assertEquals(ChessEngine.boardGet(), "17 W\n...nb\nkp...\np...r\nN.P.K\np....\nRB...\n");

        ChessEngine.boardSet("15 B\nkqb.r\n....p\n..Pp.\np...P\n..PNK\nR...B\n");
        assertEquals(ChessEngine.boardGet(), "15 B\nkqb.r\n....p\n..Pp.\np...P\n..PNK\nR...B\n");

        ChessEngine.boardSet("17 W\n.kqnr\nQp...\np...p\nPp.PP\n.BP..\n..R.K\n");
        assertEquals(ChessEngine.boardGet(), "17 W\n.kqnr\nQp...\np...p\nPp.PP\n.BP..\n..R.K\n");

        ChessEngine.boardSet("11 W\nkq.nr\n.p...\n.bppp\nP.PPP\n..p.Q\nRNB..\n");
        assertEquals(ChessEngine.boardGet(), "11 W\nkq.nr\n.p...\n.bppp\nP.PPP\n..p.Q\nRNB..\n");

        ChessEngine.boardSet("21 W\n.k...\n.p..Q\n...BP\n.q...\n....n\nqN..K\n");
        assertEquals(ChessEngine.boardGet(), "21 W\n.k...\n.p..Q\n...BP\n.q...\n....n\nqN..K\n");

        ChessEngine.boardSet("13 W\nk....\n.pb.r\n....p\np...N\nPQPPP\n.RBQK\n");
        assertEquals(ChessEngine.boardGet(), "13 W\nk....\n.pb.r\n....p\np...N\nPQPPP\n.RBQK\n");

        ChessEngine.boardSet("7 W\nkq.nr\np..bp\n.p...\n.Pp.P\nP.PP.\nRNBQ.\n");
        assertEquals(ChessEngine.boardGet(), "7 W\nkq.nr\np..bp\n.p...\n.Pp.P\nP.PP.\nRNBQ.\n");

        ChessEngine.boardSet("20 W\n..k..\np....\nPp.br\nRQP..\n..P.P\n...K.\n");
        assertEquals(ChessEngine.boardGet(), "20 W\n..k..\np....\nPp.br\nRQP..\n..P.P\n...K.\n");

        ChessEngine.boardSet("12 B\nq..r.\nk.bpp\np....\n.PNP.\nP.P..\nRBQK.\n");
        assertEquals(ChessEngine.boardGet(), "12 B\nq..r.\nk.bpp\np....\n.PNP.\nP.P..\nRBQK.\n");

        ChessEngine.boardSet("19 B\n..r..\np.pqp\n.Pk.b\n...P.\n.PQKB\nR....\n");
        assertEquals(ChessEngine.boardGet(), "19 B\n..r..\np.pqp\n.Pk.b\n...P.\n.PQKB\nR....\n");

        ChessEngine.boardSet("19 B\n..r..\nkq.Pp\nPp.b.\n.PB..\n.RPK.\nQ....\n");
        assertEquals(ChessEngine.boardGet(), "19 B\n..r..\nkq.Pp\nPp.b.\n.PB..\n.RPK.\nQ....\n");

        ChessEngine.boardSet("16 W\nkq.r.\n.p.bp\np.QpP\nPPB.n\n..P..\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "16 W\nkq.r.\n.p.bp\np.QpP\nPPB.n\n..P..\nR...K\n");

        ChessEngine.boardSet("11 B\n.b..r\nP.qpp\np.P..\nB.nP.\nP.N.P\nR..QK\n");
        assertEquals(ChessEngine.boardGet(), "11 B\n.b..r\nP.qpp\np.P..\nB.nP.\nP.N.P\nR..QK\n");

        ChessEngine.boardSet("21 W\n....r\n..Qpp\n.P..q\n.....\npR..P\n...kK\n");
        assertEquals(ChessEngine.boardGet(), "21 W\n....r\n..Qpp\n.P..q\n.....\npR..P\n...kK\n");

        ChessEngine.boardSet("13 B\n..b..\npkq..\n.p...\n.P.pN\n.BPP.\n..RQK\n");
        assertEquals(ChessEngine.boardGet(), "13 B\n..b..\npkq..\n.p...\n.P.pN\n.BPP.\n..RQK\n");

        ChessEngine.boardSet("17 W\nkb...\npr...\nPp.p.\n..PPK\n...Q.\nRB...\n");
        assertEquals(ChessEngine.boardGet(), "17 W\nkb...\npr...\nPp.p.\n..PPK\n...Q.\nRB...\n");

        ChessEngine.boardSet("13 B\n.kb.Q\n.qp.r\np...p\nPPK..\nRB..P\n.....\n");
        assertEquals(ChessEngine.boardGet(), "13 B\n.kb.Q\n.qp.r\np...p\nPPK..\nRB..P\n.....\n");

        ChessEngine.boardSet("7 B\nq.bnr\nQp.p.\n...pp\np....\nPPP.P\nRNB.K\n");
        assertEquals(ChessEngine.boardGet(), "7 B\nq.bnr\nQp.p.\n...pp\np....\nPPP.P\nRNB.K\n");

        ChessEngine.boardSet("21 W\nr....\nq.p.p\n...b.\nN.QPB\nk...P\nnR.K.\n");
        assertEquals(ChessEngine.boardGet(), "21 W\nr....\nq.p.p\n...b.\nN.QPB\nk...P\nnR.K.\n");

        ChessEngine.boardSet("19 W\nk.B.r\np....\n....p\nbQp.P\n.nqP.\nR..K.\n");
        assertEquals(ChessEngine.boardGet(), "19 W\nk.B.r\np....\n....p\nbQp.P\n.nqP.\nR..K.\n");

        ChessEngine.boardSet("15 B\n.nb.r\n..p..\npQ..p\np.k.q\nPPPK.\nR.B..\n");
        assertEquals(ChessEngine.boardGet(), "15 B\n.nb.r\n..p..\npQ..p\np.k.q\nPPPK.\nR.B..\n");

        ChessEngine.boardSet("14 W\n..bnr\nP...p\nk.p..\nQBPp.\nP..P.\n..Rq.\n");
        assertEquals(ChessEngine.boardGet(), "14 W\n..bnr\nP...p\nk.p..\nQBPp.\nP..P.\n..Rq.\n");

        ChessEngine.boardSet("15 B\n..q.r\nk.p..\nN..pp\nPp.pn\nRP..K\n...Q.\n");
        assertEquals(ChessEngine.boardGet(), "15 B\n..q.r\nk.p..\nN..pp\nPp.pn\nRP..K\n...Q.\n");

        ChessEngine.boardSet("14 W\nk..br\nq.p.p\nB.p..\nN.P..\n.P.PP\nR.K..\n");
        assertEquals(ChessEngine.boardGet(), "14 W\nk..br\nq.p.p\nB.p..\nN.P..\n.P.PP\nR.K..\n");

        ChessEngine.boardSet("11 B\nk..nr\n.BbNp\np....\n.Pq.P\nP..P.\nR..QK\n");
        assertEquals(ChessEngine.boardGet(), "11 B\nk..nr\n.BbNp\np....\n.Pq.P\nP..P.\nR..QK\n");

        ChessEngine.boardSet("12 B\nkq..r\n.pp.p\np..pb\nPPKP.\nR.Q.P\n.N..n\n");
        assertEquals(ChessEngine.boardGet(), "12 B\nkq..r\n.pp.p\np..pb\nPPKP.\nR.Q.P\n.N..n\n");

        ChessEngine.boardSet("5 W\nk.bnr\npp.p.\n..p.p\nNP...\nP.PP.\nRB.Qq\n");
        assertEquals(ChessEngine.boardGet(), "5 W\nk.bnr\npp.p.\n..p.p\nNP...\nP.PP.\nRB.Qq\n");

        ChessEngine.boardSet("14 W\nqkb.r\n.p..p\nppn.N\n....P\nP.PPp\nR.Q..\n");
        assertEquals(ChessEngine.boardGet(), "14 W\nqkb.r\n.p..p\nppn.N\n....P\nP.PPp\nR.Q..\n");

        ChessEngine.boardSet("13 B\n...N.\npP.br\n..pP.\n...R.\n.PBpP\n...QK\n");
        assertEquals(ChessEngine.boardGet(), "13 B\n...N.\npP.br\n..pP.\n...R.\n.PBpP\n...QK\n");

        ChessEngine.boardSet("10 B\n.q.nr\n.Pp.p\n.p.p.\nN..B.\nPPbPP\nR...K\n");
        assertEquals(ChessEngine.boardGet(), "10 B\n.q.nr\n.Pp.p\n.p.p.\nN..B.\nPPbPP\nR...K\n");

        ChessEngine.boardSet("15 B\n.k..r\nQ.b.P\np.nP.\n....P\nP..N.\nR..K.\n");
        assertEquals(ChessEngine.boardGet(), "15 B\n.k..r\nQ.b.P\np.nP.\n....P\nP..N.\nR..K.\n");

        ChessEngine.boardSet("14 W\nk.b.r\nppq.p\n..p.n\n....P\nPPBQ.\nRN...\n");
        assertEquals(ChessEngine.boardGet(), "14 W\nk.b.r\nppq.p\n..p.n\n....P\nPPBQ.\nRN...\n");
    }
}