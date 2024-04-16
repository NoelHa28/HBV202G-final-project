package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;
import java.util.Scanner;

public class AddBookSingleAuthorCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public AddBookSingleAuthorCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        System.out.println("Book added successfully");
    }
}