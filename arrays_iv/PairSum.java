package arrays_iv;

import java.util.*;

public class PairSum {
    public static List<int[]> pairSum(int[] arr, int s) {
        Map<Integer, Integer> set = new HashMap<>();
        List<int[]> al = new ArrayList<>();
        for (int val : arr) {
            int target = s - val;
            if (set.containsKey(target)) {
                int times = set.get(target);
                for (int i = 0; i < times; i++) {
                    al.add(new int[] { Math.min(target, val), Math.max(target, val) });
                }
            }
            set.put(val, set.getOrDefault(val, 0) + 1);
        }
        Collections.sort(al, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });
        return al;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, -6, 2, 5, 2 };
        List<int[]> result = pairSum(arr, 4);
        result.stream().map(e -> Arrays.toString(e)).forEach(System.out::println);
    }
}
