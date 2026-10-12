import java.util.Scanner;

public class StringLength {

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int result1 = findLength(text);
        int result2 = text.length();

        System.out.println("Length using user-defined method: " + result1);
        System.out.println("Length using built-in method: " + result2);

        sc.close();
    }
}