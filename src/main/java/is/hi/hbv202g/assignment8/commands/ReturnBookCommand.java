package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;
import java.util.Scanner;

public class ReturnBookCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public ReturnBookCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

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