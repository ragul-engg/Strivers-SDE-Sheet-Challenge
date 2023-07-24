package stack_queue_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static int largestRectangle(ArrayList<Integer> heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.size();
        int result = -1;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || heights.get(stack.peek()) < heights.get(i)) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights.get(stack.peek()) > heights.get(i)) {
                    int currHeight = heights.get(stack.pop());
                    int width = stack.size() > 0 ? i - stack.peek() - 1 : i;
                    int area = currHeight * width;
                    result = Math.max(result, area);
                }
                stack.push(i);
            }
        }
        int i = n;
        while (!stack.isEmpty()) {
            int currHeight = heights.get(stack.pop());
            int width = stack.size() > 0 ? i - stack.peek() - 1 : i;
            int area = currHeight * width;
            result = Math.max(result, area);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(largestRectangle(heights));
    }
}
