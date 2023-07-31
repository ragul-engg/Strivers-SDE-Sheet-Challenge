package binary_search_tree;

import java.util.ArrayList;

import utils.TreeNode;

public class SortedArrayToBST {
    public static TreeNode createBST(int start, int end, ArrayList<Integer> arr) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = createBST(start, mid - 1, arr);
        root.right = createBST(mid + 1, end, arr);
        return root;
    }

    public static TreeNode sortedArrToBST(ArrayList<Integer> arr, int n) {
        return createBST(0, n - 1, arr);
    }
}
