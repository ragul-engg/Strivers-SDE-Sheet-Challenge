import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class CombinationalSumII {

    public static void findSubsetSum(int idx, int n, int target, ArrayList<Integer> arr,
            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (i != idx && arr.get(i) == arr.get(i - 1)) {
                continue;
            }
            if (arr.get(i) > target) {
                break;
            }
            subset.add(arr.get(i));
            findSubsetSum(i + 1, n, target - arr.get(i), arr, result, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findSubsetSum(0, n, target, arr, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(10, 1, 2, 7, 6, 1, 5));
        System.out.println(combinationSum2(arr, arr.size(), 8));
    }
}