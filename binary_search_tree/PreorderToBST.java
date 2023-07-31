package binary_search_tree;

import utils.TreeNode;

public class PreorderToBST {
    public static TreeNode createBST(int[] idx, int n, int[] preOrder, int bound) {
        if (idx[0] == n || preOrder[idx[0]] > bound) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[idx[0]]);
        idx[0]++;
        root.left = createBST(idx, n, preOrder, root.data);
        root.right = createBST(idx, n, preOrder, bound);
        return root;
    }

    public static TreeNode preOrderTree(int[] preOrder) {
        int n = preOrder.length;
        int[] idx = new int[1];
        return createBST(idx, n, preOrder, Integer.MAX_VALUE);
    }
}
