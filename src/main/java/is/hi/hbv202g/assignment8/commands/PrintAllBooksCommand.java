package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;

import java.util.List;

public class PrintAllBooksCommand implements Command {
    private LibrarySystem librarySystem;

    public PrintAllBooksCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

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