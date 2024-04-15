package is.hi.hbv202g.assignment8;

import java.util.Scanner;

public class LibrarySystemUI {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public LibrarySystemUI() {
        this.librarySystem = new LibrarySystem();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("1. Add book with title and single author");
            System.out.println("2. Add student user");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addStudentUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        System.out.println("Book added successfully");
    }

    private void addStudentUser() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Has student paid fee (yes/no): ");
        boolean feePaid = scanner.nextLine().equalsIgnoreCase("yes");
        librarySystem.addStudentUser(name, feePaid);
        System.out.println("Student user added successfully");
    }

    public static void main(String[] args) {
        new LibrarySystemUI().start();
    }
}