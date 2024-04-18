package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

public class PrintLendingsFromUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public PrintLendingsFromUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

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