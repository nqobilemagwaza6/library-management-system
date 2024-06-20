import java.util.Scanner;


public class Main {
    private static final Library library = new Library();
    private static final Scanner scanner = new Scanner(System.in);
    static String userName;

    public static void main(String[] args) {

        // Prompt for user's name
        System.out.print("Please enter your name: ");
        userName = scanner.nextLine();
        System.out.println("Welcome to our Library Management System, " + userName + "!");

        while (true) {
            displayMenu();
            int choice = getUserChoice();
            handleUserChoice(choice);
        }
    }

    private static void displayMenu() {
        // displays the prompt menu
        System.out.println("\nPlease select an option you need help with ");
        System.out.println("\nLibrary Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Search Book by Title");
        System.out.println("3. Display All Books");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static int getUserChoice() {
        // gives the number choices for the menu
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();  // newline
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number on the Menu.");
            scanner.nextLine();  // Clear invalid input
        }
        return choice;
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1:
                library.addBook();
                break;
            case 2:
                library.searchBookByTitle();
                break;
            case 3:
                library.displayAndDeleteBooks();
                break;
            case 4:
                library.exitSystem();
                break;
            default:
                System.out.println("Invalid choice. Please choose a number in the list.");
        }
    }
}