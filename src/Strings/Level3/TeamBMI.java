import java.util.Scanner;

public class TeamBMI {

    public static String getBMIStatus(double weight, double height) {
        double bmi = weight / (height * height);

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static String[][] calculateBMI(double[][] data) {
        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double height = data[i][1] / 100.0;
            double bmi = weight / (height * height);

            result[i][0] = String.valueOf(data[i][1]);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.format("%.2f", bmi);
            result[i][3] = getBMIStatus(weight, height);
        }

        return result;
    }

    public static void display(String[][] data) {
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\tStatus");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" +
                    data[i][1] + "\t\t" +
                    data[i][2] + "\t" +
                    data[i][3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][2];

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1));

            do {
                System.out.print("Enter weight in kg: ");
                persons[i][0] = sc.nextDouble();
            } while (persons[i][0] <= 0);

            do {
                System.out.print("Enter height in cm: ");
                persons[i][1] = sc.nextDouble();
            } while (persons[i][1] <= 0);
        }

        String[][] result = calculateBMI(persons);
        display(result);

        sc.close();
    }
}