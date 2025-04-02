package is.hi.hbv202g.assignment8;

/**
 * Exception thrown when attempting to operate on a user or book that does not exist.
 * This can happen when trying to find a book by title, a user by name, or when
 * performing operations like borrowing or returning books.
 */
public class UserOrBookDoesNotExistException extends Exception {
    /**
     * Creates a new exception with the specified error message.
     * 
     * @param message The error message
     */
    public UserOrBookDoesNotExistException(String message) {
        super(message);
    }
}
