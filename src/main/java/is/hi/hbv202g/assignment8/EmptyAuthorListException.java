package is.hi.hbv202g.assignment8;

/**
 * Exception thrown when attempting to create or set an empty list of authors.
 * Books must have at least one author.
 */
public class EmptyAuthorListException extends Exception {
    /**
     * Creates a new exception with the specified error message.
     * 
     * @param message The error message
     */
    public EmptyAuthorListException(String message) {
        super(message);
    }
}
