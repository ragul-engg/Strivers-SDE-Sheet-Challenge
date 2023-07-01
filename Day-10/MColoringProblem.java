import java.util.*;

public class MColoringProblem {
    @SuppressWarnings("unchecked")
    public static String graphColoring(int[][] mat, int m) {
        int V = mat.length;
        List<Integer>[] G = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            G[i] = new ArrayList<>();
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (mat[i][j] == 1) {
                    G[i].add(j);
                }
            }
        }
        int[] color = new int[V];
        if (solve(0, G, color, V, m) == true) {
            return "YES";
        }
        return "NO";
    }

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for (int it : G[node]) {
            if (color[it] == col) {
                return false;
            }
        }
        return true;
    }

    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if (node == n) {
            return true;
        }

        for (int i = 1; i <= m; i++) {
            if (isSafe(node, G, color, n, i)) {
                color[node] = i;
                if (solve(node + 1, G, color, n, m) == true) {
                    return true;
                }
                color[node] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 } };
        System.out.println(graphColoring(mat, 1));
    }

}
