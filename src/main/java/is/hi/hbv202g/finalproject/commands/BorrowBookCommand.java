package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to borrow a book from the library system.
 */
public class BorrowBookCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new BorrowBookCommand.
     * 
     * @param librarySystem the library system to borrow the book from
     * @param scanner the scanner to read user input
     */
    public BorrowBookCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Borrows a book from the library system.
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
            librarySystem.borrowBook(user, book);
        } catch (Exception e) {
            System.out.println("Failed to borrow book: " + e.getMessage());
        }
    }
}