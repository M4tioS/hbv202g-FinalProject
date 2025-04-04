package is.hi.hbv202g.assignment8;
/**
 * Exception thrown when attempting to borrow a book that is already lent.
 */
public class BookAlreadyLentException extends RuntimeException {
    /**
     * Creates a new exception with the specified error message.
     *
     * @param message The error message
     */
    public BookAlreadyLentException(String message) {
        super(message);
    }
}
