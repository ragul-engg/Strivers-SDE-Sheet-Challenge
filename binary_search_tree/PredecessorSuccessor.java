package binary_search_tree;

import java.util.ArrayList;

import utils.TreeNode;

public class PredecessorSuccessor {
    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode succ = null;
        while (curr != null) {
            if (curr.data > key) {
                succ = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        curr = root;
        while (curr != null) {
            if (curr.data < key) {
                prev = curr;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (prev == null) {
            prev = new TreeNode(-1);
        }
        if (succ == null) {
            succ = new TreeNode(-1);
        }
        result.add(prev.data);
        result.add(succ.data);
        return result;
    }
}
