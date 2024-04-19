package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

/**
 * Command to add a faculty member user to the library system.
 */
public class AddFacultyMemberUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    /**
     * Creates a new AddFacultyMemberUserCommand.
     * 
     * @param librarySystem the library system to add the faculty member user to
     */
    public AddFacultyMemberUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a faculty member user to the library system.
     */
    @Override
    public void execute() {
        System.out.print("Enter faculty member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty member department: ");
        String department = scanner.nextLine();
        librarySystem.addFacultyMemberUser(name, department);
    }
}