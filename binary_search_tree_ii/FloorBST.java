package binary_search_tree_ii;

import utils.TreeNode;

public class FloorBST {
    public static int floorInBST(TreeNode root, int X) {
        TreeNode curr = root;
        int ans = -1;
        while (curr != null) {
            if (curr.data <= X) {
                ans = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
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
        System.out.println(floorInBST(root, 7));
    }
}
