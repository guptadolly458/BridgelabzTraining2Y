package PracticeProblems;

import java.util.Scanner;

public class CelsiustoFarenheit {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            double celsius = sc.nextDouble();
            double fahrenheit = (celsius * 9.0 / 5) + 32;

            System.out.println(fahrenheit);
        }
    }
