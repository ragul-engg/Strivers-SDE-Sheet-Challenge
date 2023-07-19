package arrays;

import java.util.ArrayList;

public class PascalTriangle {

    public static ArrayList<ArrayList<Long>> getPascal(int n) {
        ArrayList<ArrayList<Long>> al = new ArrayList<ArrayList<Long>>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                long val = 1;
                if (j != 0 && j != i) {
                    val = al.get(i - 1).get(j - 1) + al.get(i - 1).get(j);
                }
                al.get(i).add(val);
            }
        }
        return al;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Long>> al = getPascal(5);
        al.forEach(e -> {
            for (long val : e) {
                System.out.print(val + " ");
            }
            System.out.println();
        });
    }
}
