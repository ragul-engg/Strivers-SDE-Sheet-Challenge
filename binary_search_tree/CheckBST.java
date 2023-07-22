package binary_search_tree;

import utils.TreeNode;

public class CheckBST {
    public static boolean checkBST(TreeNode root, long mini, long maxi) {
        if (root == null) {
            return true;
        }
        if (root.data > maxi || root.data < mini) {
            return false;
        }
        return checkBST(root.left, mini, root.data) && checkBST(root.right, root.data, maxi);
    }

    public static boolean validateBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        System.out.println(validateBST(root));
    }
}