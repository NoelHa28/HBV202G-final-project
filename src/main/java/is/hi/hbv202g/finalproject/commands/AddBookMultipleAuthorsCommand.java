package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Command to add a book with multiple authors to the library system
 */
public class AddBookMultipleAuthorsCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new AddBookMultipleAuthorsCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read input
     */
    public AddBookMultipleAuthorsCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Adds a book with multiple authors to the library system
     */
    @Override
    public void execute() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of authors: ");
        int numAuthors = scanner.nextInt();
        scanner.nextLine();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < numAuthors; i++) {
            System.out.print("Enter name of author " + (i + 1) + ": ");
            String authorName = scanner.nextLine();
            Author author = new Author(authorName);
            authors.add(author);
        }
        try {
            librarySystem.addBookWithTitleAndAuthorList(title, authors);
        } catch (EmptyAuthorListException e) {
            System.out.println("Error: Author list is empty");
        }
    }
}