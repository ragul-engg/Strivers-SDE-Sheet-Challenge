package string_ii;

public class MinimumCharsForPalindrome {

    public static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int minCharsforPalindrome(String str) {
        int right = str.length();
        while (right > 0 && !isPalindrome(str, 0, right - 1)) {
            right--;
        }
        return str.length() - right;
    }

    public static void main(String[] args) {
        String str = "aabaaca";
        System.out.println(minCharsforPalindrome(str));
    }
}