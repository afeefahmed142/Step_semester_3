import java.util.*;
import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate calculateRenewalDate();
}

class Basic extends Plan {
    Basic(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(30);
    }
}

class Standard extends Plan {
    Standard(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(90);
    }
}

class Premium extends Plan {
    Premium(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate = LocalDate.parse(date);

            Plan plan;

            if (type.equals("BASIC"))
                plan = new Basic(name, startDate);
            else if (type.equals("STANDARD"))
                plan = new Standard(name, startDate);
            else
                plan = new Premium(name, startDate);

            LocalDate renewalDate = plan.calculateRenewalDate();

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}