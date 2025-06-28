package basic;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StringLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "D:\\JAVA\\FSD\\Day04\\src\\basic\\user.txt";

        System.out.println("Enter text line by line (type 'exit' to finish):");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            while (true) {
                String input = scanner.nextLine();
                
                // Exit condition
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                writer.write(input);
                writer.newLine(); // Writes a new line
            }

            System.out.println("Your input has been saved to '" + filePath + "'.");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        scanner.close();
    }
}
