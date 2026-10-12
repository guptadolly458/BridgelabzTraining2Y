import java.util.Scanner;

public class NumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] arr = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            if (index == 10) {
                break;
            }

            double num = sc.nextDouble();

            if (num <= 0) {
                break;
            }

            arr[index] = num;
            index++;
        }

        System.out.println("Numbers:");

        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
            total = total + arr[i];
        }

        System.out.println("Total = " + total);
    }
}