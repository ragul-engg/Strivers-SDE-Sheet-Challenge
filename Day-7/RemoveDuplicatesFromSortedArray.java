import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(ArrayList<Integer> nums, int n) {
        int uniqueCtr = 1;
        int prevVal = nums.get(0);
        int idx = 1;
        while (idx < n) {
            int currVal = nums.get(idx);
            if (currVal != prevVal) {
                nums.set(uniqueCtr++, currVal);
                prevVal = currVal;
            }
            idx++;
        }
        return uniqueCtr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 2, 2, 2, 3, 3, 4, 5, 6));
        System.out.println(removeDuplicates(arr, arr.size()));
    }
}