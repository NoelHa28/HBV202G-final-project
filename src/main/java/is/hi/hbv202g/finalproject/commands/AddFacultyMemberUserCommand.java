package is.hi.hbv202g.finalproject.commands;

import is.hi.hbv202g.finalproject.*;
import java.util.Scanner;

public class AddFacultyMemberUserCommand implements Command {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public AddFacultyMemberUserCommand(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.print("Enter faculty member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty member department: ");
        String department = scanner.nextLine();
        librarySystem.addFacultyMemberUser(name, department);
    }
}