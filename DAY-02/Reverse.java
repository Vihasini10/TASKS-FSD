package basic;
import java.util.Scanner;
public class Reverse {
	 public static void main(String[] args) {
	        Scanner RA = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = RA.nextLine();

	        String reversed = "";
	        for (int i = input.length() - 1; i >= 0; i--) {
	            reversed += input.charAt(i);
	        }

	        System.out.println("Reversed string: " + reversed);

	       RA.close();
	    }
}

	