package basic;
import java.util.HashSet;
import java.util.Scanner;

public class UniqueEmailSet {
    public static void main(String[] args) {
        // Create a HashSet to store unique email addresses
        HashSet<String> emails = new HashSet<>();

        // Scanner to take user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email addresses (type 'done' to finish):");

        while (true) {
            String email = sc.nextLine().trim();
            if (email.equalsIgnoreCase("done")) break;

            if (emails.add(email)) {
                System.out.println("Added: " + email);
            } else {
                System.out.println("Duplicate ignored: " + email);
            }
        }

        // Display all unique email addresses
        System.out.println("\nUnique email addresses:");
        for (String e : emails) {
            System.out.println(e);
        }

        sc.close();
    }
}
