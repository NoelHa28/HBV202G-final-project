package is.hi.hbv202g.assignment8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibrarySystemUI {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public LibrarySystemUI(LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        this.scanner = new Scanner(System.in);
    }

    public void start() throws EmptyAuthorListException {
        System.out.println(
                "Welcome to the library system! Please choose an option:");
        while (true) {
            System.out.println("1. Manage books");
            System.out.println("2. Manage users");
            System.out.println("3. Manage lendings");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageBooks();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 3:
                    manageLendings();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void manageBooks() throws EmptyAuthorListException {
        while (true) {
            System.out.println("1. Add book");
            System.out.println("2. Find book by title");
            System.out.println("3. Print all books");
            System.out.println("4. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findBookByTitle();
                    break;
                case 3:
                    printAllBooks();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void manageUsers() {
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Find user by name");
            System.out.println("3. Print all users");
            System.out.println("4. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
    
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    findUserByName();
                    break;
                case 3:
                    printAllUsers();
                    break;
                case 4:
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
            StringBuilder authors = printAuthors(book);
            System.out.println("Book found: " + book.getTitle() + " by " + authors);
        } catch (Exception e) {
            System.out.println("No book found with the given title");
        }
    }

    private StringBuilder printAuthors(Book book) {
        StringBuilder authors = new StringBuilder();
        for (Author author : book.getAuthors()) {
            authors.append(author.getName()).append(", ");
        }
        // Remove the trailing comma and space
        if (authors.length() > 0) {
            authors.setLength(authors.length() - 2);
        }
        return authors;
    }
    
    private void findUserByName() {
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

    private void printAllUsers() {
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
    
    private void printAllBooks() {
        List<Book> books = librarySystem.getAllBooks();
        System.out.println("The following books are found in the library: ");
        for (Book book : books) {
            StringBuilder authors = printAuthors(book);
            System.out.println(book.getTitle() + " by " + authors);
        }
        if (books.isEmpty()) {
            System.out.println("No books found");
        }
    }

    private void manageLendings() {
        while (true) {
            System.out.println("1. Print all lendings from user");
            System.out.println("2. Borrow book");
            System.out.println("3. Return book");
            System.out.println("4. Extend lending");
            System.out.println("5. Back to main menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
    
            switch (choice) {
                case 1:
                    printLendings();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    extendLending();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    private void borrowBook() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(userName);
            Book book = librarySystem.findBookByTitle(bookTitle);
            librarySystem.borrowBook(user, book);
            System.out.println("Book borrowed successfully");
        } catch (Exception e) {
            System.out.println("Failed to borrow book: " + e.getMessage());
        }
    }

    private void returnBook() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(userName);
            Book book = librarySystem.findBookByTitle(bookTitle);
            librarySystem.returnBook(user, book);
            System.out.println("Book returned successfully");
        } catch (Exception e) {
            System.out.println("Failed to return book: " + e.getMessage());
        }
    }

    private void printLendings() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        try {
            User user = librarySystem.findUserByName(userName);
            librarySystem.printLendings(user);
        } catch (UserOrBookDoesNotExistException e) {
            System.out.println("Failed to find user: " + e.getMessage());
        }
    }

    private void extendLending() {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter number of days to extend: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // consume newline
        try {
            User user = librarySystem.findUserByName(userName);
            Book book = librarySystem.findBookByTitle(bookTitle);
            librarySystem.extendLending(user, book, days);
            System.out.println("Lending extended for " + days + " days successfully");
        } catch (Exception e) {
            System.out.println("Failed to extend lending: " + e.getMessage());
        }
    }
}