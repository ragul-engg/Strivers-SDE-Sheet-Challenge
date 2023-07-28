package binary_tree;

import java.util.Deque;
import java.util.LinkedList;

import utils.TreeNode;

public class MaximumWidthBinaryTree {
    public static int getMaxWidth(TreeNode root) {
        int result = 0;
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            result = Math.max(result, size);
            for (int s = 0; s < size; s++) {
                TreeNode currNode = queue.poll();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, -1, 5, 6, -1, 7, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(getMaxWidth(root));
    }
}
