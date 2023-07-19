package binary_search;

public class AllocateBooks {
    public static int findPages(int[] A, int N, int M) {
        if (N < M) {
            return -1;
        }
        long low = Long.MAX_VALUE, high = 0;
        for (int page : A) {
            low = Math.min(low, page);
            high += page;
        }
        while (low <= high) {
            long mid = (low + high) / 2;
            if (canAllocate(mid, N, M, A)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    public static boolean canAllocate(long maxPages, int N, int M, int[] pages) {
        long currPages = 0;
        int student = 1;
        for (int i = 0; i < N; i++) {
            if (pages[i] > maxPages) {
                return false;
            }
            if (currPages + pages[i] > maxPages) {
                currPages = pages[i];
                student++;
            } else {
                currPages += pages[i];
            }
        }
        return student <= M;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 34, 67, 90 };
        int n = arr.length;
        int m = 2;
        System.out.println(findPages(arr, n, m));
    }
}
