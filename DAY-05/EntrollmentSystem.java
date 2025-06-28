package basic;

import java.util.*;

public class EntrollmentSystem {
    static ArrayList<String> students = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Student with Courses");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: removeStudent(); break;
                case 3: displayAll(); break;
                case 4: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        if (students.contains(name)) {
            System.out.println("Student already exists.");
            return;
        }

        students.add(name);
        ArrayList<String> courses = new ArrayList<>();
        System.out.print("How many courses to enroll? ");
        int count = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter course " + i + ": ");
            courses.add(sc.nextLine());
        }
        studentCourses.put(name, courses);
        System.out.println("Student added with courses.");
    }

    public static void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = sc.nextLine();
        if (students.remove(name)) {
            studentCourses.remove(name);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        Iterator<String> studentIt = students.iterator();
        while (studentIt.hasNext()) {
            String student = studentIt.next();
            System.out.println("Student: " + student);
            ArrayList<String> courses = studentCourses.get(student);
            Iterator<String> courseIt = courses.iterator();
            while (courseIt.hasNext()) {
                System.out.println("  Course: " + courseIt.next());
            }
        }
    }
}
