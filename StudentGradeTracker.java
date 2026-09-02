import java.util.ArrayList;
import java.util.Scanner;

// Step 1: Student class - ek student ka data store karega
class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>(); // Step 2: ArrayList me students store karenge

        System.out.print("Kitne students ka data enter karna hai? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        // Step 2 (contd): Har student ka naam aur marks input lena
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Student " + i + " ---");
            System.out.print("Naam: ");
            String name = sc.nextLine();
            System.out.print("Marks (0-100): ");
            double marks = Double.parseDouble(sc.nextLine().trim());
            students.add(new Student(name, marks));
        }

        // Step 3: Average, Highest, Lowest nikalna
        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;
        String topper = students.get(0).name;
        String lowestScorer = students.get(0).name;

        for (Student s : students) {
            total += s.marks;
            if (s.marks > highest) {
                highest = s.marks;
                topper = s.name;
            }
            if (s.marks < lowest) {
                lowest = s.marks;
                lowestScorer = s.name;
            }
        }

        double average = total / students.size();

        // Step 4: Summary Report print karna
        System.out.println("\n===== SUMMARY REPORT =====");
        System.out.printf("%-15s %-10s%n", "Name", "Marks");
        System.out.println("---------------------------");
        for (Student s : students) {
            System.out.printf("%-15s %-10.2f%n", s.name, s.marks);
        }
        System.out.println("---------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f (%s)%n", highest, topper);
        System.out.printf("Lowest Marks  : %.2f (%s)%n", lowest, lowestScorer);
        System.out.println("===========================");

        sc.close();
    }
}
