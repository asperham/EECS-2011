/**
 * EECS 2011 Z, Winter 2023
 * Assignment 3, Question 2 starter code.
 * Colin Le Donne 215037955
 *
 */
package A3;
// Do NOT modify the package declaration
// Do NOT add any import
/**
 * Your own implementation of a HashTable class.
 * Add the appropriate fields and methods you want in order to solve this problem.
 */

//Hashtable class that uses separate chaining for collision
class HashTable {

    private HashEntry[] table;
    private int size;
    //Creating a new hashtable of size n
    HashTable(int size) {
        this.size = size;
        table = new HashEntry[size];
    }
    //hashing class
    private int hash(int key) {
        return (key % size + size) % size;
    }
    //putting class
    void put(int key, int value) {
        int index = hash(key);
        HashEntry entry = table[index];

        if (entry == null) {
            table[index] = new HashEntry(key, value);
            return;
        }
        while (entry.next != null && entry.key != key) {
            entry = entry.next;
        }

        if (entry.key == key) {
            entry.value = value;
        } else {
            entry.next = new HashEntry(key, value);
        }
    }
    //get class
    int get(int key) {
        int index = hash(key);
        HashEntry entry = table[index];
        while (entry != null && entry.key != key) {
            entry = entry.next;
        }

        if (entry == null) {
            return 0;
        } else {
            return entry.value;
        }
      }
        //function to find the solution. If I put in the public class it will run into problems with static classes.
        //putting it here avoids these issues
        long countSolutions ( int A, int B, int C, int D, int E, int S){
            long count = 0;
            //n^2
            for (int x1 = -50; x1 <= 50; x1++) {
                for (int x2 = -50; x2 <= 50; x2++) {
                    int partialSum = A * x1 + B * (x2 * x2);
                    put(partialSum, get(partialSum) + 1);
                }
            }
            //n^3
            for (int x3 = -50; x3 <= 50; x3++) {
                for (int x4 = -50; x4 <= 50; x4++) {
                    for (int x5 = -50; x5 <= 50; x5++) {
                        int partialSum = -(C * (x3 * x3 * x3) + D * (x4 * x4 * x4 * x4) + E * (x5 * x5 * x5 * x5 * x5));
                        count += get(partialSum + S);
                    }
                }
            }
            return count;
        }
    }

    //Helper to initialize Hashes
class HashEntry {
    int key;
    int value;
    HashEntry next;

    HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
public class A3Q2 {

    /**
     * Return the number of unique integer solutions where each integer is in the range [-50, 50].
     * The equation is given in the handout.
     * Precondition: A, B, C, D, E, S are integers in the range [-5000, 5000]
     * Note that the return value of this function is a long integer, not just an int.
     * <p>
     * Do NOT modify the signature of this function.
     */

    static long solve(int A, int B, int C, int D, int E, int S) {
        HashTable hashTable = new HashTable(26000);

        return hashTable.countSolutions(A, B, C, D, E, S);
    }

    public static void main(String[] args) {

        // Below are a few test cases.
        // Printing "true" means the return value is correct.
        // Each call to solve() must take less than 5 seconds.

        System.out.println(340 == solve(12, 34, 56, 78, 9, 10));
        System.out.println(16665 == solve(20, -11, -2, 0, 11, -2011));
        System.out.println(10510100501L == solve(0, 0, 0, 0, 0, 0));

        }
}
