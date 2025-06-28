package basic;

import java.util.ArrayList;

public class Library {
    private ArrayList<String> books = new ArrayList<>();
    private ArrayList<String> issuedBooks = new ArrayList<>();

    // Add a book to the library
    public void addBook(String bookName) {
        books.add(bookName);
        System.out.println("\"" + bookName + "\" has been added to the library.");
    }

    // Remove a book from the library
    public void removeBook(String bookName) {
        if (books.remove(bookName)) {
            System.out.println("\"" + bookName + "\" has been removed from the library.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    // Issue (lend) a book
    public void issueBook(String bookName) {
        if (books.contains(bookName)) {
            books.remove(bookName);
            issuedBooks.add(bookName);
            System.out.println("\"" + bookName + "\" has been issued.");
        } else {
            System.out.println("Book not available to issue.");
        }
    }

    // Display available books
    public void showAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No books currently available.");
        } else {
            System.out.println("Available books:");
            for (String book : books) {
                System.out.println("- " + book);
            }
        }
    }

    // Display issued books
    public void showIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books have been issued.");
        } else {
            System.out.println("Issued books:");
            for (String book : issuedBooks) {
                System.out.println("- " + book);
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Library myLibrary = new Library();

        myLibrary.addBook("Java Fundamentals");
        myLibrary.addBook("Data Structures and Algorithms");
        myLibrary.showAvailableBooks();

        myLibrary.issueBook("Java Fundamentals");
        myLibrary.showIssuedBooks();
        myLibrary.showAvailableBooks();

        myLibrary.removeBook("Data Structures and Algorithms");
        myLibrary.showAvailableBooks();
    }
}
