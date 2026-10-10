
import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50.0;
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double calculateTotal() {
        return calculateFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 2;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double calculateFare() {
        return 2500 + distance * 4;
    }
}

public class Booking{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next().toUpperCase();
            double distance = sc.nextDouble();

            Travel t;

            switch (mode) {
                case "BUS":
                    t = new Bus(distance);
                    break;
                case "TRAIN":
                    t = new Train(distance);
                    break;
                case "FLIGHT":
                    t = new Flight(distance);
                    break;
                default:
                    continue;
            }

            System.out.printf("%s: %.2f%n",
                              mode, t.calculateTotal());
        }

        sc.close();
    }
}
