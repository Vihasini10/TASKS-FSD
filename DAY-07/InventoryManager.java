package basic;
import java.sql.*;
import java.util.Scanner;

public class InventoryManager {

    static final String URL = "jdbc:mysql://localhost:3306/inventorydb";
    static final String USER = "root";
    static final String PASSWORD = "Vihasini_10";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to inventorydb!");

            while (true) {
                System.out.println("\n1. Add Product\n2. View Products\n3. Search Product\n4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    PreparedStatement ps = con.prepareStatement("INSERT INTO products VALUES (?, ?, ?)");
                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setDouble(3, price);
                    ps.executeUpdate();
                    System.out.println("Product added!");

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM products");
                    System.out.println("Product List:");
                    while (rs.next()) {
                        System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | ₹" + rs.getDouble("price"));
                    }

                } else if (choice == 3) {
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter product name to search: ");
                    String keyword = scanner.nextLine();
                    PreparedStatement ps = con.prepareStatement("SELECT * FROM products WHERE name LIKE ?");
                    ps.setString(1, "%" + keyword + "%");
                    ResultSet rs = ps.executeQuery();
                    boolean found = false;
                    while (rs.next()) {
                        found = true;
                        System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | ₹" + rs.getDouble("price"));
                    }
                    if (!found) System.out.println("No products found with that name.");

                } else if (choice == 4) {
                    System.out.println("Exiting. Bye!");
                    break;

                } else {
                    System.out.println("Invalid choice. Try again!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
