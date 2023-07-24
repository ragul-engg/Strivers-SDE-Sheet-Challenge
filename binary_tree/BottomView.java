package binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeMap;

import utils.TreeNode;
import utils.TreeNodeLevelPair;

public class BottomView {
    public static ArrayList<Integer> bottomView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNodeLevelPair> queue = new ArrayDeque<>();
        queue.add(new TreeNodeLevelPair(root, 0));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeLevelPair p = queue.poll();
                map.put(p.level, p.node.data);
                if (p.node.left != null) {
                    queue.add(new TreeNodeLevelPair(p.node.left, p.level - 1));
                }
                if (p.node.right != null) {
                    queue.add(new TreeNodeLevelPair(p.node.right, p.level + 1));
                }
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(bottomView(root));
    }
}
