package is.hi.hbv202g.assignment8.commands;

import is.hi.hbv202g.assignment8.*;
import java.util.Scanner;

public class AddStudentUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public AddStudentUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Has student paid fee (yes/no): ");
        boolean feePaid = scanner.nextLine().equalsIgnoreCase("yes");
        librarySystem.addStudentUser(name, feePaid);
        System.out.println("Student user added successfully");
    }
}