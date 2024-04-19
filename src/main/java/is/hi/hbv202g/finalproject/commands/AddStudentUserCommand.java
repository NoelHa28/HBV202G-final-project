package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to add a student user to the library system.
 */
public class AddStudentUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new AddStudentUserCommand.
     * 
     * @param librarySystem the library system to add the student user to
     */
    public AddStudentUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a student user to the library system.
     */
    @Override
    public void execute() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Has student paid fee (yes/no): ");
        boolean feePaid = scanner.nextLine().equalsIgnoreCase("yes");
        librarySystem.addStudentUser(name, feePaid);
    }
}