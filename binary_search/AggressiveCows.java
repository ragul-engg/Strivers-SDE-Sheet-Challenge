package binary_search;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean canAllocateCows(int[] stalls, int minDistance, int n, int k) {
        int last = stalls[0];
        int cowCnt = 1;
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= minDistance) {
                cowCnt++;
                last = stalls[i];
                if (cowCnt == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1, high = stalls[n - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAllocateCows(stalls, mid, n, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] stalls = { 1, 2, 3 };
        int cows = 2;
        System.out.println(aggressiveCows(stalls, cows));
    }
}
