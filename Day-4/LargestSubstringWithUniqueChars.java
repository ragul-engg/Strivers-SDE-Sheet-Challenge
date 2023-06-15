
public class LargestSubstringWithUniqueChars {
    public static int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128];
        int start = 0, end = 0;
        int maxLen = 0;
        int len = s.length();
        while (end < len) {
            char ch = s.charAt(end);
            freq[ch]++;
            if (freq[ch] == 2) {
                int currLen = end - start;
                maxLen = Math.max(maxLen, currLen);
                while (freq[ch] > 1 && start < end) {
                    freq[s.charAt(start++)]--;
                }
            }
            end++;
        }
        maxLen = Math.max(maxLen, end - start);
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out
                .println("The Length of the longest substring with unique Characters " + lengthOfLongestSubstring(str));
    }
}
