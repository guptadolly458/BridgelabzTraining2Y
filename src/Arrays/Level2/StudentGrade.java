import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        int[][] marks = new int[number][3];
        double[] percentage = new double[number];
        String[] grade = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Student " + (i + 1));

            for (int j = 0; j < 3; j++) {
                String subject;

                if (j == 0) {
                    subject = "Physics";
                } else if (j == 1) {
                    subject = "Chemistry";
                } else {
                    subject = "Maths";
                }

                do {
                    System.out.print("Enter " + subject + " marks (0-100): ");
                    marks[i][j] = sc.nextInt();

                    if (marks[i][j] < 0 || marks[i][j] > 100) {
                        System.out.println("Invalid marks. Enter 0 to 100.");
                    }
                } while (marks[i][j] < 0 || marks[i][j] > 100);
            }
        }

        for (int i = 0; i < number; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];

            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = "A";
            } else if (percentage[i] >= 80) {
                grade[i] = "B";
            } else if (percentage[i] >= 70) {
                grade[i] = "C";
            } else if (percentage[i] >= 60) {
                grade[i] = "D";
            } else if (percentage[i] >= 40) {
                grade[i] = "E";
            } else {
                grade[i] = "F";
            }

            System.out.println("\nStudent " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f%%%n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
        }

        sc.close();
    }
}