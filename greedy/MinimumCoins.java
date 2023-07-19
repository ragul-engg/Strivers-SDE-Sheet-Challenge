public class MinimumCoins {

    public static int findMinimumCoins(int amount) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int coinIdx = 8;
        int coinCnt = 0;
        while (amount > 0) {
            while (amount >= coins[coinIdx]) {
                amount -= coins[coinIdx];
                coinCnt++;
            }
            coinIdx--;
        }
        return coinCnt;
    }

    public static void main(String[] args) {
        System.out.println(findMinimumCoins(49));
    }
}
