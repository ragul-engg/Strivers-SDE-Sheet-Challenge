package binary_tree_iii;

import utils.TreeNode;

public class MaximumPathSumLeaves {
    private static long findMaxSumPath(TreeNode root, long[] result) {
        if (root == null) {
            return -1;
        }
        if (isLeaf(root)) {
            return root.data;
        }
        long left = findMaxSumPath(root.left, result);
        long right = findMaxSumPath(root.right, result);
        if (left != -1 && right != -1) {
            result[0] = Math.max(result[0], left + right + root.data);
        }
        return Math.max(left, right) + root.data;
    }

    public static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    public static long findMaxSumPath(TreeNode root) {
        long[] result = new long[1];
        result[0] = -1;
        if (root == null || isLeaf(root)) {
            return result[0];
        }
        findMaxSumPath(root, result);
        return result[0];
    }

    public static void main(String[] args) {
        int[] arr = { 5, 6, 2, 4, 3, -1, -1, 9, 7, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(findMaxSumPath(root));
    }
}
