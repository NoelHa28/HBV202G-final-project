package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to add a book with a single author to the library system.
 */
public class AddBookSingleAuthorCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new AddBookSingleAuthorCommand.
     * 
     * @param librarySystem the library system to add the book to
     * @param scanner the scanner to read user input
     */
    public AddBookSingleAuthorCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Adds a book with a single author to the library system.
     */
    @Override
    public void execute() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
    }
}