package is.hi.hbv202g.finalproject;

import java.time.LocalDate;

/**
 * Represents a lending of a book by a user with a due date.
 */
public class Lending {
    private LocalDate dueDate;
    private Book book;
    private User user;

    /**
     * Creates a new Lending with the given book and user. The due date is set to 30 days from now.
     *
     * @param book the book being lent
     * @param user the user who is borrowing the book
     */
    public Lending(Book book, User user) {
        this.book = book;
        this.user = user;
        this.dueDate = LocalDate.now().plusDays(30);
    }

    /**
     * Returns the due date of the lending.
     *
     * @return the due date of the lending
     */
    public LocalDate getDueDate() {
        return this.dueDate;
    }

    /**
     * Sets the due date of the lending.
     *
     * @param dueDate the new due date of the lending
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Returns the book being lent.
     *
     * @return the book being lent
     */
    public Book getBook() {
        return this.book;
    }

    /**
     * Sets the book being lent.
     *
     * @param book the new book being lent
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Returns the user who is borrowing the book.
     *
     * @return the user who is borrowing the book
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Sets the user who is borrowing the book.
     *
     * @param user the new user who is borrowing the book
     */
    public void setUser(User user) {
        this.user = user;
    }
}
