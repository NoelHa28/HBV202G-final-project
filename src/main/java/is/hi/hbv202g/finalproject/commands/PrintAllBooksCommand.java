package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.List;

/**
 * Command to print all books in the library
 */
public class PrintAllBooksCommand implements Command {
    private LibrarySystem librarySystem;

    /**
     * Creates a new PrintAllBooksCommand.
     * 
     * @param librarySystem the library system
     */
    public PrintAllBooksCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    /**
     * Prints all books in the library
     */
    @Override
    public void execute() {
        List<Book> books = librarySystem.getAllBooks();
        System.out.println("The following books are found in the library: ");
        for (Book book : books) {
            StringBuilder authors = AuthorUtils.printAuthors(book);
            System.out.println(book.getTitle() + " by " + authors);
        }
        if (books.isEmpty()) {
            System.out.println("No books found");
        }
    }


}