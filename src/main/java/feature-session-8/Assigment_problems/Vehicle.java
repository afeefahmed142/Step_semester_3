import java.util.*;

abstract class Vehicle {
    protected int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        double charge = hours * 50;
        return Math.max(charge, 100);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            if (type.equals("BIKE"))
                vehicle = new Bike(hours);
            else if (type.equals("CAR"))
                vehicle = new Car(hours);
            else
                vehicle = new Truck(hours);

            double charge = vehicle.calculateCharge();

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}