package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSortDFS {
    public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Deque<Integer> stack) {
        visited[i] = true;
        for (int neigh : adj.get(i)) {
            if (!visited[neigh]) {
                dfs(neigh, adj, visited, stack);
            }
        }
        stack.add(i);
    }

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
        }
        Deque<Integer> stack = new LinkedList<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pollLast());
        }
        return result;
    }

    public static void main(String[] args) {
        int v = 3;
        int e = 2;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0, 2)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1)));
        System.out.println(topologicalSort(edges, v, e));
    }
}