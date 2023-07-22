package binary_search_tree;

import utils.TreeNode;

public class LowestCommonAncestor {
    public static TreeNode LCAinaBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode leftTree = LCAinaBST(root.left, p, q);
        TreeNode rightTree = LCAinaBST(root.right, p, q);
        if (leftTree != null && rightTree != null) {
            return root;
        }
        return leftTree == null ? rightTree : leftTree;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        System.out.println(LCAinaBST(root, root.left, root.right.left).data);
    }
}