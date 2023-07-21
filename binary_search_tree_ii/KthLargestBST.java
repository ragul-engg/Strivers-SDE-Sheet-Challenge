package binary_search_tree_ii;

import utils.TreeNode;

public class KthLargestBST {
    public static int kthNode(TreeNode root, int[] count, int k) {
        if (root == null) {
            return -1;
        }
        int kth = kthNode(root.right, count, k);
        if (kth != -1) {
            return kth;
        }
        count[0]++;
        if (count[0] == k) {
            return root.data;
        }
        return kthNode(root.left, count, k);
    }

    public static int kthLargest(TreeNode root, int k) {
        int[] count = new int[1];
        return kthNode(root, count, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(16);
        System.out.println(kthLargest(root, 3));
    }
}
