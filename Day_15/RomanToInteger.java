import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static int romanToInt(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        hash.put('I', 1);
        hash.put('V', 5);
        hash.put('X', 10);
        hash.put('L', 50);
        hash.put('C', 100);
        hash.put('D', 500);
        hash.put('M', 1000);
        char prevChar = s.charAt(0);
        int sumVal = 0;
        for (char ch : s.toCharArray()) {
            if (hash.get(prevChar) < hash.get(ch)) {
                sumVal += hash.get(ch) - 2 * hash.get(prevChar);
            } else {
                sumVal += hash.get(ch);
            }
            prevChar = ch;
        }
        return sumVal;
    }

    public static void main(String[] args) {
        String roman = "XII";
        System.out.println(romanToInt(roman));
    }
}
