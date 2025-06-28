package basic;
import java.util.ArrayList;
import java.util.Iterator;
public class StudentList {
    public static void main(String[] args) {
        // Create an ArrayList to store student names
        ArrayList<String> students = new ArrayList<>();

        // Add student names
        students.add("Nisha");
        students.add("Dhanu");
        students.add("Madhu");
        students.add("Reji");
        // Create an iterator to loop through the list
        Iterator<String> iterator = students.iterator();

        System.out.println("List of Students:");
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
