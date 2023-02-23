/**
 * EECS 2011 Z, Winter 2023.
 * Assignment 2, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 */
package A2;
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

        // TODO: Complete this method
        return null; // Placeholder return statement. Should be changed when the method is implemented..
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

        // TODO: Complete this method
        return null; // Placeholder return statement. Should be changed when the method is implemented..
    }

    public static void main(String[] args) {

        System.out.println(threePegTOH(3));
        System.out.println(fourPegTOH(3));
    }
}
