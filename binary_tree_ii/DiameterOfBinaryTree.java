package binary_tree_ii;

import utils.TreeNode;

public class DiameterOfBinaryTree {
    public static int findWidth(TreeNode root, int[] maxWidth) {
        if (root == null) {
            return 0;
        }
        int leftHeight = findWidth(root.left, maxWidth);
        int rightHeight = findWidth(root.right, maxWidth);
        maxWidth[0] = Math.max(maxWidth[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] maxWidth = new int[1];
        findWidth(root, maxWidth);
        return maxWidth[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 7, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(diameterOfBinaryTree(root));
    }
}
