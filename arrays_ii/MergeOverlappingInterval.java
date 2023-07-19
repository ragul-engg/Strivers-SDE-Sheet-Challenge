package arrays_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Interval {
    int start, finish;

    Interval(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }

    @Override
    public String toString() {
        return String.format("[%d-%d] ", start, finish);
    }
}

public class MergeOverlappingInterval {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        List<Interval> al = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return Integer.compare(a.finish, b.finish);
                }
                return Integer.compare(a.start, b.start);
            }
        });
        for (Interval interval : intervals) {
            if (al.isEmpty() || interval.start > al.get(al.size() - 1).finish) {
                al.add(interval);
            } else {
                Interval in = al.get(al.size() - 1);
                in.finish = Math.max(in.finish, interval.finish);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[5];
        intervals[0] = new Interval(1, 4);
        intervals[1] = new Interval(3, 5);
        intervals[2] = new Interval(6, 8);
        intervals[3] = new Interval(10, 12);
        intervals[4] = new Interval(8, 9);
        List<Interval> al = mergeIntervals(intervals);
        al.forEach(System.out::print);
    }
}
