package utils;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int d) {
        data = d;
        left = right = next = null;
    }

    public static TreeNode insert(int[] arr, int n, int i) {
        TreeNode root = null;
        if (i < n && arr[i] != -1) {
            root = new TreeNode(arr[i]);
            root.left = insert(arr, n, 2 * i + 1);
            root.right = insert(arr, n, 2 * i + 2);
        }
        return root;
    }
}
