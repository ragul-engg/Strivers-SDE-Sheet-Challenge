import java.util.*;

public class DutchNationalFlag {
    public static void sort012(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low];
                arr[low] = arr[mid];
                arr[mid] = t;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                int t = arr[high];
                arr[high] = arr[mid];
                arr[mid] = t;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 2, 1, 2, 1, 2 };
        sort012(arr);
        Arrays.stream(arr).mapToObj(e -> e + " ").forEach(System.out::print);
        ;
    }
}