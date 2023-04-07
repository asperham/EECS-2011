/**
 * EECS 2011 Z, Winter 2023
 * Assignment 4, Question 2 starter code.
 * Please read carefully the instructions in the assignment handout
 * and the starter code.
 *
 * Colin Le Donne
 * 215037955
 */
package A4;
// Do NOT modify the package declaration
// Do NOT add any import

// You may implement add any additional classes you want.
// For example, a Queue class, a Stack class, or a Node class.

public class A4Q2 {

    //Node class
    static class Node {
        int floor;
        int steps;

        Node(int floor, int steps) {
            this.floor = floor;
            this.steps = steps;
        }
    }
    //Linked List Class with basic functions
    static class LinkedList {
        Node node;
        LinkedList next;

        LinkedList(Node node) {
            this.node = node;
            this.next = null;
        }
    }
    //Queue class with basic functions
    static class Queue {
       LinkedList front;
       LinkedList rear;

        Queue() {
            this.front = null;
            this.rear = null;
        }

        boolean isEmpty() {
            return front == null;
        }

        void enqueue(Node node) {
            LinkedList newNode = new LinkedList(node);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        Node dequeue() {
            if (isEmpty()) {
                return null;
            }
            Node temp = front.node;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return temp;
        }
    }


    //Using BFS approach (Breadth-First Search)
    public static int minimumButtonPushes(int N, int U, int D, int X, int Y) {

        //Keeping track of floors we have been to
        boolean[] visited = new boolean[N + 1];
        Queue queue = new Queue();
        queue.enqueue(new Node(X, 0));
        visited[X] = true;


        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            int floor = current.floor;
            int steps = current.steps;

            //If current floor = y we are done
            if (floor == Y) {
                return steps;
            }
            //Formulas
            int up = floor + U;
            int down = floor - D;
            int jump = 2 * floor;


            //Determining which button to press
            if (up <= N && !visited[up]) {
                queue.enqueue(new Node(up, steps + 1));
                visited[up] = true;
            }

            if (down >= 1 && !visited[down]) {
                queue.enqueue(new Node(down, steps + 1));
                visited[down] = true;
            }

            if (jump <= N && !visited[jump]) {
                queue.enqueue(new Node(jump, steps + 1));
                visited[jump] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        // Below are a few test cases.
        // Printing "true" means the return value is correct.
        // Each call to minimumButtonPushes() must take less than 1 second.

        System.out.println(3 == minimumButtonPushes(10, 2, 1, 1, 10));
        System.out.println(5 == minimumButtonPushes(100, 3, 7, 20, 11));
        System.out.println(90 == minimumButtonPushes(1000, 20, 11, 987, 21));
        System.out.println(19 == minimumButtonPushes(1000000, 2011, 3101, 12, 777777));
        System.out.println(-1 == minimumButtonPushes(20, 21, 3, 1, 19));
    }
}
