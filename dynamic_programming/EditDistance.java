package dynamic_programming;

import java.util.Arrays;

public class EditDistance {
    public static int computeDistance(int i, int j, String X, String Y, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (X.charAt(i) == Y.charAt(j)) {
            return dp[i][j] = computeDistance(i - 1, j - 1, X, Y, dp);
        }
        return dp[i][j] = Math.min(1 + computeDistance(i - 1, j, X, Y, dp),
                Math.min(1 + computeDistance(i, j - 1, X, Y, dp),
                        1 + computeDistance(i - 1, j - 1, X, Y, dp)));
    }

    public static int editDistanceMemoization(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        Arrays.stream(dp).forEach(e -> Arrays.fill(e, -1));
        return computeDistance(n - 1, m - 1, str1, str2, dp);
    }

    public static int editDistanceTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String A = "abc";
        String B = "dc";
        System.out.println(editDistanceMemoization(A, B));
        System.out.println(editDistanceTabulation(A, B));
    }
}