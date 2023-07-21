package binary_search_tree_ii;

import java.util.ArrayDeque;
import java.util.Deque;

import utils.TreeNode;

public class BSTIterator {
    Deque<TreeNode> stack = new ArrayDeque<>();

    BSTIterator(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            stack.add(curr);
            curr = curr.left;
        }
    }

    int next() {
        TreeNode node = stack.pollLast();
        if (node.right != null) {
            TreeNode curr = node.right;
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }
        }
        return node.data;
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(11);
        BSTIterator itr = new BSTIterator(root);
        System.out.println(itr.next());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());
        System.out.println(itr.next());
        System.out.println(itr.hasNext());

    }
}