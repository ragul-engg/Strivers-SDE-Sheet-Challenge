package arrays_iv;

import java.util.*;

public class LongestConsecutiveSequence {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        Set<Integer> hash = new HashSet<>();
        for (int val : arr) {
            hash.add(val);
        }
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            int currVal = arr[i];
            if (!hash.contains(currVal - 1)) {
                while (hash.contains(currVal + 1)) {
                    currVal++;
                }
                maxLen = Math.max(maxLen, currVal - arr[i] + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 5, 4, 9, 10, 10, 6 };
        System.out.println(lengthOfLongestConsecutiveSequence(arr, 7));
    }
}