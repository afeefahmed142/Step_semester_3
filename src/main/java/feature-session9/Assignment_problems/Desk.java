
import java.util.Scanner;

abstract class Parcel {
    double weight;
    double value;

    Parcel(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

interface Insurable {
    double INSURANCE_RATE = 0.02;

    double calculateInsurance();
}

class Standard extends Parcel {
    Standard(double w, double v) {
        super(w, v);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class Express extends Parcel implements Insurable {
    Express(double w, double v) {
        super(w, v);
    }

    public double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return value * INSURANCE_RATE;
    }
}

class Fragile extends Parcel implements Insurable {
    Fragile(double w, double v) {
        super(w, v);
    }

    public double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return value * INSURANCE_RATE;
    }
}

public class Desk{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    p = new Express(weight, value);
                    break;
                case "FRAGILE":
                    p = new Fragile(weight, value);
                    break;
                default:
                    continue;
            }

            double charge = p.calculateCharge();
            double insurance = p.calculateInsurance();
            double total = charge + insurance;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
