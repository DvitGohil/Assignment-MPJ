import java.util.Scanner;

// ----------- Constructor & Method Overloading -----------
class Calculator {

    // Default Constructor
    Calculator() {
        System.out.println("Calculator Object Created");
    }

    // Constructor Overloading
    Calculator(double radius) {
        double area = 3.14 * radius * radius;
        System.out.println("Circle Area (Constructor): " + area);
    }

    Calculator(double length, double width) {
        double area = length * width;
        System.out.println("Rectangle Area (Constructor): " + area);
    }

    // Method Overloading
    void findArea(int side) {
        int area = side * side;
        System.out.println("Square Area (Method): " + area);
    }

    void findArea(double radius, boolean circle) {
        double area = 3.14 * radius * radius;
        System.out.println("Circle Area (Method): " + area);
    }
}


// ----------- Inheritance & Runtime Polymorphism -----------
class TouristSpot {

    void specialFeature() {
        System.out.println("Beautiful tourist location");
    }

    void famousFood() {
        System.out.println("Local traditional dish");
    }
}

class Goa extends TouristSpot {

    void specialFeature() {
        System.out.println("Goa is famous for Beaches");
    }

    void famousFood() {
        System.out.println("Goa Famous Food: Fish Curry");
    }
}

class Jaipur extends TouristSpot {

    void specialFeature() {
        System.out.println("Jaipur is famous for Palaces");
    }

    void famousFood() {
        System.out.println("Jaipur Famous Food: Dal Baati");
    }
}

class Darjeeling extends TouristSpot {

    void specialFeature() {
        System.out.println("Darjeeling is famous for Tea Gardens");
    }

    void famousFood() {
        System.out.println("Darjeeling Famous Food: Momos");
    }
}


// ----------- Main Class -----------
public class lab3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Area Calculations ===");

        Calculator c = new Calculator();

        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();

        System.out.print("Enter length and width of rectangle: ");
        double l = sc.nextDouble();
        double w = sc.nextDouble();

        System.out.print("Enter side of square: ");
        int side = sc.nextInt();

        new Calculator(r);
        new Calculator(l, w);

        c.findArea(side);
        c.findArea(r, true);

        System.out.println("\n=== Tourist Places ===");

        TouristSpot t;

        System.out.println("1. Goa");
        System.out.println("2. Jaipur");
        System.out.println("3. Darjeeling");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch(choice) {
            case 1:
                t = new Goa();
                break;
            case 2:
                t = new Jaipur();
                break;
            case 3:
                t = new Darjeeling();
                break;
            default:
                System.out.println("Invalid Choice");
                sc.close();
                return;
        }

        t.specialFeature();
        t.famousFood();

        sc.close();
    }
}
