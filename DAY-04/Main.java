package basic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Add \n2.View \n3.Update \n4.Delete \n5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Dept: ");
                    String dept = sc.nextLine();
                    EmployeeManager.addEmployee(new Employee(id, name, dept));
                    break;

                case 2:
                    for (Employee e : EmployeeManager.getAll()) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    System.out.print("ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Dept: ");
                    String newDept = sc.nextLine();
                    EmployeeManager.updateEmployee(uid, new Employee(uid, newName, newDept));
                    break;

                case 4:
                    System.out.print("ID to delete: ");
                    int did = sc.nextInt();
                    EmployeeManager.deleteEmployee(did);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }
}
