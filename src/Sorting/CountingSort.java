import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of students:");
        int n = sc.nextInt();

        int[] ages = new int[n];
        int[] count = new int[9];

        System.out.println("Enter student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();

            if (ages[i] < 10 || ages[i] > 18) {
                System.out.println("Invalid age. Enter an age from 10 to 18.");
                i--;
                continue;
            }

            count[ages[i] - 10]++;
        }

        // Calculate cumulative frequencies
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] output = new int[n];

        // Place elements in their correct positions
        for (int i = n - 1; i >= 0; i--) {
            int index = ages[i] - 10;
            output[count[index] - 1] = ages[i];
            count[index]--;
        }

        System.out.println("Sorted student ages:");
        for (int i = 0; i < n; i++) {
            System.out.print(output[i] + " ");
        }

        sc.close();
    }
}