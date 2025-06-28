package basic;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideByZero{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter denominator: ");
            int denominator = scanner.nextInt();
            double result = safeDivision(numerator, denominator);//safeDivision method encapsulates the division logic and exception handlin., 
            System.out.println("Result: " + result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double safeDivision(int numerator, int denominator) {
        if (denominator == 0) throw new ArithmeticException("Cannot divide by zero.");
        return (double) numerator / denominator;
    }
}

