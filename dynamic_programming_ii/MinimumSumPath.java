package dynamic_programming_ii;

public class MinimumSumPath {
    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < m; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 4 }, { 7, 5, 9 } };
        System.out.println(minSumPath(grid));
    }
}
