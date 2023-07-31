package binary_tree_iii;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.TreeNode;

public class ConstructInorderPreorderBinaryTree {
    public static TreeNode createBT(int inStart, int inEnd, Map<Integer, Integer> map, int preStart, int preEnd,
            List<Integer> preorder) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder.get(preStart));
        int rootIdx = map.get(root.data);
        int numsLeft = rootIdx - inStart;
        root.left = createBT(inStart, rootIdx - 1, map, preStart + 1, preStart + numsLeft, preorder);
        root.right = createBT(rootIdx + 1, inEnd, map, preStart + numsLeft + 1, preEnd, preorder);
        return root;
    }

    public static TreeNode buildBinaryTree(List<Integer> inorder, List<Integer> preorder) {
        Map<Integer, Integer> inordermap = new HashMap<>();
        int n = inorder.size();
        for (int i = 0; i < n; i++) {
            inordermap.put(inorder.get(i), i);
        }
        return createBT(0, n - 1, inordermap, 0, n - 1, preorder);
    }
}
