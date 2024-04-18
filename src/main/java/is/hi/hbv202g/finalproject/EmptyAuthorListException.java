package is.hi.hbv202g.finalproject;

/**
 * Exception thrown when an operation is attempted with an empty author list.
 */
public class EmptyAuthorListException extends Exception {
    /**
     * Constructs a new EmptyAuthorListException with the specified detail message.
     *
     * @param message the detail message
     */
    public EmptyAuthorListException(String message) {
        super(message);
    }
}
