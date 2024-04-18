package is.hi.hbv202g.finalproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents a library system. It is a singleton class and uses the oberser pattern for updates.
 * It manages users, books, and lendings in the library.
 */
public class LibrarySystem extends Observable {
    private static LibrarySystem instance;
    private List<User> users;
    private List<Book> books;
    private List<Lending> lendings;

    /**
     * Private constructor to ensure singleton pattern.
     */
    private LibrarySystem() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    /**
     * Returns a list of all users in the library system.
     * @return a list of all users.
     */
    public List<User> getAllUsers() {
        return new ArrayList<>(this.users);
    }

    /**
     * Returns the singleton instance of the library system.
     * @return the singleton instance.
     */
    public static LibrarySystem getInstance() {
        if (instance == null) {
            instance = new LibrarySystem();
        }
        return instance;
    }
    
    /**
     * Returns a list of all books in the library system.
     * @return a list of all books.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(this.books);
    }

    /**
     * Adds a book with a single author to the library system and notifies observers.
     * @param title the title of the book.
     * @param authorName the name of the author.
     */
    public void addBookWithTitleAndNameOfSingleAuthor(String title, String authorName) {
        this.books.add(new Book(title, authorName));
        notifyObservers(title + " by " + authorName + " has been added to the library");
    }

    /**
     * Adds a book with multiple authors to the library system and notifies observers.
     * @param title the title of the book.
     * @param authors a list of authors.
     * @throws EmptyAuthorListException if the list of authors is empty.
     */
    public void addBookWithTitleAndAuthorList(String title, List<Author> authors) throws EmptyAuthorListException {
        this.books.add(new Book(title, authors));
        String authorNames = authors.stream()
                .map(Author::getName)
                .collect(Collectors.joining(", "));
        notifyObservers(title + " by " + authorNames + " has been added to the library");
    }

    /**
     * Adds a student user to the library system and notifies observers.
     * @param name the name of the student.
     * @param feePaid whether the student has paid the fee.
     */
    public void addStudentUser(String name, boolean feePaid) {
        this.users.add(new Student(name, feePaid));
        notifyObservers("The student user " + name + " has been added to the library. Fee paid: " + feePaid + ".");
    }

    /**
     * Adds a faculty member user to the library system and notifies observers.
     * @param name the name of the faculty member.
     * @param department the department of the faculty member.
     */
    public void addFacultyMemberUser(String name, String department) {
        this.users.add(new FacultyMember(name, department));
        notifyObservers("The faculty member user " + name + " from the department " + department
                + " has been added to the library");
    }

    /**
     * Finds a book by its title.
     * @param title the title of the book.
     * @return the book with the given title.
     * @throws UserOrBookDoesNotExistException if the book does not exist.
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title " + title + " does not exist");
    }

    /**
     * Finds a user by their name.
     * @param name the name of the user.
     * @return the user with the given name.
     * @throws UserOrBookDoesNotExistException if the user does not exist.
     */
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : this.users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User with name " + name + " does not exist");
    }

    /**
     * Allows a user to borrow a book and notifies observers.
     * @param user the user who wants to borrow the book.
     * @param book the book to be borrowed.
     * @throws UserOrBookDoesNotExistException if the user or book does not exist.
     */
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        User foundUser = findUserByName(user.getName());
        Book foundBook = findBookByTitle(book.getTitle());

        this.lendings.add(new Lending(foundBook, foundUser));
        notifyObservers(foundUser.getName() + " is now borrowing " + foundBook.getTitle());
    }

    /**
     * Extends the lending period of a book for a user and notifies observers.
     * @param user the user who wants to extend the lending period.
     * @param book the book to extend the lending period for.
     * @param days the number of days to extend the lending period by.
     */
    public void extendLending(User andri, Book book, int days) {
        for (Lending lending : this.lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(andri)) {
                lending.setDueDate(lending.getDueDate().plusDays(days));
                break;
            }
        }
        notifyObservers(andri.getName() + " extended the lending of " + book.getTitle() + " by " + days + " days");
    }

    /**
     * Allows a user to return a book and notifies observers.
     * @param user the user who wants to return the book.
     * @param book the book to be returned.
     * @throws UserOrBookDoesNotExistException if the book was not borrowed by this user.
     */
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        Lending foundLending = null;
        for (Lending lending : this.lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                foundLending = lending;
                break;
            }
        }
        if (foundLending == null) {
            throw new UserOrBookDoesNotExistException("Book was not borrowed by this user");
        }
        this.lendings.remove(foundLending);
        notifyObservers(user.getName() + " has returned " + book.getTitle());
    }
    
    /**
     * Prints the lendings of a user.
     * @param user the user whose lendings are to be printed.
     */
    public void printLendings(User user) {
        boolean hasLendings = false;
        for (Lending lending : this.lendings) {
            if (lending.getUser().equals(user)) {
                System.out.println(lending.getBook().getTitle() +
                        " is currently borrowed by " +
                        lending.getUser().getName() +
                        " until " + lending.getDueDate());
                hasLendings = true;
            }
        }
        if (!hasLendings) {
            System.out.println(user.getName() + " has no lendings");
        }
    }
}
