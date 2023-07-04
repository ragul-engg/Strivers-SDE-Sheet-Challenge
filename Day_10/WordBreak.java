
import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

    public static void findWords(int start, String str, String output, ArrayList<String> result,
            ArrayList<String> dict) {
        if (start >= str.length()) {
            result.add(new String(output.trim()));
            return;
        }
        for (int idx = start; idx < str.length(); idx++) {
            String word = str.substring(start, idx + 1);
            if (dict.contains(word)) {
                findWords(idx + 1, str, output + word + " ", result, dict);
            }
        }
    }

    public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
        ArrayList<String> result = new ArrayList<>();
        findWords(0, s, "", result, dictionary);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> dict = new ArrayList<>();
        dict.addAll(Arrays.asList("hot", "box", "hotbox"));
        ArrayList<String> result = wordBreak("hotboxhotbox", dict);
        System.out.println(result);
    }
}
