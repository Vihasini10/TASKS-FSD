package basic;
import java.util.Scanner;

public class Calculator {

	public static void add(int a, int b) {
		System.out.println("Result:"+(a+b));
		
	}
	public static void sub(int a, int b) {
		System.out.println("Result:"+(a-b));
		
	}
	public static void mul(int a, int b) {
		System.out.println("Result:"+(a*b));
		
	}
	public static void div(int a, int b) {
		System.out.println("Result:"+(a/b));
		
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int option,a,b;
		
		do {
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Multiplication");
			System.out.println("4.Division");
			System.out.println("Invalid option");
			System.out.println("Enter the option:");
			option=scan.nextInt();
			
		if(option>=1 && option<=5) {
		System.out.println("Enter the First Number:");
		 a=scan.nextInt();
		System.out.println("Enter the Second Number:");
		 b=scan.nextInt();
		
		switch(option){
		case 1:
			add(a,b);
			break;
		case 2:
			sub(a,b);
			break;
		case 3:
			mul(a,b);
			break;
		case 4:
			div(a,b);
			break;
		default :
			System.out.println("Invalid");
		
		}
		}
			
		}while(option<=5); {
			System.out.println("Exit");
			
		}
		
	}

}
