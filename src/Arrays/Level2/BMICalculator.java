import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            sc.close();
            return;
        }

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            do {
                System.out.print("Enter weight in kg: ");
                weight[i] = sc.nextDouble();

                if (weight[i] <= 0) {
                    System.out.println("Enter a positive weight.");
                }
            } while (weight[i] <= 0);

            do {
                System.out.print("Enter height in meters: ");
                height[i] = sc.nextDouble();

                if (height[i] <= 0) {
                    System.out.println("Enter a positive height.");
                }
            } while (height[i] <= 0);
        }

        for (int i = 0; i < number; i++) {
            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }

            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + height[i] + " m");
            System.out.println("Weight: " + weight[i] + " kg");
            System.out.printf("BMI: %.2f%n", bmi[i]);
            System.out.println("Status: " + status[i]);
        }

        sc.close();
    }
}