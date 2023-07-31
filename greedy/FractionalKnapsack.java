package greedy;

import java.util.Arrays;

import utils.KnapsackPair;

public class FractionalKnapsack {
    public static double maximumValue(KnapsackPair[] items, int n, int w) {
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0;
        int totalWeight = 0;
        for (int i = 0; i < n; i++) {
            if (totalWeight + items[i].weight <= w) {
                totalValue += items[i].value;
                totalWeight += items[i].weight;
            } else {
                int remaining = w - totalWeight;
                totalValue += ((double) items[i].value / (double) items[i].weight) * (double) remaining;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        KnapsackPair[] pairs = new KnapsackPair[6];
        pairs[0] = new KnapsackPair(50, 40);
        pairs[1] = new KnapsackPair(40, 50);
        pairs[2] = new KnapsackPair(90, 25);
        pairs[3] = new KnapsackPair(120, 100);
        pairs[4] = new KnapsackPair(10, 30);
        pairs[5] = new KnapsackPair(200, 45);
        System.out.println(maximumValue(pairs, pairs.length, 200));
    }
}
