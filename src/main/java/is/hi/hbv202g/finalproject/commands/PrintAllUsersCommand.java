package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.List;

/**
 * Command to print all users in the library
 */
public class PrintAllUsersCommand implements Command {
    private LibrarySystem librarySystem;

    /**
     * Creates a new PrintAllUsersCommand.
     * 
     * @param librarySystem the library system
     */
    public PrintAllUsersCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

    /**
     * Prints all users in the library
     */
    @Override
    public void execute() {
        List<User> users = librarySystem.getAllUsers();
        System.out.println("The following users are found: ");
        for (User user : users) {
            String userType = (user instanceof FacultyMember) ? "FacultyMember" : "Student";
            System.out.println(user.getName() + " (" + userType + ")");
        }
        if (users.isEmpty()) {
            System.out.println("No users found");
        }
    }


}