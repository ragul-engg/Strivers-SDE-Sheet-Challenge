public class ReverseWords {
    public static String reverseWords(String str) {

        StringBuilder result = new StringBuilder();
        int idx = str.length() - 1;
        while (idx >= 0) {
            StringBuilder word = new StringBuilder();
            while (idx >= 0 && str.charAt(idx) == ' ') {
                idx--;
            }
            while (idx >= 0 && str.charAt(idx) != ' ') {
                word.append(str.charAt(idx));
                idx--;
            }
            if (word.length() > 0) {
                result.append(word.reverse() + " ");
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String str = "a  good     example   ";
        System.out.println(reverseWords(str));
    }
}
