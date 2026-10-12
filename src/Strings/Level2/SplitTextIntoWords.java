import java.util.Scanner;

public class SplitTextIntoWords {

    public static int findLength(String text) {
        int count = 0;

        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }

        return count;
    }

    public static String[] splitWords(String text) {
        int length = findLength(text);
        int wordCount = 0;

        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        int[] spaces = new int[wordCount + 1];
        String[] words = new String[wordCount];

        int index = 0;
        spaces[index++] = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                if (i + 1 < length && text.charAt(i + 1) != ' ') {
                    spaces[index++] = i + 1;
                }
            }
        }

        for (int i = 0; i < wordCount; i++) {
            int start = spaces[i];
            int end = start;

            while (end < length && text.charAt(end) != ' ') {
                end++;
            }

            String word = "";

            for (int j = start; j < end; j++) {
                word += text.charAt(j);
            }

            words[i] = word;
        }

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] result1 = splitWords(text);
        String[] result2 = text.trim().isEmpty()
                ? new String[0] : text.trim().split("\\s+");

        System.out.println("User-defined split:");

        for (String word : result1) {
            System.out.println(word);
        }

        System.out.println("Built-in split:");

        for (String word : result2) {
            System.out.println(word);
        }

        System.out.println("Both results are same: " +
                compareArrays(result1, result2));

        sc.close();
    }
}