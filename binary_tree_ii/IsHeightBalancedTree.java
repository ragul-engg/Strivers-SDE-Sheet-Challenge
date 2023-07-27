package binary_tree_ii;

import utils.TreeNode;

public class IsHeightBalancedTree {
    private static int isBalanced(TreeNode root, boolean[] result) {
        if (root == null) {
            return 0;
        }
        int leftH = isBalanced(root.left, result);
        int rightH = isBalanced(root.right, result);
        if (Math.abs(leftH - rightH) > 1) {
            result[0] = true;
        }
        return 1 + Math.max(leftH, rightH);
    }

    public static boolean isBalancedBT(TreeNode root) {
        boolean[] result = new boolean[1];
        isBalanced(root, result);
        return !result[0];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, -1, -1, -1, -1, 5, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(isBalancedBT(root));
    }
}
