public class LongestPalindromeSubstring {
    public static String longestPalinSubstring(String str) {
        int len = str.length();
        int substart = -1, subend = -1;
        int maxLen = Integer.MIN_VALUE;
        for (int idx = 0; idx < len; idx++) {
            int start = idx - 1, end = idx + 1;
            while (start >= 0 && str.charAt(start) == str.charAt(idx)) {
                start--;
            }
            while (end < len && str.charAt(end) == str.charAt(idx)) {
                end++;
            }
            while (start >= 0 && end < len && str.charAt(start) == str.charAt(end)) {
                start--;
                end++;
            }
            int currLen = end - start + 1;
            if (currLen > maxLen) {
                substart = start + 1;
                subend = end;
                maxLen = currLen;
            }
        }
        return str.substring(substart, subend);
    }

    public static void main(String[] args) {
        String str = "abccbc";
        String palindromeString = longestPalinSubstring(str);
        System.out.println(palindromeString);
    }
}