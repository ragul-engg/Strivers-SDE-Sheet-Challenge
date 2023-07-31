package dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public static int maxProfit(int i, int w, List<Integer> values, List<Integer> weights, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int val = Integer.MIN_VALUE;
        if (weights.get(i) <= w) {
            val = values.get(i) + maxProfit(i - 1, w - weights.get(i), values, weights, dp);
        }
        return dp[i][w] = Math.max(val, maxProfit(i - 1, w, values, weights, dp));
    }

    public static int maxProfitMemoization(List<Integer> values, List<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w + 1];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));
        return maxProfit(n - 1, w, values, weights, dp);
    }

    public static int maxProfitTabulation(List<Integer> values, List<Integer> weights, int n, int w) {
        int[][] dp = new int[n][w + 1];
        for (int i = weights.get(0); i <= w; i++) {
            dp[0][i] = values.get(0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w; j++) {
                int take = Integer.MIN_VALUE;
                if (weights.get(i) <= j) {
                    take = values.get(i) + dp[i - 1][j - weights.get(i)];
                }
                dp[i][j] = Math.max(dp[i - 1][j], take);
            }
        }
        return dp[n - 1][w];
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 4, 5);
        List<Integer> weights = Arrays.asList(5, 4, 8, 6);
        System.out.println(maxProfitMemoization(values, weights, values.size(), 5));
        System.out.println(maxProfitTabulation(values, weights, values.size(), 5));
    }

}
