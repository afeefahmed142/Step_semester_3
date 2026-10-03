import java.util.*;

abstract class Employee {
    protected String name;
    protected double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class FullTime extends Employee {
    FullTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class PartTime extends Employee {
    PartTime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalBonus = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            Employee employee;

            if (type.equals("FULLTIME"))
                employee = new FullTime(name, salary);
            else if (type.equals("PARTTIME"))
                employee = new PartTime(name, salary);
            else
                employee = new Intern(name, salary);

            double bonus = employee.calculateBonus();

            System.out.printf("%s: %.2f%n", name, bonus);
            totalBonus += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        sc.close();
    }
}