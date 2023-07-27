package binary_tree_ii;

import utils.TreeNode;

public class CheckIdenticalTrees {

    public static boolean identicalTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.data == root2.data &&
                identicalTrees(root1.left, root2.left) &&
                identicalTrees(root1.right, root2.right);
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 2, 3, -1, 6, -1, -1, -1, -1 };
        int[] arr2 = { 5, 2, 3, -1, 6, -1, -1, -1, -1 };
        TreeNode root1 = TreeNode.insert(arr1, arr1.length, 0);
        TreeNode root2 = TreeNode.insert(arr2, arr2.length, 0);
        System.out.println(identicalTrees(root1, root2));

    }
}
