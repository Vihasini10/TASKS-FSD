package basic;
import java.util.*;
import java.io.*;

public class StudentManagementApp {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<Integer, List<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println("\n--- Student Management Menu ---");
            System.out.println("1. Add Student and Courses");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Delete Student");
            System.out.println("4. Save Courses to File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> deleteStudent();
                case 4 -> saveToFile();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter student ID (integer): ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        studentNames.add(name);

        System.out.print("How many courses? ");
        int count = sc.nextInt();
        sc.nextLine();

        List<String> courses = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter course " + i + ": ");
            courses.add(sc.nextLine());
        }
        studentCourses.put(id, courses);
        System.out.println("Student and courses added successfully.");
    }

    public static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            System.out.println("Courses for Student ID " + id + ": " + studentCourses.get(id));
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentCourses.containsKey(id)) {
            studentCourses.remove(id);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void saveToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("courses.txt"));
        for (Map.Entry<Integer, List<String>> entry : studentCourses.entrySet()) {
            writer.write("Student ID: " + entry.getKey() + " → Courses: " + entry.getValue());
            writer.newLine();
        }
        writer.close();
        System.out.println("Course list saved to courses.txt");
    }
}

