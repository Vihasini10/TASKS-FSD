package basic;

import java.util.*;

public class StudentMarksInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, List<Integer>> studentMarks = new HashMap<>();

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int numSubjects = sc.nextInt();

            List<Integer> marks = new ArrayList<>();
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter mark " + (j + 1) + ": ");
                marks.add(sc.nextInt());
            }
            sc.nextLine(); // consume newline
            studentMarks.put(name, marks);
        }

        // Display each student’s average
        System.out.println("\nStudent Averages:");
        for (Map.Entry<String, List<Integer>> entry : studentMarks.entrySet()) {
            String name = entry.getKey();
            List<Integer> marks = entry.getValue();

            int total = 0;
            for (int m : marks) total += m;

            double average = (double) total / marks.size();
            System.out.printf("%s → Average: %.2f%n", name, average);
        }

        sc.close();
    }
}
