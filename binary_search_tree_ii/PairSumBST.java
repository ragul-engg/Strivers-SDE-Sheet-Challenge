package binary_search_tree_ii;

import java.util.*;

import utils.TreeNode;

public class PairSumBST {
    Deque<TreeNode> stack;
    boolean isReverse;

    PairSumBST(TreeNode root, boolean reverse) {
        stack = new ArrayDeque<>();
        isReverse = reverse;
        pushAll(root);
    }

    int next() {
        TreeNode node = stack.pollLast();
        if (isReverse) {
            pushAll(node.left);
        } else {
            pushAll(node.right);
        }
        return node.data;
    }

    void pushAll(TreeNode curr) {
        while (curr != null) {
            stack.add(curr);
            if (isReverse) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    public static boolean pairSumBst(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        PairSumBST asc = new PairSumBST(root, false);
        PairSumBST desc = new PairSumBST(root, true);
        int left = asc.next();
        int right = desc.next();
        while (left < right) {
            int sum = left + right;
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left = asc.next();
            } else {
                right = desc.next();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(11);
        System.out.println(pairSumBst(root, 22));
    }
}