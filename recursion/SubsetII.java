package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void findSubsets(int idx, int n, int[] nums, List<List<Integer>> result, ArrayList<Integer> subset) {
        result.add(new ArrayList<>(subset));
        for (int i = idx; i < n; i++) {
            if (i != idx && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.add(nums[i]);
            findSubsets(i + 1, n, nums, result, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, nums.length, nums, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        System.out.println(subsetsWithDup(arr));
    }
}
