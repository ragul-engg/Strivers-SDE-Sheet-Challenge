package binary_tree_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import utils.TreeNode;

public class ZigZagTraversal {
    public static List<Integer> zigZagTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> currLevelNodes = new ArrayList<>();
        boolean level = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                currLevelNodes.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!level) {
                Collections.reverse(currLevelNodes);
            }
            result.addAll(currLevelNodes);
            currLevelNodes.clear();
            level = !level;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, -1, -1, -1, 6, -1, -1 };
        TreeNode root = TreeNode.insert(arr, arr.length, 0);
        System.out.println(zigZagTraversal(root));
    }
}
