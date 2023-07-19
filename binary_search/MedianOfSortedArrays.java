package binary_search;

public class MedianOfSortedArrays {
    public static double median(int[] a, int[] b) {
        if (b.length < a.length) {
            return median(b, a);
        }
        int n1 = a.length, n2 = b.length;
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = cut1 > 0 ? a[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = cut2 > 0 ? b[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = cut1 < n1 ? a[cut1] : Integer.MAX_VALUE;
            int r2 = cut2 < n2 ? b[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
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
        int[] arr1 = { 1, 3, 4, 7, 9, 10 };
        int[] arr2 = { 2, 3, 4, 8, 12 };
        System.out.println(median(arr1, arr2));
    }
}