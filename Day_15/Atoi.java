public class Atoi {
    public static int atoi(String str) {
        boolean isNegative = str.charAt(0) == '-' ? true : false;
        int result = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                result = (result * 10) + (ch - '0');
            }
        }
        if (isNegative) {
            result *= -1;
        }
        return result;
    }

    public static void main(String[] args) {
        String num = "23";
        System.out.println(atoi(num));
    }
}
