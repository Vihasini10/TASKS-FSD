package basic;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private int[] marks = new int[3]; // marks for 3 subjects
    private int total;
    private double average;

    // Method to input student details
    public void inputDetails(Scanner scanner) {
        System.out.print("Enter student name: ");
        name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        rollNumber = scanner.nextInt();

        // Input marks for 3 subjects
        total = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }
        average = total / 3.0;
        scanner.nextLine(); // consume leftover newline
    }

    // Method to display student result
    public void displayResult() {
        System.out.println("\n--- Student Result ---");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks       : ");
        for (int i = 0; i < 3; i++) {
            System.out.println("  Subject " + (i + 1) + ": " + marks[i]);
        }
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + String.format("%.2f", average));
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Student object
        Student student = new Student();

        // Get input from user
        student.inputDetails(scanner);

        // Display result
        student.displayResult();

        scanner.close();
    }
}

