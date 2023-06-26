import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Pair {
    int start;
    int end;
    int pos;

    Pair(int s, int e) {
        start = s;
        end = e;
    }
}

public class MaximumActivity {

    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        int n = start.size();
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(start.get(i), end.get(i)));
        }
        Comparator<Pair> comp = (a, b) -> a.end - b.end;
        pairs.sort(comp);
        int limit = pairs.get(0).end;
        int maxAct = 1;
        for (int i = 0; i < n; i++) {
            if (pairs.get(i).start >= limit) {
                limit = pairs.get(i).end;
                maxAct++;
            }
        }
        return maxAct;
    }

    public static void main(String[] args) {
        List<Integer> start = Arrays.asList(1, 6, 2, 4);
        List<Integer> end = Arrays.asList(2, 7, 5, 8);
        System.out.println(maximumActivities(start, end));
    }
}
