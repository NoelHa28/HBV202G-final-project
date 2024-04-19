package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to print all lendings from a user.
 */
public class PrintLendingsFromUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new PrintLendingsFromUserCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read user input
     */
    public PrintLendingsFromUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints all lendings from a user.
     */
    @Override
    public void execute() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(userName);
            librarySystem.printLendings(user);
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println("Failed to find user: " + e.getMessage());
        }
    }
}