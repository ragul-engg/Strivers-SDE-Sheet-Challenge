package stack_queue_ii;

import java.util.*;

public class NextSmallerElement {

    public static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        Deque<Integer> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(-1);
        }
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || arr.get(stack.peekLast()) < arr.get(i)) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && arr.get(stack.peekLast()) > arr.get(i)) {
                    result.set(stack.pollLast(), arr.get(i));
                }
                stack.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(2, 1, 4, 3));
        ArrayList<Integer> result = nextSmallerElement(arr, arr.size());
        System.out.println(result);
    }
}
