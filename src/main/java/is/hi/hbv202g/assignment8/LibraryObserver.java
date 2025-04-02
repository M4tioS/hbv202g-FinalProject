package is.hi.hbv202g.assignment8;

/**
 * The LibraryObserver interface for the Observer pattern.
 * Classes implementing this interface will be notified of library events.
 */
public interface LibraryObserver {
    
    /**
     * Called when a book is borrowed.
     * 
     * @param book The book that was borrowed
     * @param user The user who borrowed the book
     */
    void bookBorrowed(Book book, User user);
    
    /**
     * Called when a book is returned.
     * 
     * @param book The book that was returned
     * @param user The user who returned the book
     */
    void bookReturned(Book book, User user);
} 