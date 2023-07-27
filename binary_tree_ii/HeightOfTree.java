package binary_tree_ii;

import utils.TreeNode;

public class HeightOfTree {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        int[] arr = { 3, -1, 1, -1, -1, 2, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(maxDepth(root));
    }
}