package utils;

public class IntervalPair {
    public int pos;
    public int start;
    public int end;

    public IntervalPair(int s, int e) {
        start = s;
        end = e;
    }

    public IntervalPair(int p, int s, int e) {
        pos = p;
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "IntervalPair [pos=" + pos + ", start=" + start + ", end=" + end + "]";
    }

}