package utils;

public class KnapsackPair {
    public int value;
    public int weight;

    public KnapsackPair(int w, int v) {
        weight = w;
        value = v;
    }

    @Override
    public String toString() {
        return "KnapsackPair [value=" + value + ", weight=" + weight + "]";
    }

}
