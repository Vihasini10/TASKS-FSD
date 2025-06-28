package basic;
import java.util.Scanner;


public class StudentMark {
	public static void main(String args[]) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println(" Student MarkSheet:");
		System.out.println("Enter The Tamil Mark:");
		int Tamil=scanner.nextInt();		
		System.out.println("Enter The English Mark:");
		int English=scanner.nextInt();
		System.out.println("Enter The Maths Mark:");
		int Maths=scanner.nextInt();
		System.out.println("Enter The Science Mark:");
		int Science=scanner.nextInt();
		System.out.println("Enter The Social Science Mark:");
		int SS=scanner.nextInt();
		
		int totalmarks=Tamil+English+Maths+Science+SS;
		float percentage=(totalmarks/5.0f);
		
		  System.out.println("total Marks: " + totalmarks);
	        System.out.println("Percentage: " + percentage + "%");
	        
	        String grade;
	        if (percentage >= 90) {
	            grade = "A";
	        } else if (percentage >= 80) {
	            grade = "B";
	        } else if (percentage >= 70) {
	            grade = "C";
	        } else if (percentage >= 60) {
	            grade = "D";
	        } else if (percentage >= 40) {
	            grade = "E";
	        } else {
	            grade = "F";
	        }

	       
	        System.out.println("Grade: " + grade);
	    }
	
	        
	}

