package binary_search;

public class KthElementSortedArrays {
    public static int kthElementSortedArrays(int row1[], int row2[], int m, int n, int k) {
        if (n < m) {
            return kthElementSortedArrays(row2, row1, n, m, k);
        }
        int low = Math.max(0, k - n), high = Math.min(m, k);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;

            int l1 = cut1 > 0 ? row1[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = cut2 > 0 ? row2[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = cut1 < m ? row1[cut1] : Integer.MAX_VALUE;
            int r2 = cut2 < n ? row2[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 5, 8, 17 };
        int[] arr2 = { 1, 4, 8, 13, 20 };
        int k = 5;
        System.out.println(kthElementSortedArrays(arr1, arr2, arr1.length, arr2.length, k));
    }
}
