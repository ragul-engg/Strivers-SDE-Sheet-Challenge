package arrays_ii;

import java.util.*;

import java.util.ArrayList;

public class RotateMatrix {
    public static void rotateMatrix(ArrayList<List<Integer>> mat, int n, int m) {
        int left = 0, top = 0, bottom = n - 1, right = m - 1;
        while (top < bottom && left < right) {
            int temp = mat.get(top).get(left);
            for (int i = top + 1; i <= bottom; i++) {
                mat.get(i - 1).set(left, mat.get(i).get(left));
            }
            for (int i = left + 1; i <= right; i++) {
                mat.get(bottom).set(i - 1, mat.get(bottom).get(i));
            }
            for (int i = bottom; i > top; i--) {
                mat.get(i).set(right, mat.get(i - 1).get(right));
            }
            for (int i = right; i > left; i--) {
                mat.get(top).set(i, mat.get(top).get(i - 1));
            }
            mat.get(top).set(left + 1, temp);
            top++;
            left++;
            right--;
            bottom--;
        }
    }

    public static void printMatrix(ArrayList<List<Integer>> al) {
        for (List<Integer> row : al) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> al = new ArrayList<List<Integer>>();
        al.add(Arrays.asList(1, 2, 3));
        al.add(Arrays.asList(4, 5, 6));
        al.add(Arrays.asList(7, 8, 9));
        rotateMatrix(al, 3, 3);
        printMatrix(al);
    }
}
