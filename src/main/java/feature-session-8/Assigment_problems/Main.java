import java.util.*;

abstract class Customer {
    protected double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateAmount() {
        return amount + 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer customer;

            if (type.equals("STUDENT"))
                customer = new Student(amount);
            else if (type.equals("STAFF"))
                customer = new Staff(amount);
            else
                customer = new Guest(amount);

            double finalAmount = customer.calculateAmount();

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}