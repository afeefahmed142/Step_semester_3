import java.util.*;

abstract class Transport {
    protected double distance;

    Transport(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();
}

class Bus extends Transport {

    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        double fare = 2 + (0.10 * distance);

        return Math.min(fare, 10);
    }
}

class Train extends Transport {

    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 3 + (0.15 * distance);
    }
}

class Metro extends Transport {
    private double peakHourFactor;

    Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    double calculateFare() {
        return (1.50 + (0.20 * distance))
                * peakHourFactor;
    }
}

public class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            double distance = sc.nextDouble();

            Transport transport;

            if (type.equals("BUS")) {

                transport = new Bus(distance);

            } else if (type.equals("TRAIN")) {

                transport = new Train(distance);

            } else {

                double peakHourFactor = sc.nextDouble();

                transport =
                        new Metro(distance, peakHourFactor);
            }

            double fare = transport.calculateFare();

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}