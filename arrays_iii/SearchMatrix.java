package arrays_iii;

import java.util.*;

public class SearchMatrix {
    static boolean searchMatrix(ArrayList<List<Integer>> mat, int target) {
        int m = mat.size();
        int n = mat.get(0).size();
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int x = mid / n, y = mid % n;
            int midVal = mat.get(x).get(y);
            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
        al.add(Arrays.asList(1, 2, 3, 4));
        al.add(Arrays.asList(5, 6, 7, 8));
        al.add(Arrays.asList(9, 10, 11, 12));
        if (searchMatrix(al, 8)) {
            System.out.println("Found the target");
        } else {
            System.out.println("Target not found");
        }
    }
}
