package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to return a book to the library.
 */
public class ReturnBookCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new ReturnBookCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read user input
     */
    public ReturnBookCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Returns a book to the library.
     */
    @Override
    public void execute() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(userName);
            Book book = librarySystem.findBookByTitle(bookTitle);
            librarySystem.returnBook(user, book);
            System.out.println("Book returned successfully");
        } catch (Exception e) {
            System.out.println("Failed to return book: " + e.getMessage());
        }
    }
}