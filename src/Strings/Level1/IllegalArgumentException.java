import java.util.Scanner;

public class IllegalArgumentException {

    public static void generateException(String text) {
        System.out.println(text.substring(4, 2));
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(4, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with at least 5 characters: ");
        String text = sc.next();

        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception generated and caught in main");
        }

        if (text.length() >= 5) {
            handleException(text);
        } else {
            System.out.println("Enter at least 5 characters.");
        }

        sc.close();
    }
}