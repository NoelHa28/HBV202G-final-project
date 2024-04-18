package is.hi.hbv202g.finalproject;

/**
 * Utility class for operations related to authors.
 */
public class AuthorUtils {
    /**
     * Returns a StringBuilder containing the names of all authors of the given book,
     * separated by commas. If the book has no authors, returns an empty StringBuilder.
     *
     * @param book the book whose authors to print
     * @return a StringBuilder containing the names of the book's authors, separated by commas
     */
    public static StringBuilder printAuthors(Book book) {
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
}
