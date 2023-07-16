import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr, int n) {
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || arr[stack.peekLast()] > arr[i]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peekLast()] < arr[i]) {
                    result[stack.pollLast()] = arr[i];
                }
                stack.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 3 };
        int[] nge = nextGreater(arr, arr.length);
        System.out.println(Arrays.toString(nge));
    }

}
