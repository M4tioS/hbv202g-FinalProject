package is.hi.hbv202g.assignment8;

import java.time.LocalDate;

/**
 * Represents a lending transaction in the library system.
 * A lending consists of a book, a user who borrowed it, and a due date.
 */
public class Lending {
    private LocalDate dueDate;
    private Book book;
    private User user;

    /**
     * Creates a new lending with the specified book and user.
     * The due date is automatically set to 30 days from now.
     * 
     * @param book The book being borrowed
     * @param user The user borrowing the book
     */
    public Lending(Book book, User user) {
        this.dueDate = LocalDate.now().plusDays(30);
        this.book = book;
        this.user = user;
    }

    /**
     * Gets the due date for returning the book.
     * 
     * @return The due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date for returning the book.
     * 
     * @param dueDate The new due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the book in this lending.
     * 
     * @return The book
     */
    public Book getBook() {
        return book;
    }

    /**
     * Sets the book in this lending.
     * 
     * @param book The new book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     * Gets the user who borrowed the book.
     * 
     * @return The user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who borrowed the book.
     * 
     * @param user The new user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
