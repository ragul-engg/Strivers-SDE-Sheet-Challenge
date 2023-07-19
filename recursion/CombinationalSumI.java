package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationalSumI {
    private static void findSubsets(int i, int n, int k, ArrayList<Integer> arr, ArrayList<Integer> subset,
            ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            if (k == 0) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(arr.get(i));
        findSubsets(i + 1, n, k - arr.get(i), arr, subset, result);
        subset.remove(subset.size() - 1);
        findSubsets(i + 1, n, k, arr, subset, result);
    }

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        findSubsets(0, n, k, arr, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(-9, 4, -6, 7));
        System.out.println(findSubsetsThatSumToK(arr, arr.size(), -2));
    }
}