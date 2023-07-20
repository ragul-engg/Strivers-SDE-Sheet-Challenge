package string_ii;

public class CheckAnagrams {
    public static boolean areAnagram(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 != len2) {
            return false;
        }
        int[] ascii = new int[128];
        for (char ch : str1.toCharArray()) {
            ascii[ch]++;
        }
        for (char ch : str2.toCharArray()) {
            ascii[ch]--;
            if (ascii[ch] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen", str2 = "silent";
        System.out.println(areAnagram(str1, str2));
    }
}
