package basic;

public class Overloading {

	
		// TODO Auto-generated method stub
	

		    // Method to add two integers
		    public int sum(int a, int b) {
		        return a + b;
		    }

		    // Method to add two doubles
		    public double sum(double a, double b) {
		        return a + b;
		    }

		    public static void main(String[] args) {
		        Overloading example = new Overloading();

		        int intResult = example.sum(5, 10);
		        double doubleResult = example.sum(3.5, 2.8);

		        System.out.println("Sum of integers: " + intResult);
		        System.out.println("Sum of doubles: " + doubleResult);
		    }
		

	}

