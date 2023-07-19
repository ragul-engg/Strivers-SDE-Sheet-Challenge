import java.util.ArrayList;
import java.util.Arrays;

public class MaxConsequtiveOnes {
    public static int longestSubSeg(ArrayList<Integer> arr, int n, int k) {
        int left = 0;
        int zeroCnt = 0, maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0) {
                zeroCnt++;
            }
            while (zeroCnt > k) {
                if (arr.get(left++) == 0) {
                    zeroCnt--;
                }
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.addAll(Arrays.asList(1, 0, 0, 1, 1, 0, 1));
        System.out.println(longestSubSeg(arr, arr.size(), 1));
    }
}
