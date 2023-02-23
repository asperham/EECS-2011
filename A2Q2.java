package A2;

/**
 * EECS 2011 Z, Winter 2023.
 * Assignment 2, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 * Colin Le Donne
 */
// Do NOT change the package!

import java.util.ArrayList;
// Do NOT add any import!
/**
 * The A2Q2 class
 */
public class A2Q2 {

    /**
     * A class representing a single move in the TOH solution,
     * i.e., moving the disk at the top of fromPeg to the top of toPeg
     * Note: a move is invalid if it results in a larger disk being above a smaller disk.
     *
     * DO NOT MODIFY THIS CLASS.
     */
    public static class Move {

        private final int fromPeg;
        private final int toPeg;

        public Move(int from, int to) {
            this.fromPeg = from;
            this.toPeg = to;
        }

        public String toString() {
            return String.format("%d to %d", this.fromPeg, this.toPeg);
        }
        public int getFromPeg() { return this.fromPeg; };
        public int getToPeg() { return this.toPeg; };
    }

    /**
     * Return the sequence of moves that solves the 3-peg TOH problem with n disks.
     * Assumptions:
     * - The pegs are numbered 1, 2, 3
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> threePegTOH(int n) {
        ArrayList<Move> moves = new ArrayList<>();
        ThreeTOHHelper(n,1,2,3, moves ); // pegs are 1 2 and 3
        return moves;

    }
    // recursive method
    public static void ThreeTOHHelper (int n, int from, int to, int extra, ArrayList<Move> moves){
        if (n == 1){
            moves.add(new Move(from, to));
        }
        else{
            ThreeTOHHelper(n - 1,from, extra, to, moves);
            moves.add(new Move(from,to)); // add a new move
            ThreeTOHHelper(n-1, extra, to , from, moves);
        }
    }

    /**
     * Return the sequence of moves that solves the 4-peg TOH problem with n disks,
     * with the strategy described in the assignment handout
     * Assumptions:
     * - The pegs are numbered 1, 2, 3, 4
     * - The origin peg is 1.
     * - The destination peg is 2.
     * - n > 0
     */
    public static ArrayList<Move> fourPegTOH(int n) {
        ArrayList<Move> moves = new ArrayList<>();
        FourTOHHelper(n,1,2,3, 4 ,moves );
        return moves;

    }
    public static void FourTOHHelper (int n, int from, int to, int extra1, int extra2, ArrayList<Move> moves){
        int k = 1;
        if(n == 1){
            moves.add(new Move(from,to));
        }
        else{
            FourTOHHelper(n-k, from, extra2, to, extra1, moves);
            FourTOHHelper(k, from, to, extra1, extra2, moves);
            FourTOHHelper(n-k, extra2, to, from, extra1, moves);

        }

    }
    public static void main(String[] args) {
        System.out.println(threePegTOH(3).size());
        System.out.println(threePegTOH(5).size());
        System.out.println(fourPegTOH(3).size());
        System.out.println(fourPegTOH(5).size());
    }
}
