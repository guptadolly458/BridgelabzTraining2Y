import java.util.Scanner;

public class StringToCharArray {

    public static char[] getCharacters(String text) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }

        return result;
    }

    public static boolean compareArrays(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] result1 = getCharacters(text);
        char[] result2 = text.toCharArray();

        System.out.println("Using user-defined method:");

        for (char ch : result1) {
            System.out.print(ch + " ");
        }

        System.out.println("\nUsing toCharArray():");

        for (char ch : result2) {
            System.out.print(ch + " ");
        }

        System.out.println("\nBoth arrays are same: " +
                compareArrays(result1, result2));

        sc.close();
    }
}