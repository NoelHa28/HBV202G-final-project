package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddBookMultipleAuthorsCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public AddBookMultipleAuthorsCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

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