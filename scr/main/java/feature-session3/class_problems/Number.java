package scr.main.java.feature-session3.class_problems;
import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int origNumber = number;
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum = sum + digit * digit * digit;
            number = number / 10;
        }

        if (sum == origNumber) {
            System.out.println("Is the number " + origNumber
                    + " an Armstrong number? true");
        } else {
            System.out.println("Is the number " + origNumber
                    + " an Armstrong number? false");
        }
    }
}
