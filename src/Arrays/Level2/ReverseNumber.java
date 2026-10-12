import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(sc.nextLong());

        long temp = number;
        int count = 0;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                count++;
                temp /= 10;
            }
        }

        int[] digits = new int[count];
        int[] reverse = new int[count];

        for (int i = 0; i < count; i++) {
            digits[i] = (int) (number % 10);
            number /= 10;
        }

        for (int i = 0; i < count; i++) {
            reverse[i] = digits[i];
        }

        System.out.print("Reversed Number: ");

        for (int i = 0; i < count; i++) {
            System.out.print(reverse[i]);
        }

        System.out.println();
        sc.close();
    }
}