package binary_search_tree_ii;

import utils.TreeNode;

public class CeilBST {
    public static int findCeil(TreeNode node, int x) {
        TreeNode curr = node;
        int ans = -1;
        while (curr != null) {
            if (curr.data >= x) {
                ans = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);
        System.out.println(findCeil(root, 7));
    }
}
