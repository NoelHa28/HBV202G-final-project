package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;
import java.util.Scanner;

public class FindUserByNameCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public FindUserByNameCommand(LibrarySystem librarySystem, Scanner scanner) {
        this.librarySystem = librarySystem;
        this.scanner = scanner;
    }

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