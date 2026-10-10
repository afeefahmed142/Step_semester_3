
import java.util.Scanner;

abstract class Student {
    String name;
    static final double TUITION = 40000;
    static final double TRANSPORT = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        return calculateFee() + (usesBus() ? TRANSPORT : 0);
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION + 60000;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateFee() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class Fee{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    s = new Scholar(name);
                    break;
                default:
                    continue;
            }

            double fee = s.getTotalFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
