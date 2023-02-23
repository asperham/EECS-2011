/**
 * EECS 2011 Z, Winter 2023.
 * Assignment 2, Question 2 tester code.
 *
 * This tester is for self-testing only.
 * Feel free to modify and add test cases.
 * Do NOT include this file in your assignment submission.
 */

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import A2.A2Q2;
import A2.A2Q2.Move;

class InvalidMoveException extends Exception {
    public InvalidMoveException(String errorMessage) {
        super(errorMessage);
    }
}

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class A2Tester {

    private static String errMsg(int nPegs, int nDisks) {
        return "Test input: nPegs=" + nPegs + ", nDisks=" + nDisks;
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    static boolean checkMovesThreePeg(int nPegs, int nDisks, ArrayList<Move> moves) throws InvalidMoveException {

        ArrayList<Integer>[] pegs = new ArrayList[nPegs+1]; // pegs[0] is never used
        for (int i = 1; i <= nPegs; i++) {
            pegs[i] = new ArrayList<>();
        }
        for (int disk = nDisks; disk >= 1; disk--) {
            pegs[1].add(disk);
        }
        for (Move move : moves) {
            makeMove(move, pegs);
        }
        return checkResult(pegs, nDisks);
    }
    static void makeMove(Move move, ArrayList<Integer>[] pegs) throws InvalidMoveException {
        int from = move.getFromPeg();
        int to = move.getToPeg();
        if (pegs[from].isEmpty()) {
            throw new InvalidMoveException("Moving from an empty peg");
        }
        int disk = pegs[from].remove(pegs[from].size()-1);
        if (!pegs[to].isEmpty() && disk >= pegs[to].get(pegs[to].size()-1)) {
            throw new InvalidMoveException("Moving onto a smaller disk");
        }
        pegs[to].add(disk);
    }
    static boolean checkResult(ArrayList<Integer>[] pegs, int nDisks) {

        if (pegs[2].size() != nDisks) {
            return false;
        }
        for (int i = 0; i < pegs[2].size(); i++) {
            if (pegs[2].get(i) != nDisks - i) {
                return false;
            }
        }
        return true;
    }
    static ArrayList<Move> runTOH(int nPegs, int nDisks) {
        if (nPegs == 3) {
            return A2Q2.threePegTOH(nDisks);
        }
        return A2Q2.fourPegTOH(nDisks);
    }

    @Test
    public void test_example_01() {

        int nPegs = 3;
        int nDisks = 3;
        try {
            ArrayList<Move> moves = runTOH(nPegs, nDisks);
            assertTrue(errMsg(nPegs, nDisks), checkMovesThreePeg(nPegs, nDisks, moves));
        }
        catch (InvalidMoveException ex) {
            fail(errMsg(nPegs, nDisks) + ". " + ex);
        }
    }


    @Test
    public void test_example_02() {

        int nPegs = 4;
        int nDisks = 3;
        try {
            ArrayList<Move> moves = runTOH(nPegs, nDisks);
            assertTrue(errMsg(nPegs, nDisks), checkMovesThreePeg(nPegs, nDisks, moves));
        }
        catch (InvalidMoveException ex) {
            fail(errMsg(nPegs, nDisks) + ". " + ex);
        }
    }
}
