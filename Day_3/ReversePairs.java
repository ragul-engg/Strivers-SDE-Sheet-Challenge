public class ReversePairs {
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (i = low; i <= high; i++) {
            nums[i] = temp[i - low];
        }
    }

    public static int countPairs(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] nums, int low, int high) {
        int cnt = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            cnt += mergeSort(nums, low, mid);
            cnt += mergeSort(nums, mid + 1, high);
            cnt += countPairs(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return cnt;
    }

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 3, 2, 3, 1 };
        System.out.println("The pair count is " + reversePairs(arr));
    }
}