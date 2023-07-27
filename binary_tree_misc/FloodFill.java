package binary_tree_misc;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        int m = image.length;
        int n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        int oldColor = image[x][y];
        int[] del = new int[] { 0, 1, 0, -1 };
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;
        image[x][y] = newColor;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newx = p[0] + del[i];
                int newy = p[1] + del[3 - i];
                if (newx >= 0 && newx < m && newy >= 0 && newy < n && !visited[newx][newy]
                        && image[newx][newy] == oldColor) {
                    image[newx][newy] = newColor;
                    visited[newx][newy] = true;
                    queue.add(new int[] { newx, newy });
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = { { 1, 1, 7, 5 }, { 1, 3, 3, 3 }, { 6, 5, 5, 3 }, { 2, 2, 3, 3 } };
        System.out.println(Arrays.deepToString(floodFill(image, 1, 2, 8)));
    }
}
