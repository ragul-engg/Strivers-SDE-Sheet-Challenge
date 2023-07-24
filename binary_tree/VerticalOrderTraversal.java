package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeMap;

import utils.TreeNode;
import utils.TreeNodeLevelPair;

public class VerticalOrderTraversal {
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Deque<TreeNodeLevelPair> queue = new ArrayDeque<>();
        queue.add(new TreeNodeLevelPair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeLevelPair p = queue.poll();
                ArrayList<Integer> currLine = map.getOrDefault(p.level, new ArrayList<>());
                currLine.add(p.node.data);
                map.put(p.level, currLine);
                if (p.node.left != null) {
                    queue.add(new TreeNodeLevelPair(p.node.left, p.level - 1));
                }
                if (p.node.right != null) {
                    queue.add(new TreeNodeLevelPair(p.node.right, p.level + 1));
                }
            }
        }

        for (ArrayList<Integer> nodes : map.values()) {
            result.addAll(nodes);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(verticalOrderTraversal(root));
    }
}
