package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to find a book by title.
 */
public class FindBookByTitleCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new FindBookByTitleCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read input
     */
    public FindBookByTitleCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Finds a book by title.
     */
    @Override
    public void execute() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        try {
            Book book = librarySystem.findBookByTitle(title);
            StringBuilder authors = AuthorUtils.printAuthors(book);
            System.out.println("Book found: " + book.getTitle() + " by " + authors);
        } catch (Exception e) {
            System.out.println("No book found with the given title");
        }
    }


}