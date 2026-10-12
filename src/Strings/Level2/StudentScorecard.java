import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateScores(int students) {
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            scores[i][0] = (int) (Math.random() * 90) + 10;
            scores[i][1] = (int) (Math.random() * 90) + 10;
            scores[i][2] = (int) (Math.random() * 90) + 10;
        }

        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4];

        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100;

            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return results;
    }

    public static String[][] calculateGrades(double[][] results) {
        String[][] grades = new String[results.length][1];

        for (int i = 0; i < results.length; i++) {
            double percentage = results[i][2];

            if (percentage >= 90) {
                grades[i][0] = "A";
            } else if (percentage >= 80) {
                grades[i][0] = "B";
            } else if (percentage >= 70) {
                grades[i][0] = "C";
            } else if (percentage >= 60) {
                grades[i][0] = "D";
            } else if (percentage >= 40) {
                grades[i][0] = "E";
            } else {
                grades[i][0] = "F";
            }
        }

        return grades;
    }

    public static void displayScorecard(int[][] scores,
                                        double[][] results,
                                        String[][] grades) {
        System.out.println("\nSTUDENT SCORECARD");
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf(
                "%d\t%d\t%d\t\t%d\t%.0f\t%.2f\t%.2f%%\t\t%s%n",
                i + 1,
                scores[i][0],
                scores[i][1],
                scores[i][2],
                results[i][0],
                results[i][1],
                results[i][2],
                grades[i][0]
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        if (students <= 0) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        int[][] scores = generateScores(students);
        double[][] results = calculateResults(scores);
        String[][] grades = calculateGrades(results);

        displayScorecard(scores, results, grades);

        sc.close();
    }
}