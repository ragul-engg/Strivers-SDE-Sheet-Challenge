public class MaximumProfit {
    public static int maximumProfit(int[] prices) {
        int maxProfit = 0, minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 17, 20, 11, 9, 12, 6 };
        System.out.println(maximumProfit(prices));
    }
}
