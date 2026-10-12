import java.util.Scanner;

public class AnagramCheck {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] frequency = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i)]++;
            frequency[s2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (frequency[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        if (areAnagrams(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        sc.close();
    }
}