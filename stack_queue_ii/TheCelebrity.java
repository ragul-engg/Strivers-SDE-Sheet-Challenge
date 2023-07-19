package stack_queue_ii;

import java.util.*;

public class TheCelebrity {
    static int[][] matrix = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

    public static int findCelebrity() {
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int cand = stack.pop();
        for (int i = 0; i < n; i++) {
            if (cand != i && (!knows(i, cand) || knows(cand, i))) {
                return -1;
            }
        }
        return cand;
    }

    public static boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }

    public static void main(String[] args) {
        System.out.println(findCelebrity());
    }
}
