package is.hi.hbv202g.assignment8;


/**
 * This interface is used to observe the library.
 * It is implemented by the classes that want to observe the library.
 * It is used to notify the observer when a book is borrowed or returned.
 */
public interface LibraryObserver {


    /*
     * This method is called when a book is borrowed.
     * @param book The book that is borrowed.
     */
    void bookBorrowed(Book book);

    /*
     * This method is called when a book is returned.
     * @param book The book that is returned.
     */
    void bookReturned(Book book);
    
}
