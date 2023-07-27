package binary_tree_misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctNumInEveryWindow {

    public static ArrayList<Integer> countDistinctElements(List<Integer> arr, int k) {
        Map<Integer, Integer> hash = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.size();
        int distinctCnt = 0;
        for (int i = 0; i < k; i++) {
            int newVal = arr.get(i);
            hash.put(newVal, hash.getOrDefault(newVal, 0) + 1);
            if (hash.get(newVal) == 1) {
                distinctCnt++;
            }
        }
        result.add(distinctCnt);
        for (int i = k; i < n; i++) {
            int newVal = arr.get(i);
            int removeVal = arr.get(i - k);
            hash.put(newVal, hash.getOrDefault(newVal, 0) + 1);
            if (hash.get(newVal) == 1) {
                distinctCnt++;
            }
            hash.put(removeVal, hash.get(removeVal) - 1);
            if (hash.get(removeVal) == 0) {
                distinctCnt--;
            }
            result.add(distinctCnt);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 1, 3, 4, 2, 3);
        int k = 4;
        System.out.println(countDistinctElements(arr, k));
    }
}