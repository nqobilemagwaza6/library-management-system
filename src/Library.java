import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books;
    private Scanner scanner;

    public Library() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addBook() {
        // This function is responsible for adding books
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Book added successfully!");
    }

    public void searchBookByTitle() {
        // This function is responsible for searching books in the library by title
        System.out.print("Enter book title to search: ");
        String title = scanner.nextLine();
        Book foundBook = null;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                foundBook = book;
                break;
            }
        }
        if (foundBook != null) {
            System.out.println("These are books we have found: " + foundBook);
        } else {
            System.out.println("Sorry! There are no books found.");
        }
    }

    public void booksCounter() {
        // This function is responsible for counting books
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void displayAndDeleteBooks() {
        // This function is responsible for displaying and deleting unwanted books
        if (books.isEmpty()) {
            System.out.println("There are no books to display.");
        } else {
            System.out.println("These are all books in the library:");
            booksCounter();
            System.out.print("Enter the number of the book to delete (or 0 to cancel): ");
            int deleteChoice = 0;
            try {
                deleteChoice = scanner.nextInt();
                scanner.nextLine();  //newline
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();  // Clear invalid input
                return;
            }

            if (deleteChoice == 0) {
                System.out.println("Delete operation cancelled.");
            } else if (deleteChoice > 0 && deleteChoice <= books.size()) {
                books.remove(deleteChoice - 1);
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Invalid book number. Please try again.");
            }
        }
    }

    public void exitSystem() {
        // This function is responsible for exiting the prompt
        System.out.println("Thank you,You have exited the system. Goodbye, " + Main.userName + "!");
        scanner.close();
        System.exit(0);
    }
}

