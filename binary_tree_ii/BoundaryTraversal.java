package binary_tree_ii;

import java.util.ArrayList;

import utils.TreeNode;

public class BoundaryTraversal {
    public static void leftBoundary(TreeNode root, ArrayList<Integer> result) {
        while (root != null && !isLeaf(root)) {
            result.add(root.data);
            if (root.left != null) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    public static void rightBoundary(TreeNode root, ArrayList<Integer> result) {
        if (root == null || isLeaf(root)) {
            return;
        }
        if (root.right != null) {
            rightBoundary(root.right, result);
        } else {
            rightBoundary(root.left, result);
        }
        result.add(root.data);
    }

    public static void leafNodes(TreeNode root, ArrayList<Integer> result) {
        if (root != null) {
            leafNodes(root.left, result);
            if (isLeaf(root)) {
                result.add(root.data);
            }
            leafNodes(root.right, result);
        }
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.data);
        }
        leftBoundary(root.left, result);
        leafNodes(root, result);
        rightBoundary(root.right, result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(traverseBoundary(root));
    }
}