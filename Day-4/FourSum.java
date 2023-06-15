import java.util.*;

public class FourSum {
    public static String fourSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 1; j < n - 2; j++) {
                int required = target - arr[i] - arr[j];
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int currRemainingSum = arr[left] + arr[right];
                    if (currRemainingSum == required) {
                        return "Yes";
                    } else if (currRemainingSum < required) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return "No";
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 4, 6, 3, 1, 1 };
        System.out.println(fourSum(arr, 20, 6));
    }
}
