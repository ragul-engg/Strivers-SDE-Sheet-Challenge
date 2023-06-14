public class MajorityElement {
    public static boolean isMajority(int cand, int n, int[] arr) {
        int candCnt = 0;
        for (int val : arr) {
            if (val == cand) {
                candCnt++;
            }
        }
        return candCnt > n / 2;
    }

    public static int getCandidate(int n, int[] arr) {
        int count = 1, majority = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                count = 1;
                majority = arr[i];
            }
        }
        return majority;
    }

    public static int findMajority(int[] arr, int n) {
        int cand = getCandidate(n, arr);
        if (isMajority(cand, n, arr)) {
            return cand;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 9, 2, 2 };
        System.out.println("The majority Element is " + findMajority(arr, 5));
    }
}