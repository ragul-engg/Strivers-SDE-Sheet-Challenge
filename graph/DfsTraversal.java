package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DfsTraversal {
    public static void dfs(int i, int v, boolean[] visited, List<List<Integer>> adj, ArrayList<Integer> subgraph) {
        visited[i] = true;
        subgraph.add(i);
        for (int neigh : adj.get(i)) {
            if (!visited[neigh]) {
                dfs(neigh, v, visited, adj, subgraph);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                ArrayList<Integer> subgraph = new ArrayList<>();
                dfs(i, v, visited, adj, subgraph);
                result.add(subgraph);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 4;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2)));
        edges.add(new ArrayList<>(Arrays.asList(3, 4)));
        System.out.println(depthFirstSearch(v, e, edges));
    }
}
