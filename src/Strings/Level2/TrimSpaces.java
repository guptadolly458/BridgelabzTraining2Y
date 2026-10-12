import java.util.Scanner;

public class TrimSpaces {

    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = text.length();

        while (start < end && text.charAt(start) == ' ') {
            start++;
        }

        while (end > start && text.charAt(end - 1) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String getSubstring(String text, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text with leading and trailing spaces: ");
        String text = sc.nextLine();

        int[] indexes = findTrimIndexes(text);

        String result1 = getSubstring(text, indexes[0], indexes[1]);
        String result2 = text.trim();

        System.out.println("Using charAt(): [" + result1 + "]");
        System.out.println("Using trim(): [" + result2 + "]");
        System.out.println("Both results are same: " +
                compare(result1, result2));

        sc.close();
    }
}