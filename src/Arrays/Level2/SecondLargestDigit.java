import java.util.Scanner;

public class SecondLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = Math.abs(sc.nextLong());

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        while (number != 0 && index < maxDigit) {
            digits[index] = (int) (number % 10);
            number /= 10;
            index++;
        }

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] < largest &&
                       digits[i] > secondLargest) {
                secondLargest = digits[i];
            }
        }

        if (index == 0) {
            largest = 0;
            secondLargest = -1;
        }

        System.out.println("Largest Digit: " + largest);

        if (secondLargest == -1) {
            System.out.println("Second Largest Distinct Digit Not Found");
        } else {
            System.out.println("Second Largest Digit: " + secondLargest);
        }

        sc.close();
    }
}