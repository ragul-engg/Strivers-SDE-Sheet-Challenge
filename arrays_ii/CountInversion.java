package arrays_ii;

import java.util.*;

public class CountInversion {
    public static long merge(long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        int cnt = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                cnt += mid - left + 1;
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left++]);
        }
        while (right <= high) {
            temp.add(arr[right++]);
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        return cnt;
    }

    public static long mergeSort(long[] arr, int low, int high) {
        long cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            cnt += mergeSort(arr, low, mid);
            cnt += mergeSort(arr, mid + 1, high);
            cnt += merge(arr, low, mid, high);
        }
        return cnt;
    }

    public static long getInversions(long arr[], int n) {
        return mergeSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        long[] arr = new long[] { 3, 2, 1 };
        System.out.println(getInversions(arr, 3));
    }
}