
import java.util.Scanner;

abstract class Appliance {
    static final double COST_PER_UNIT = 8.0;
    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * COST_PER_UNIT;
    }
}

interface SaverMode {
    double SAVING = 0.25;

    default double savedUnits(double units) {
        return units * (1 - SAVING);
    }
}

class Fridge extends Appliance {
    Fridge(double h) {
        super(h);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double h) {
        super(h);
    }

    double getPower() {
        return 1500;
    }

    double calculateUnits(boolean saver) {
        double units = calculateUnits();
        return saver ? savedUnits(units) : units;
    }
}

class TV extends Appliance {
    TV(double h) {
        super(h);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double h) {
        super(h);
    }

    double getPower() {
        return 500;
    }

    double calculateUnits(boolean saver) {
        double units = calculateUnits();
        return saver ? savedUnits(units) : units;
    }
}

public class Home{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = sc.hasNext("SAVER");
            if (saver) {
                sc.next();
            }

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge(hours);
                    break;
                case "AC":
                    a = new AC(hours);
                    break;
                case "TV":
                    a = new TV(hours);
                    break;
                case "WASHER":
                    a = new Washer(hours);
                    break;
                default:
                    continue;
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = a.calculateUnits();

            if (saver) {
                units = ((SaverMode) a).savedUnits(units);
            }

            double cost = units * Appliance.COST_PER_UNIT;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
