import java.util.Scanner;

public class ConvertToUppercase {

    public static String convertUppercase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result += ch;
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

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String result1 = convertUppercase(text);
        String result2 = text.toUpperCase();

        System.out.println("User-defined result: " + result1);
        System.out.println("Built-in result: " + result2);
        System.out.println("Both results are same: " +
                compare(result1, result2));

        sc.close();
    }
}