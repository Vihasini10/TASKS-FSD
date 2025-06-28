package basic;

public class Employee {
    int id;
    String name;
    String dept;

    public Employee(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public String toString() {
        return id + "," + name + "," + dept;
    }

    public static Employee fromString(String line) {
        String[] parts = line.split(",");
        return new Employee(Integer.parseInt(parts[0]), parts[1], parts[2]);
    }
}

