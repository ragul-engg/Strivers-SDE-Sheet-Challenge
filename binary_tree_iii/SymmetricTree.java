package binary_tree_iii;

import utils.TreeNode;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.data == right.data && isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 4, 4, 3, -1, -1, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(isSymmetric(root));
    }
}
