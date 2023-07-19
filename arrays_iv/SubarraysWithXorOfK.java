package arrays_iv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithXorOfK {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int cnt = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        int len = arr.size();
        int currVal = 0;
        hash.put(0, 1);
        for (int i = 0; i < len; i++) {
            currVal = currVal ^ arr.get(i);
            int required = currVal ^ x;
            if (hash.containsKey(required)) {
                cnt += hash.get(required);
            }
            hash.put(currVal, hash.getOrDefault(currVal, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(Arrays.asList(4, 2, 2, 6, 4));
        System.out.println(subarraysXor(al, 6));
    }
}
