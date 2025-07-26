import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter student grade: ");
            int grade = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            students.add(new Student(name, grade));
        }

        // Calculate average, highest, lowest
        int sum = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (Student s : students) {
            int grade = s.getGrade();
            sum += grade;

            if (grade > highest) {
                highest = grade;
            }

            if (grade < lowest) {
                lowest = grade;
            }
        }

        double average = (double) sum / students.size();

        System.out.println("\n=== Summary Report ===");
        System.out.printf("Average Score: %.2f\n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("\nStudent Details:");
        for (Student s : students) {
            System.out.println("Name: " + s.getName() + ", Grade: " + s.getGrade());
        }

        sc.close();
    }
}
 
