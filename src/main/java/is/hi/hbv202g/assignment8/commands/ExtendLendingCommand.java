package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;
import java.util.Scanner;

public class ExtendLendingCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public ExtendLendingCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

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