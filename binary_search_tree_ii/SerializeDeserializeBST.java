package binary_search_tree_ii;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import utils.TreeNode;

public class SerializeDeserializeBST {
    public static String serializeTree(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if (root == null) {
            return res.toString();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("$ ");
                continue;
            }
            res.append(String.format("%d ", node.data));
            queue.add(node.left);
            queue.add(node.right);
        }
        return res.toString();
    }

    public static TreeNode deserializeTree(String str) {
        if (str.length() == 0) {
            return null;
        }
        String[] nodes = str.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        int i = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (nodes[i].equals("$")) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.left);
            }
            i++;
            if (nodes[i].equals("$")) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, 3, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(serializeTree(root));
    }
}
