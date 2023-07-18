import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs, int n) {
        Arrays.sort(strs);
        int len = Math.min(strs[0].length(), strs[n - 1].length());
        String first = strs[0], last = strs[n - 1];
        int idx = 0;
        while (idx < len && first.charAt(idx) == last.charAt(idx)) {
            idx++;
        }
        return first.substring(0, idx);
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        System.out.println(longestCommonPrefix(strs, strs.length));
    }
}
