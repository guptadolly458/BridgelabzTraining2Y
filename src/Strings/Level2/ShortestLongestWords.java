import java.util.Scanner;

public class ShortestLongestWords {

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
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                count++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[count];
        int wordIndex = 0;
        String word = "";

        for (int i = 0; i < length; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else if (!word.isEmpty()) {
                words[wordIndex++] = word;
                word = "";
            }
        }

        if (!word.isEmpty()) {
            words[wordIndex] = word;
        }

        return words;
    }

    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static int[] findShortestLongest(String[][] data) {
        int shortest = 0;
        int longest = 0;

        for (int i = 1; i < data.length; i++) {
            int currentLength = Integer.parseInt(data[i][1]);
            int shortestLength = Integer.parseInt(data[shortest][1]);
            int longestLength = Integer.parseInt(data[longest][1]);

            if (currentLength < shortestLength) {
                shortest = i;
            }

            if (currentLength > longestLength) {
                longest = i;
            }
        }

        return new int[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);

        if (words.length == 0) {
            System.out.println("No words found.");
            sc.close();
            return;
        }

        String[][] data = wordLengths(words);
        int[] result = findShortestLongest(data);

        System.out.println("Shortest word: " + data[result[0]][0]);
        System.out.println("Longest word: " + data[result[1]][0]);

        sc.close();
    }
}