package basic;
import java.sql.*;
import java.util.Scanner;

public class StudentManager {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "Vihasini_10";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to studentdb!");

            while (true) {
                System.out.println("\n1. Insert Student\n2. View Students\n3. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();

                    String insertSQL = "INSERT INTO students VALUES (?, ?, ?)";
                    PreparedStatement ps = con.prepareStatement(insertSQL);
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, age);
                    ps.executeUpdate();
                    System.out.println("Student inserted!");

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM students");
                    System.out.println("Student Records:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getInt("age"));
                    }

                } else if (choice == 3) {
                    System.out.println("Goodbye!");
                    break;

                } else {
                    System.out.println("Invalid option!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

