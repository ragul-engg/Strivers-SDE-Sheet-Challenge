import java.util.ArrayList;
import java.util.List;

public class PrintPermutations {
    private static void swap(int left, int right, char[] str) {
        char ch = str[left];
        str[left] = str[right];
        str[right] = ch;
    }

    private static void doPermutations(int start, int end, char[] str, List<String> result) {
        if (start == end) {
            result.add(new String(str));
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(start, i, str);
            doPermutations(start + 1, end, str, result);
            swap(start, i, str);
        }
    }

    public static List<String> findPermutations(String s) {
        List<String> result = new ArrayList<>();
        doPermutations(0, s.length() - 1, s.toCharArray(), result);
        return result;
    }

    public static void main(String[] args) {
        List<String> permutations = findPermutations("abc");
        System.out.println(permutations);
    }
}
