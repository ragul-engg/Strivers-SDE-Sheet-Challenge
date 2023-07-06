import java.util.ArrayList;
import java.util.Arrays;

public class SingleElementSortedArray {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {
        int low = 0;
        int high = arr.size() - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) == arr.get(mid ^ 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return arr.get(low);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 3, 5, 5));
        System.out.println(singleNonDuplicate(arr));
    }
}
