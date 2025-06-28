package basic;
import java.io.*;
import java.util.*;

public class ResultProcessor {
    public static void main(String[] args) {
        String inputFile = "D:\\JAVA\\FSD\\marks.txt";
        String outputFile = "results.txt";

        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                
                String name = parts[0];
                int total = 0;

                for (int i = 1; i < parts.length; i++) {
                    total += Integer.parseInt(parts[i]);
                }

                double average = total / (parts.length - 1.0);
                writer.printf("%s Total: %d Average: %.2f%n", name, total, average);
            }

            System.out.println("Result file created successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
