package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class BfsTraversal {
    public static ArrayList<Integer> breadthFirstSearch(int vertex, int edges[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int v = 0; v < vertex; v++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges[0].length; i++) {
            int u = edges[0][i];
            int v = edges[1][i];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int i = 0; i < vertex; i++) {
            Collections.sort(adj.get(i));
        }
        boolean[] visited = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (!visited[i]) {
                Deque<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    result.add(node);
                    for (int v : adj.get(node)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.add(v);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int v = 4;
        int[][] edges = { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 3 } };
        System.out.println(breadthFirstSearch(v, edges));
    }

}
