package is.hi.hbv202g.assignment8;

import java.util.List;

/**
 * Represents an omnibus in the library system.
 * An omnibus is a collection of multiple books combined in a set.
 * This implements the Composite pattern, where an omnibus contains multiple books.
 */
public class Omnibus {
    private List<Book> books;

    /**
     * Creates a new omnibus with the specified list of books.
     * 
     * @param books The list of books in the omnibus
     */
    public Omnibus(List<Book> books) {
        this.books = books;
    }

    /**
     * Gets the list of books in the omnibus.
     * 
     * @return The list of books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Sets the list of books in the omnibus.
     * 
     * @param books The new list of books
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * Adds a book to the omnibus.
     * 
     * @param book The book to add
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * Removes a book from the omnibus.
     * 
     * @param book The book to remove
     */
    public void removeBook(Book book) {
        this.books.remove(book);
    }

    /**
     * Finds a book in the omnibus by its title.
     * 
     * @param title The title to search for
     * @return The found book
     * @throws UserOrBookDoesNotExistException if no book with the title exists in the omnibus
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book with title " + title + " does not exist");
    }
}
