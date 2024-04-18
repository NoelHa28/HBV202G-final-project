package is.hi.hbv202g.finalproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import is.hi.hbv202g.finalproject.commands.*;

/**
 * Class that provides a user interface for the library system.
 * It implements the Observer interface to get updates from the library system.
 */
public class NewLibrarySystemUI implements Observer {
    private LibrarySystem librarySystem;
    private Scanner scanner;
    private Map<Integer, Command> commands;

    /**
     * Constructs a new NewLibrarySystemUI object and uses the command design pattern.
     * Initializes the library system, scanner, and commands.
     * Adds this UI as an observer of the library system.
     *
     * @param librarySystem the library system that this UI interacts with
     */
    public NewLibrarySystemUI(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.librarySystem.addObserver(this);
        this.scanner = new Scanner(System.in);
        this.commands = new HashMap<>();
        this.commands.put(1, new AddBookSingleAuthorCommand(librarySystem, scanner));
        this.commands.put(2, new AddBookMultipleAuthorsCommand(librarySystem, scanner));
        this.commands.put(3, new FindBookByTitleCommand(librarySystem, scanner));
        this.commands.put(4, new PrintAllBooksCommand(librarySystem));
        this.commands.put(5, new AddFacultyMemberUserCommand(librarySystem));
        this.commands.put(6, new AddStudentUserCommand(librarySystem));
        this.commands.put(7, new FindUserByNameCommand(librarySystem, scanner));
        this.commands.put(8, new PrintAllUsersCommand(librarySystem));
        this.commands.put(9, new PrintLendingsFromUserCommand(librarySystem));
        this.commands.put(10, new BorrowBookCommand(librarySystem, scanner));
        this.commands.put(11, new ReturnBookCommand(librarySystem, scanner));
        this.commands.put(12, new ExtendLendingCommand(librarySystem, scanner));
    }

    @Override
    public void update(String message) {
        System.out.println(message);
    }

    /**
     * Starts the library system. This is the main entry point of the application.
     * It provides a menu for the user to manage books, users, and lendings.
     * @throws EmptyAuthorListException if the author list for a book is empty
     */
    public void start() throws EmptyAuthorListException {
        System.out.println(
                "Welcome to the library system! Please choose an option:");
        while (true) {
            System.out.println("1. Manage books");
            System.out.println("2. Manage users");
            System.out.println("3. Manage lendings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    manageLendings();
                    break;
                case 4:
                    System.out.println("Thank you for using the library system!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    /**
     * Provides a sub-menu for managing books in the library system.
     * 
     * @throws EmptyAuthorListException if the author list for a book is empty
     */
    private void manageBooks() throws EmptyAuthorListException {
        while (true) {
            System.out.println("1. Add book with single author");
            System.out.println("2. Add book with multiple authors");
            System.out.println("3. Find book by title");
            System.out.println("4. Print all books");
            System.out.println("2024. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 2024) {
                return;
            }
            getCommand(choice);
        }
    }

    /**
     * Provides a sub-menu for managing users in the library system.
     */
    private void manageUsers() {
        while (true) {
            System.out.println("5. Add faculty member user");
            System.out.println("6. Add student user");
            System.out.println("7. Find user by name");
            System.out.println("8. Print all users");
            System.out.println("2024. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 2024) {
                return;
            }
            getCommand(choice);
        }
    }

    /**
     * Provides a sub-menu for managing lendings in the library system.
     */
    private void manageLendings() {
        while (true) {
            System.out.println("9. Print all lendings from user");
            System.out.println("10. Borrow book");
            System.out.println("11. Return book");
            System.out.println("12. Extend lending");
            System.out.println("2024. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 2024) {
                return;
            }
            getCommand(choice);
        }
    }

    /**
     * Executes the command associated with the given choice number.
     * If the choice number is not associated with any command, it prints "Unknown command".
     *
     * @param choice the number associated with the command to execute
     */
    private void getCommand(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Unknown command");
        }
    }
}