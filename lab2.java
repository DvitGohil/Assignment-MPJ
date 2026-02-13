// Base Class
class Employee {
    protected String name;
    protected double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display salary
    void displaySalary() {
        System.out.println("Employee Name : " + name);
        System.out.println("Salary        : " + salary);
    }
}

// Derived Class 1
class FullTimeEmployee extends Employee {

    FullTimeEmployee(String name, double salary) {
        super(name, salary);
    }

    // Method to calculate salary with 50% hike
    void calculateSalary() {
        System.out.println("\nFull Time Employee");
        System.out.println("Before Hike Salary : " + salary);
        salary = salary + (salary * 0.50);
        System.out.println("After Hike Salary  : " + salary);
    }
}

// Derived Class 2
class InternEmployee extends Employee {

    InternEmployee(String name, double salary) {
        super(name, salary);
    }

    // Method to calculate salary with 25% hike
    void calculateSalary() {
        System.out.println("\nIntern Employee");
        System.out.println("Before Hike Salary : " + salary);
        salary = salary + (salary * 0.25);
        System.out.println("After Hike Salary  : " + salary);
    }
}

// Main Class
public class  lab2 {
    public static void main(String[] args) {

        FullTimeEmployee f1 = new FullTimeEmployee("Rahul", 40000);
        InternEmployee i1 = new InternEmployee("Anita", 15000);

        // Display original salary
        f1.displaySalary();
        f1.calculateSalary();

        System.out.println("--------------------------");

        i1.displaySalary();
        i1.calculateSalary();
    }
}
