package binary_search;

public class SearchInRotatedArray {
    public static int search(int arr[], int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                if (arr[low] <= key && key <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= key && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
        System.out.println(search(arr, 7));
    }
}