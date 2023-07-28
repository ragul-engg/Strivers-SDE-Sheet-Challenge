package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;
import utils.TreeNodeLevelPair;

public class SingleTraversal {
    public static List<List<Integer>> getTreeTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(new ArrayList<>());
        }
        if (root == null) {
            return result;
        }
        Deque<TreeNodeLevelPair> stack = new LinkedList<>();
        stack.add(new TreeNodeLevelPair(root, 1));
        while (!stack.isEmpty()) {
            TreeNodeLevelPair p = stack.peekLast();
            if (p.level == 1) {
                result.get(0).add(p.node.data);
                p.level++;
                if (p.node.left != null) {
                    stack.add(new TreeNodeLevelPair(p.node.left, 1));
                }
            } else if (p.level == 2) {
                result.get(1).add(p.node.data);
                p.level++;
                if (p.node.right != null) {
                    stack.add(new TreeNodeLevelPair(p.node.right, 1));
                }
            } else {
                result.get(2).add(p.node.data);
                stack.pollLast();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(getTreeTraversal(root));
    }
}
