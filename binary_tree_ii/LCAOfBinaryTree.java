package binary_tree_ii;

import utils.TreeNode;

public class LCAOfBinaryTree {
    public static int lowestCommonAncestor(TreeNode root, int x, int y) {
        if (root == null) {
            return -1;
        }
        if (root.data == x || root.data == y) {
            return root.data;
        }
        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);
        if (left != -1 && right != -1) {
            return root.data;
        }
        return left == -1 ? right : left;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 7, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(lowestCommonAncestor(root, 4, 7));
    }
}
