/**
 * EECS 2011 Z, Winter 2023
 * Assignment 1, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 * Colin Le Donne
 * 215037955
 * Feb/3/23
 */
package A1;
// Do NOT modify the package declaration

import java.util.ArrayList;
import java.util.Stack;
// Do NOT add any import

// You may implement a new class here, such as a Stack or a Queue.
// Any additional class that you use must be included in THIS file.

public class A1Q2 {

    /**
     * The function that you need to implement.
     * Read the assignment handout for the specification.
     *
     * DO NOT MODIFY the declaration of the function (its parameter types and return type).
     *
     * Consider the game of “Sorting Hockey Pucks” as depicted in the following diagrams (Figure 1 and 2). Initially, a
     * sequence of N hockey pucks are placed at the START area. The pucks are numbered 1, 2, 3, . . . , N but are arbitrarily
     * ordered. The goal of the player is to move the pucks out of the EXIT on the left side in the exact order of 1, 2, 3,
     * . . . , N . However, it might not be possible to move out all N pucks in that exact order. We will write a program to
     * determine K, the largest number of the pucks that can be moved out in the exact order of 1, 2, . . . , K.
     */
    public static int solve(int[] arr) {

        Stack<Integer> buffer = new Stack<Integer>();
        Stack<Integer> start = new Stack<Integer>();
        Stack<Integer> end = new Stack<Integer>();
        int max =  0;
        int counter = 1;


        for(int i = arr.length - 1; i >= 0; i --){
            start.push(arr[i]);
        }

        while (!start.isEmpty()){
            if (start.peek() != counter){
               buffer.push(start.peek());

               start.pop();

            }
            else if (start.peek() == counter){
                counter ++;
                max ++;
                end.push(start.peek());
                start.pop();

                while(!buffer.isEmpty() && !end.empty() && buffer.peek() == end.peek() + 1){
                    end.push(buffer.peek());
                    buffer.pop();
                    counter++;
                    max ++;
                }
            }

        }
        return max;
    }

    /**
     * This main function contains a few test cases that can be used to check
     * that your code compiles and runs. Note that these test cases are NOT complete,
     * and you need to test your code thoroughly with more cases.
     */
    public static void main(String[] args) {

        // Printing "true" means the return value is correct.

        int[] arr = {4, 5, 2, 1, 3};
        System.out.println(3 == solve(arr));

        arr = new int[] {5, 4, 3, 1, 2};
        System.out.println(5 == solve(arr));

        arr = new int[] {1};
        System.out.println(1 == solve(arr));

        arr = new int[] {2, 3, 1};
        System.out.println(1 == solve(arr));

        arr = new int[] {7, 1, 5, 4, 3, 2, 8, 10, 9, 6};
        System.out.println(6 == solve(arr));
    }
}