package arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;

public class DuplicateNumber {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        int slow = arr.get(0);
        int fast = arr.get(0);
        do {
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        } while (slow != fast);
        fast = arr.get(0);
        while (slow != fast) {
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return slow;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(Arrays.asList(1, 3, 4, 2, 2));
        System.out.println(findDuplicate(al, 5));
    }
}
