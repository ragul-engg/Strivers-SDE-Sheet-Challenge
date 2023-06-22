import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultArray = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1, right = nums.length - 1;
                int reqSum = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == reqSum) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[left]);
                        sol.add(nums[right]);
                        resultArray.add(sol);
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right - 1] == nums[right])
                            right--;
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > reqSum) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> triplets = threeSum(arr);
        triplets.forEach(System.out::println);
    }
}
