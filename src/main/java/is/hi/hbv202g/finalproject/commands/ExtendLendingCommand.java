package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to extend a lending.
 */
public class ExtendLendingCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new ExtendLendingCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read input
     */
    public ExtendLendingCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Extends a lending.
     */
    @Override
    public void execute() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter number of days to extend: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // consume newline
        try {
            User user = librarySystem.findUserByName(userName);
            Book book = librarySystem.findBookByTitle(bookTitle);
            librarySystem.extendLending(user, book, days);
        } catch (Exception e) {
            System.out.println("Failed to extend lending: " + e.getMessage());
        }
    }
}