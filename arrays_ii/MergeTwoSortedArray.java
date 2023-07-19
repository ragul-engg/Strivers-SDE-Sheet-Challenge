package arrays_ii;

import java.util.*;

public class MergeTwoSortedArray {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            } else {
                break;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1, 0, m);
        Arrays.sort(arr2);
        for (i = m; i < m + n; i++) {
            arr1[i] = arr2[i - m];
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] { 3, 6, 9, 0, 0 };
        int[] arr2 = new int[] { 4, 10 };
        arr1 = ninjaAndSortedArrays(arr1, arr2, 3, 2);
        Arrays.stream(arr1).mapToObj(e -> e + " ").forEach(System.out::print);
    }
}
