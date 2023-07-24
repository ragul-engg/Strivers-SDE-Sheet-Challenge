package string_ii;

public class CompareVersionNumber {
    public static int compareVersions(String a, String b) {
        int i = 0, j = 0;
        int n = a.length(), m = b.length();
        while (i < n || j < m) {
            long num1 = 0;
            long num2 = 0;
            while (i < n && a.charAt(i) != '.') {
                num1 = (num1 * 10) + (a.charAt(i) - '0');
                i++;
            }
            while (j < m && b.charAt(j) != '.') {
                num2 = (num2 * 10) + (b.charAt(j) - '0');
                j++;
            }
            if (num1 < num2) {
                return -1;
            } else if (num2 < num1) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String a = "1.23.45";
        String b = "1.23.456";
        System.out.println(compareVersions(a, b));
    }
}
