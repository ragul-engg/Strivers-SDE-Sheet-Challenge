import java.util.Deque;
import java.util.LinkedList;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottingOranges {

    public static int minTimeToRot(int[][] grid, int n, int m) {
        int maxTime = 0;
        int freshCnt = 0;
        int[][] visited = new int[n][m];
        Deque<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else if (grid[i][j] == 1) {
                    freshCnt++;
                }
            }
        }
        int[] delx = { 0, 1, 0, -1 };
        int[] dely = { 1, 0, -1, 0 };
        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            queue.remove();
            maxTime = Math.max(maxTime, time);
            for (int i = 0; i < 4; i++) {
                int newR = row + delx[i];
                int newC = col + dely[i];
                if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1
                        && visited[newR][newC] != 2) {
                    visited[newR][newC] = 2;
                    queue.add(new Pair(newR, newC, time + 1));
                    freshCnt--;
                }
            }
        }
        return freshCnt == 0 ? maxTime : -1;
    }

    public static void main(String[] args) {
        int R = 3, C = 3;
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.out.println(minTimeToRot(grid, R, C));
    }
}