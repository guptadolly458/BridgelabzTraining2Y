import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            sc.close();
            return;
        }

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));

            do {
                System.out.print("Enter weight in kg: ");
                personData[i][0] = sc.nextDouble();

                if (personData[i][0] <= 0) {
                    System.out.println("Enter a positive weight.");
                }
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter height in meters: ");
                personData[i][1] = sc.nextDouble();

                if (personData[i][1] <= 0) {
                    System.out.println("Enter a positive height.");
                }
            } while (personData[i][1] <= 0);
        }

        for (int i = 0; i < number; i++) {
            double weight = personData[i][0];
            double height = personData[i][1];

            personData[i][2] = weight / (height * height);

            double bmi = personData[i][2];

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }

            System.out.println("\nPerson " + (i + 1));
            System.out.println("Height: " + height + " m");
            System.out.println("Weight: " + weight + " kg");
            System.out.printf("BMI: %.2f%n", bmi);
            System.out.println("Status: " + weightStatus[i]);
        }

        sc.close();
    }
}