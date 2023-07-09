import java.util.ArrayList;

public class RatInAMaze {
    static int[] delRow = { 1, 0, 0, -1 };
    static int[] delCol = { 0, -1, 1, 0 };
    static char[] move = { 'D', 'L', 'R', 'U' };

    public static boolean isSafe(int row, int col, int n, int[][] maze, boolean[][] visited) {
        return row >= 0 && row < n && col >= 0 && col < n && !visited[row][col] && maze[row][col] == 1;
    }

    public static void findPath(int row, int col, int n, int[][] maze, boolean[][] visited, String path,
            ArrayList<String> result) {
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];
            if (isSafe(nRow, nCol, n, maze, visited)) {
                visited[nRow][nCol] = true;
                findPath(nRow, nCol, n, maze, visited, path + move[i], result);
                visited[nRow][nCol] = false;
            }
        }
    }

    public static ArrayList<String> findPath(int[][] maze, int n) {
        ArrayList<String> result = new ArrayList<>();
        if (maze[0][0] == 0) {
            result.add("-1");
            return result;
        }
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        findPath(0, 0, n, maze, visited, "", result);
        return result;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        ArrayList<String> result = findPath(maze, maze.length);
        for (String path : result) {
            System.out.println(path);
        }
    }
}
