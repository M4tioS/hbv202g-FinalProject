package is.hi.hbv202g.assignment8;

import java.util.HashMap;
import java.util.Map;

/**
 * A concrete observer class that tracks library statistics.
 * This class implements the LibraryObserver interface.
 */
public class LibraryStatistics implements LibraryObserver {
    
    private Map<Book, Integer> bookBorrowCounts;
    private Map<User, Integer> userBorrowCounts;
    private int totalBorrowings;
    private int totalReturns;
    
    /**
     * Creates a new LibraryStatistics with empty statistics.
     */
    public LibraryStatistics() {
        bookBorrowCounts = new HashMap<>();
        userBorrowCounts = new HashMap<>();
        totalBorrowings = 0;
        totalReturns = 0;
    }
    
    @Override
    public void bookBorrowed(Book book, User user) {
        // Update book statistics
        int bookCount = bookBorrowCounts.getOrDefault(book, 0);
        bookBorrowCounts.put(book, bookCount + 1);
        
        // Update user statistics
        int userCount = userBorrowCounts.getOrDefault(user, 0);
        userBorrowCounts.put(user, userCount + 1);
        
        // Update total
        totalBorrowings++;
    }
    
    @Override
    public void bookReturned(Book book, User user) {
        totalReturns++;
    }
    
    /**
     * Gets the most borrowed book.
     * 
     * @return The book that has been borrowed the most times
     */
    public Book getMostBorrowedBook() {
        Book mostBorrowed = null;
        int maxCount = 0;
        
        for (Map.Entry<Book, Integer> entry : bookBorrowCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostBorrowed = entry.getKey();
            }
        }
        
        return mostBorrowed;
    }
    
    /**
     * Gets the user who has borrowed the most books.
     * 
     * @return The user who has borrowed the most books
     */
    public User getMostActiveUser() {
        User mostActive = null;
        int maxCount = 0;
        
        for (Map.Entry<User, Integer> entry : userBorrowCounts.entrySet()) {
            User user = entry.getKey();
            int count = entry.getValue();
            
            // If this user has more borrowings, they become the most active
            if (count > maxCount) {
                maxCount = count;
                mostActive = user;
            } 
            // In case of a tie, prefer FacultyMember over other user types
            else if (count == maxCount && user instanceof FacultyMember && !(mostActive instanceof FacultyMember)) {
                mostActive = user;
            }
        }
        
        return mostActive;
    }
    
    /**
     * Gets the total number of borrowings.
     * 
     * @return The total number of borrowings
     */
    public int getTotalBorrowings() {
        return totalBorrowings;
    }
    
    /**
     * Gets the total number of returns.
     * 
     * @return The total number of returns
     */
    public int getTotalReturns() {
        return totalReturns;
    }
} 