import java.util.Scanner;

public class PalindromeCheck {

    public static boolean palindromeLoop(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean palindromeRecursive(
            String text, int start, int end) {

        if (start >= end) {
            return true;
        }

        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }

        return palindromeRecursive(text, start + 1, end - 1);
    }
    public static char[] reverseString(String text) {
        char[] reverse = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reverse[i] = text.charAt(text.length() - 1 - i);
        }

        return reverse;
    }


    public static boolean palindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reverse = reverseString(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        System.out.println("Using loop: " + palindromeLoop(text));

        System.out.println("Using recursion: " +
                palindromeRecursive(text, 0, text.length() - 1));

        System.out.println("Using arrays: " + palindromeArray(text));

        sc.close();
    }
}