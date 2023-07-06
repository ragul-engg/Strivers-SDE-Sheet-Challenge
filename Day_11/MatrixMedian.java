public class MatrixMedian {
    int countValues(int[] arr, int C, int key) {
        int low = 0, high = C - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    int cntSmallerThanMid(int[][] matrix, int R, int C, int mid) {
        int result = 0;
        for (int i = 0; i < R; i++) {
            result += countValues(matrix[i], C, mid);
        }
        return result;
    }

    int median(int matrix[][], int R, int C) {
        int low = 1;
        int high = 2000;
        while (low <= high) {
            int mid = (low + high) / 2;
            int valCntLessThanMid = cntSmallerThanMid(matrix, R, C, mid);
            if (valCntLessThanMid > (R * C) / 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        MatrixMedian m = new MatrixMedian();
        int[][] arr = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        System.out.println(m.median(arr, 3, 3));
    }
}