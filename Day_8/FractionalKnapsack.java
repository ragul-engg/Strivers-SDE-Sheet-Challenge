import java.util.*;

class Pair {
    int value;
    int weight;

    Pair(int w, int v) {
        weight = w;
        value = v;
    }
}

public class FractionalKnapsack {
    public static double maximumValue(Pair[] items, int n, int w) {
        // Write your code here.
        // ITEMS contains {weight, value} pairs.
        Arrays.sort(items, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                double r1 = (double) a.value / (double) a.weight;
                double r2 = (double) b.value / (double) b.weight;
                return Double.compare(r2, r1);
            }
        });

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
        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair(50, 40);
        pairs[1] = new Pair(40, 50);
        pairs[2] = new Pair(90, 25);
        pairs[3] = new Pair(120, 100);
        pairs[4] = new Pair(10, 30);
        pairs[5] = new Pair(200, 45);
        System.out.println(maximumValue(pairs, pairs.length, 200));
    }
}
