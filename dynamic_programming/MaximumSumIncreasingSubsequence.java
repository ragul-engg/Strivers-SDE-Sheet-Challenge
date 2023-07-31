package dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class MaximumSumIncreasingSubsequence {
    private static int msis(int idx, int prev_idx, int n, List<Integer> arr, int[][] dp) {
        if (idx == n) {
            return 0;
        }
        if (dp[idx][prev_idx + 1] != -1) {
            return dp[idx][prev_idx + 1];
        }
        int val = msis(idx + 1, prev_idx, n, arr, dp);
        if (prev_idx == -1 || arr.get(idx) > arr.get(prev_idx)) {
            val = Math.max(val, arr.get(idx) + msis(idx + 1, idx, n, arr, dp));
        }
        return dp[idx][prev_idx + 1] = val;
    }

    public static int maxIncreasingDumbbellsSum(List<Integer> rack, int n) {
        int[][] dp = new int[n][n + 1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return msis(0, -1, n, rack, dp);
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(9, 1, 2, 8);
        System.out.println(maxIncreasingDumbbellsSum(arr, arr.size()));
    }
}
