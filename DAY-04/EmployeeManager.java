package basic;

import java.io.*;
import java.util.*;

public class EmployeeManager {
    static final String FILE_NAME = "employees.txt";

    public static void addEmployee(Employee emp) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(emp.toString() + "\n");
        fw.close();
    }

    public static List<Employee> getAll() throws IOException {
        List<Employee> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = br.readLine()) != null) {
            list.add(Employee.fromString(line));
        }
        br.close();
        return list;
    }

    public static void updateEmployee(int id, Employee newEmp) throws IOException {
        List<Employee> list = getAll();
        FileWriter fw = new FileWriter(FILE_NAME);
        for (Employee e : list) {
            if (e.id == id) {
                fw.write(newEmp.toString() + "\n");
            } else {
                fw.write(e.toString() + "\n");
            }
        }
        fw.close();
    }

    public static void deleteEmployee(int id) throws IOException {
        List<Employee> list = getAll();
        FileWriter fw = new FileWriter(FILE_NAME);
        for (Employee e : list) {
            if (e.id != id) {
                fw.write(e.toString() + "\n");
            }
        }
        fw.close();
    }
}
