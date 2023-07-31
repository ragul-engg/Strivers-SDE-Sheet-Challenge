package greedy;

import java.util.Arrays;

public class MinimumPlatforms {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int maxPlatCnt = 0;
        int currPlatCnt = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (i == 0 || at[i] <= dt[j]) {
                currPlatCnt++;
                i++;
            } else {
                currPlatCnt--;
                j++;
            }
            maxPlatCnt = Math.max(maxPlatCnt, currPlatCnt);
        }
        return maxPlatCnt;

    }

    public static void main(String[] args) {
        int[] at = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dt = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(calculateMinPatforms(at, dt, at.length));
    }

}