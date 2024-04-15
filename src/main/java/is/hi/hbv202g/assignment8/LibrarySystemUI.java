package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystemUI {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public LibrarySystemUI() {
        this.librarySystem = new LibrarySystem();
        this.scanner = new Scanner(System.in);
    }

    public void start() throws EmptyAuthorListException {
        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Add user");
            System.out.println("3. Find book by title");
            System.out.println("4. Find user by name");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
    
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addUser();
                    break;
                case 3:
                    findBookByTitle();
                    break;
                case 4:
                    findUserByName();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void addBook() throws EmptyAuthorListException {
        System.out.println("1. Add book with single author");
        System.out.println("2. Add book with multiple authors");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
    
        switch (choice) {
            case 1:
                addBookWithSingleAuthor();
                break;
            case 2:
                addBookWithAuthorList();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void addBookWithSingleAuthor() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String authorName = scanner.nextLine();
        librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
        System.out.println("Book added successfully");
    }

    private void addBookWithAuthorList() throws EmptyAuthorListException {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter number of authors: ");
        int numAuthors = scanner.nextInt();
        scanner.nextLine();
        List<Author> authors = new ArrayList<>();
        for (int i = 0; i < numAuthors; i++) {
            System.out.print("Enter name of author " + (i + 1) + ": ");
            String authorName = scanner.nextLine();
            Author author = new Author(authorName); // Create a new Author object
            authors.add(author); // Add the Author object to the list
        }
        librarySystem.addBookWithTitleAndAuthorList(title, authors);
        System.out.println("Book added successfully");
    }
    
    private void addUser() {
        System.out.println("1. Add student user");
        System.out.println("2. Add faculty member user");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
    
        switch (choice) {
            case 1:
                addStudentUser();
                break;
            case 2:
                addFacultyMemberUser();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    
    private void addFacultyMemberUser() {
        System.out.print("Enter faculty member name: ");
        String name = scanner.nextLine();
        System.out.print("Enter faculty member department: ");
        String department = scanner.nextLine();
        librarySystem.addFacultyMemberUser(name, department);
        System.out.println("Faculty member user added successfully");
    }

    private void addStudentUser() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Has student paid fee (yes/no): ");
        boolean feePaid = scanner.nextLine().equalsIgnoreCase("yes");
        librarySystem.addStudentUser(name, feePaid);
        System.out.println("Student user added successfully");
    }

    private void findBookByTitle() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        try {
            Book book = librarySystem.findBookByTitle(title);
            StringBuilder authors = new StringBuilder();
            for (Author author : book.getAuthors()) {
                authors.append(author.getName()).append(", ");
            }
            // Remove the trailing comma and space
            if (authors.length() > 0) {
                authors.setLength(authors.length() - 2);
            }
            System.out.println("Book found: " + book.getTitle() + " by " + authors);
        } catch (Exception e) {
            System.out.println("No book found with the given title");
        }
    }
    
    private void findUserByName() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(name);
            String userType = (user instanceof FacultyMember) ? "FacultyMember" : "Student";
            System.out.println("User found: " + user.getName() + " (" + userType + ")");
        } catch (Exception e){
            System.out.println("No user found with the given name");
        }
    }

    public static void main(String[] args) throws EmptyAuthorListException {
        new LibrarySystemUI().start();
    }
}