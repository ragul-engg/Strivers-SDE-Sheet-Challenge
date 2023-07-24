package binary_tree;

import java.util.*;

import utils.TreeNode;
import utils.TreeNodeLevelPair;

public class TopView {

    public static ArrayList<Integer> getTopView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Deque<TreeNodeLevelPair> queue = new LinkedList<>();
        queue.add(new TreeNodeLevelPair(root, 0));
        while (!queue.isEmpty()) {
            TreeNodeLevelPair p = queue.poll();
            if (!map.containsKey(p.level)) {
                map.put(p.level, p.node.data);
            }
            if (p.node.left != null) {
                queue.add(new TreeNodeLevelPair(p.node.left, p.level - 1));
            }
            if (p.node.right != null) {
                queue.add(new TreeNodeLevelPair(p.node.right, p.level + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(8);
        root.right.right.left.right = new TreeNode(11);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.left.left.right.left = new TreeNode(9);
        root.left.left.right.left.left = new TreeNode(10);
        System.out.println(getTopView(root));
    }
}