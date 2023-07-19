package recursion;

import java.util.*;

public class PalindromePartitioning {

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void findPartition(int idx, int len, String s, List<List<String>> result, List<String> words) {
        if (idx == len) {
            result.add(new ArrayList<>(words));
            return;
        }
        for (int i = idx; i < len; i++) {
            if (isPalindrome(s, idx, i)) {
                words.add(s.substring(idx, i + 1));
                findPartition(i + 1, len, s, result, words);
                words.remove(words.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        findPartition(0, s.length(), s, result, new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabb"));
    }
}
