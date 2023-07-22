package binary_search_tree;

import utils.TreeNode;

public class SearchInBST {
    public static Boolean searchInBST(TreeNode root, int x) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.data == x) {
                return true;
            } else if (curr.data > x) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        System.out.println(searchInBST(root, 6));
    }
}