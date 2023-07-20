package binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import utils.TreeNode;

public class LeftView {
    public static ArrayList<Integer> getLeftView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(14);
        root.left.right = new TreeNode(19);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(15);
        root.right.right.left = new TreeNode(25);
        ArrayList<Integer> result = getLeftView(root);
        System.out.println(result);
    }
}
