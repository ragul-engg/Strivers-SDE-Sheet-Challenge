import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithKSum {
    static int maxLen(int arr[], int n) {
        Map<Integer, Integer> hash = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLen = Math.max(i + 1, maxLen);
            } else {
                if (hash.containsKey(sum)) {
                    maxLen = Math.max(maxLen, i - hash.get(sum));
                } else {
                    hash.put(sum, i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println("The longest subarray with 0 sum is " + maxLen(arr, arr.length));
    }
}