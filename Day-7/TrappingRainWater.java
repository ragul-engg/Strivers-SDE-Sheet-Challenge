public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1, maxL = 0, maxR = height[right], totalWater = 0;
        while (left <= right) {
            if (maxL <= maxR) {
                int water = maxL - height[left];
                if (water > 0)
                    totalWater += water;
                maxL = Math.max(maxL, height[left]);
                left++;
            } else {
                int water = maxR - height[right];
                if (water > 0)
                    totalWater += water;
                maxR = Math.max(maxR, height[right]);
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}