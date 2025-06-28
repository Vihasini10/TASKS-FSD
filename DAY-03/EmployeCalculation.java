package basic;
import java.util.Scanner;

				// Person class (base)
		class Person {
		    protected String name;
		    protected int age;

		    public void inputPersonDetails(Scanner scanner) {
		        System.out.print("Enter name: ");
		        name = scanner.nextLine();

		        System.out.print("Enter age: ");
		        age = scanner.nextInt();
		        scanner.nextLine(); // consume newline
		    }

		    public void displayPersonDetails() {
		        System.out.println("Name: " + name);
		        System.out.println("Age : " + age);
		    }
		}

		// Employee class (inherits Person)
		class Employee extends Person {
		    private String employeeId;
		    private double basicSalary;
		    private double hra; // House Rent Allowance
		    private double da;  // Dearness Allowance
		    private double grossSalary;

		    public void inputEmployeeDetails(Scanner scanner) {
		        inputPersonDetails(scanner); // get name and age

		        System.out.print("Enter Employee ID: ");
		        employeeId = scanner.nextLine();

		        System.out.print("Enter Basic Salary: ");
		        basicSalary = scanner.nextDouble();

		        calculateSalary(); // automatically calculate
		    }

		    public void calculateSalary() {
		        hra = 0.2 * basicSalary; // 20% HRA
		        da = 0.1 * basicSalary;  // 10% DA
		        grossSalary = basicSalary + hra + da;
		    }

		    public void displayEmployeeDetails() {
		        displayPersonDetails();
		        System.out.println("Employee ID   : " + employeeId);
		        System.out.println("Basic Salary  : " + basicSalary);
		        System.out.println("HRA (20%)     : " + hra);
		        System.out.println("DA (10%)      : " + da);
		        System.out.println("Gross Salary  : " + grossSalary);
		    }
		}

		// Main class
		public class EmployeCalculation {
		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);//input get scanner

		        Employee emp = new Employee();
		        emp.inputEmployeeDetails(scanner);
		        System.out.println("\n--- Employee Details ---");
		        emp.displayEmployeeDetails();

		        scanner.close();
		    }
		

	}
		//Inherits using employee extends person 


