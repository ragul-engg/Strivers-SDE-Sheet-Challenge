package binary_search_tree_ii;

import utils.TreeNode;

class Pair {
    int size;
    int largest;
    int smallest;

    Pair(int sz, int l, int s) {
        size = sz;
        largest = l;
        smallest = s;
    }
}

public class LargestBSTInBinaryTree {

    public static Pair findLargestBST(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        Pair left = findLargestBST(root.left);
        Pair right = findLargestBST(root.right);
        if (left.largest < root.data && root.data < right.smallest) {
            return new Pair(left.size + right.size + 1, Math.max(root.data, right.largest),
                    Math.min(root.data, left.smallest));
        } else {
            return new Pair(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
    }

    public static int largestBST(TreeNode root) {
        Pair p = findLargestBST(root);
        return p.size;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 2, 4, 1, 3, -1, -1, -1, -1, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(largestBST(root));
    }
}
