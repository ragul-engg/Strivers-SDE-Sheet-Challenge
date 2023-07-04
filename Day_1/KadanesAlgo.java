public class KadanesAlgo {
    public static long maxSubarraySum(int[] arr, int n) {
        long maxVal = Long.MIN_VALUE;
        long currVal = 0;
        for (int i = 0; i < n; i++) {
            currVal += arr[i];
            maxVal = Math.max(currVal, maxVal);
            if (currVal < 0) {
                currVal = 0;
            }
        }
        if (maxVal < 0) {
            return 0;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{10,20,-30,40,-50,60};
        System.out.println("The sum of maximum subarray is "+maxSubarraySum(arr, 6));
    }
}
