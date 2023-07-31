package utils;

public class JobPair {
    public int id;
    public int deadline;
    public int profit;

    public JobPair(int i, int d, int p) {
        id = i;
        deadline = d;
        profit = p;
    }

    public JobPair(int d, int p) {
        deadline = d;
        profit = p;
    }

    @Override
    public String toString() {
        return "JobPair [id=" + id + ", deadline=" + deadline + ", profit=" + profit + "]";
    }

}
