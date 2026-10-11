package PracticeProblems;
import java.util.*;

public class SimpleInterest {
            Scanner sc = new Scanner(System.in);

            double principal = sc.nextDouble();
            double rate = sc.nextDouble();
            double time = sc.nextDouble();

            double si = (principal * rate * time) / 100;

            System.out.println(si);
        }
    }
