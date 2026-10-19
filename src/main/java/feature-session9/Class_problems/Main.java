
import java.util.Scanner;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    String getShape() {
        return "";
    }
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();

            Plot p;

            switch (shape) {
                case "CIRCLE":
                    p = new Circle(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    p = new Rectangle(owner, sc.nextDouble(),
                                      sc.nextDouble());
                    break;
                case "TRIANGLE":
                    p = new Triangle(owner, sc.nextDouble(),
                                     sc.nextDouble());
                    break;
                default:
                    continue;
            }

            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                              owner, p.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}
