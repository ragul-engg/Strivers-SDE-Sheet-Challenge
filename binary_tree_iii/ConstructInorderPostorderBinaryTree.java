package binary_tree_iii;

import java.util.HashMap;
import java.util.Map;

import utils.TreeNode;

public class ConstructInorderPostorderBinaryTree {
    public static TreeNode createBT(int inStart, int inEnd, Map<Integer, Integer> map, int postStart, int postEnd,
            int[] postorder) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIdx = map.get(root.data);
        int numsLeft = rootIdx - inStart;
        root.left = createBT(inStart, rootIdx - 1, map, postStart, postStart + numsLeft - 1, postorder);
        root.right = createBT(rootIdx + 1, inEnd, map, postStart + numsLeft, postEnd - 1, postorder);
        return root;
    }

    public static TreeNode getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        Map<Integer, Integer> inordermap = new HashMap<>();
        int n = inOrder.length;
        for (int i = 0; i < n; i++) {
            inordermap.put(inOrder[i], i);
        }
        return createBT(0, n - 1, inordermap, 0, n - 1, postOrder);
    }
}
