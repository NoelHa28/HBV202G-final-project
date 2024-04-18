package is.hi.hbv202g.finalproject;

/**
 * This class represents a custom exception that is thrown when a user or book does not exist in the system.
 */
public class UserOrBookDoesNotExistException extends Exception {

    /**
     * Constructs a new UserOrBookDoesNotExistException with the specified detail message.
     *
     * @param message the detail message to be thrown
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}
