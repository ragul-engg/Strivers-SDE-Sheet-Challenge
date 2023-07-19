package recursion;

import java.util.ArrayList;

public class KthPermutation {
    public static String kthPermutation(int n, int k) {
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder ans = new StringBuilder();
        k = k - 1;
        while (true) {
            ans.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.size() == 0) {
                break;
            }
            k = k % fact;
            fact = fact / numbers.size();
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(kthPermutation(3, 3));
    }
}
