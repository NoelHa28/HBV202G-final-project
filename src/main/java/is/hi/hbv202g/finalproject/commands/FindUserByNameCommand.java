package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to find a user by name.
 */
public class FindUserByNameCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new FindUserByNameCommand.
     * 
     * @param librarySystem the library system
     * @param scanner the scanner to read input
     */
    public FindUserByNameCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

    /**
     * Finds a user by name.
     */
    @Override
    public void execute() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(name);
            String userType = (user instanceof FacultyMember) ? "FacultyMember" : "Student";
            System.out.println("User found: " + user.getName() + " (" + userType + ")");
            librarySystem.printLendings(user);
        } catch (Exception e) {
            System.out.println("No user found with the given name");
        }
    }


}