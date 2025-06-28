package basic;
import java.sql.*;

public class StudentDB {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb", "root", "Vihasini_10");

            System.out.println("Connection successful!");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
