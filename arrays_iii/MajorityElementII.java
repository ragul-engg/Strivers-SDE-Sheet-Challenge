package arrays_iii;

import java.util.*;

import java.util.ArrayList;

public class MajorityElementII {
    public static ArrayList<Integer> majorityElementII(List<Integer> arr) {
        ArrayList<Integer> al = new ArrayList<>();
        int count1 = 0, count2 = 0;
        int ele1 = -1, ele2 = -1;
        int n = arr.size();
        for (int val : arr) {
            if (count1 == 0 && val != ele2) {
                ele1 = val;
                count1 = 1;
            } else if (count2 == 0 && val != ele1) {
                ele2 = val;
                count2 = 1;
            } else if (val == ele1) {
                count1++;
            } else if (val == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int val : arr) {
            if (val == ele1) {
                count1++;
            } else if (val == ele2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            al.add(ele1);
        }
        if (count2 > n / 3) {
            al.add(ele2);
        }
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        List<Integer> al = Arrays.asList(7, 4, 4, 9, 7);
        System.out.println(majorityElementII(al));
    }
}