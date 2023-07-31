package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import utils.IntervalPair;

public class N_Meeting {

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        List<IntervalPair> timing = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timing.add(new IntervalPair(i + 1, start[i], end[i]));
        }
        Comparator<IntervalPair> comp = (a, b) -> a.end - b.end;
        comp = comp.thenComparing((a, b) -> a.pos - b.pos);
        timing.sort(comp);
        List<Integer> result = new ArrayList<>();
        result.add(timing.get(0).pos);
        int limit = timing.get(0).end;
        for (int i = 1; i < n; i++) {
            if (timing.get(i).start > limit) {
                limit = timing.get(i).end;
                result.add(timing.get(i).pos);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] start = { 1, 3, 0, 05, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maximumMeetings(start, end));
    }
}