package arrays;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {
    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        int idx = -1;
        int len = permutation.size();
        for (int i = len - 2; i >= 0; i--) {
            if (permutation.get(i) < permutation.get(i + 1)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            Collections.reverse(permutation);
            return permutation;
        }
        for (int i = len - 1; i > idx; i--) {
            if (permutation.get(i) > permutation.get(idx)) {
                int temp = permutation.get(i);
                permutation.set(i, permutation.get(idx));
                permutation.set(idx, temp);
                break;
            }
        }
        int left = idx + 1;
        int right = len - 1;
        while (left < right) {
            int temp = permutation.get(left);
            permutation.set(left, permutation.get(right));
            permutation.set(right, temp);
            left++;
            right--;
        }
        return permutation;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.addAll(Arrays.asList(2, 1, 5, 4, 3, 0, 0));
        al = nextPermutation(al);
        al.stream().map(e -> e + " ").forEach(System.out::print);
    }

}
