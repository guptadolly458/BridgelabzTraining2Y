import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        if (number < 1) {
            System.out.println("Invalid number");
            return;
        }

        int[] even = new int[number / 2 + 1];
        int[] odd = new int[number / 2 + 1];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.println("Even numbers:");

        for (int i = 0; i < evenIndex; i++) {
            System.out.println(even[i]);
        }

        System.out.println("Odd numbers:");

        for (int i = 0; i < oddIndex; i++) {
            System.out.println(odd[i]);
        }
    }
}