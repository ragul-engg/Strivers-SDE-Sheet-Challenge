package dynamic_programming;

public class LongestCommonSubsequence {
	static int lcsmemoize(int i, int j, String x, String y, int[][] dp) {
		if (i < 0 || j < 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (x.charAt(i) == y.charAt(j)) {
			return dp[i][j] = 1 + lcsmemoize(i - 1, j - 1, x, y, dp);
		}
		return dp[i][j] = Math.max(lcsmemoize(i - 1, j, x, y, dp), lcsmemoize(i, j - 1, x, y, dp));
	}

	static int solve(String x, String y) {
		int n = x.length();
		int m = y.length();
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j] = -1;
			}
		}
		return lcsmemoize(n - 1, m - 1, x, y, dp);
		// return lcstabluation(n,m,x,y);
	}

	public static void main(String[] args) {
		String x = "adebc";
		String y = "dcadb";
		System.out.println(solve(x, y));
	}
}
