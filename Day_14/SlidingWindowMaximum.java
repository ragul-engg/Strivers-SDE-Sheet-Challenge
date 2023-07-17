import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) {
        int n = nums.size();
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() == i - k) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums.get(queue.peekLast()) < nums.get(i)) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result.add(nums.get(queue.peek()));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(4, 2, 1, 4, 4));
        int k = 2;
        System.out.println(getMaximumOfSubarrays(arr, k));
    }
}
