package basic;
import java.util.Scanner;

public class InteractiveBankingApp {
    private int balance = 1000;

    // Synchronized withdrawal method
    public synchronized void withdraw(String user, int amount) {
        System.out.println(user + " is attempting to withdraw ₹" + amount);
        if (balance >= amount) {
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println(user + " successfully withdrew ₹" + amount);
        } else {
            System.out.println(user + " - Insufficient funds to withdraw ₹" + amount);
        }
        System.out.println("Balance after transaction: ₹" + balance + " [Handled by: " + user + "]\n");
    }

    public static void main(String[] args) {
        InteractiveBankingApp bank = new InteractiveBankingApp();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of users: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Thread[] users = new Thread[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter user name: ");
            String name = scanner.nextLine();

            System.out.print("Enter amount to withdraw: ");
            int amount = scanner.nextInt();
            scanner.nextLine();

            final String userName = name;
            final int withdrawAmount = amount;

            users[i] = new Thread(() -> bank.withdraw(userName, withdrawAmount), userName);
            users[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < n; i++) {
            try {
                users[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
        System.out.println("Final balance: ₹" + bank.balance);
    }
}

