import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    public static void findSubsets(int i, int j, int sum, ArrayList<Integer> nums, ArrayList<Integer> res) {
        if (i == j) {
            res.add(sum);
            return;
        }
        findSubsets(i + 1, j, sum + nums.get(i), nums, res);
        findSubsets(i + 1, j, sum, nums, res);

    }

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> subsetSum = new ArrayList<>();
        findSubsets(0, arr.size(), 0, arr, subsetSum);
        Collections.sort(subsetSum);
        return subsetSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(5, 2, 1));
        System.out.println(subsetSums(arr, arr.size()));
    }
}