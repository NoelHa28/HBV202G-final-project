package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;

import java.util.List;

public class PrintAllUsersCommand implements Command {
    private LibrarySystem librarySystem;

    public PrintAllUsersCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
    }

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