class Student {
    // Private data members (Access Specifier)
    private String name;
    private int rollNo;
    private int[] marks = new int[5];

    // Constructor
    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Method to calculate average
    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / 5.0;
    }

    // Method to assign grade
    public char getGrade() {
        double avg = calculateAverage();

        if (avg >= 75)
            return 'A';
        else if (avg >= 50)
            return 'B';
        else
            return 'C';
    }

    // Method to display student details
    public void display() {
        System.out.println("Name     : " + name);
        System.out.println("Roll No  : " + rollNo);
        System.out.print("Marks    : ");
        for (int m : marks)
            System.out.print(m + " ");
        System.out.println("\nAverage  : " + calculateAverage());
        System.out.println("Grade    : " + getGrade());
        System.out.println("---------------------------");
    }
}

public class lab1 {
    public static void main(String[] args) {

        // Data for 5 students
        Student s1 = new Student("Aarav", 1, new int[]{78, 85, 90, 88, 76});
        Student s2 = new Student("Diya", 2, new int[]{65, 70, 60, 72, 68});
        Student s3 = new Student("Rohan", 3, new int[]{45, 50, 40, 55, 48});
        Student s4 = new Student("Meera", 4, new int[]{92, 89, 95, 91, 94});
        Student s5 = new Student("Kabir", 5, new int[]{58, 62, 55, 60, 59});

        // Display details
        s1.display();
        s2.display();
        s3.display();
        s4.display();
        s5.display();
    }
}
