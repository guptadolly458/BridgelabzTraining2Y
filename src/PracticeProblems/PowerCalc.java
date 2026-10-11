package PracticeProblems;

import java.util.Scanner;

public class PowerCalc {
            Scanner sc = new Scanner(System.in);

            double base = sc.nextDouble();
            double exponent = sc.nextDouble();

            double result = Math.pow(base, exponent);

            System.out.println(result);
        }
    }

