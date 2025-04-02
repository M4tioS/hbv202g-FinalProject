package is.hi.hbv202g.assignment8;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the LibrarySystem class.
 */
public class LibrarySystemTest {
    
    private LibrarySystem library;
    private Book book1;
    private Book book2;
    private Student student;
    private FacultyMember facultyMember;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() {
        library = new LibrarySystem();
        library.addBookWithTitleAndNameOfSingleAuthor("Test Book 1", "Test Author 1");
        library.addBookWithTitleAndNameOfSingleAuthor("Test Book 2", "Test Author 2");
        library.addStudentUser("Test Student", true);
        library.addFacultyMemberUser("Test Faculty", "Test Department");
        
        try {
            book1 = library.findBookByTitle("Test Book 1");
            book2 = library.findBookByTitle("Test Book 2");
            student = (Student) library.findUserByName("Test Student");
            facultyMember = (FacultyMember) library.findUserByName("Test Faculty");
        } catch (UserOrBookDoesNotExistException e) {
            fail("Setup failed due to: " + e.getMessage());
        }
    }
    
    /**
     * Tests adding and finding a book with a single author.
     */
    @Test
    public void testAddAndFindBookWithSingleAuthor() {
        try {
            Book book = library.findBookByTitle("Test Book 1");
            assertNotNull("Book should exist", book);
            assertEquals("Test Book 1", book.getTitle());
            assertEquals(1, book.getAuthors().size());
            assertEquals("Test Author 1", book.getAuthors().get(0).getName());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Book not found: " + e.getMessage());
        }
    }
    
    /**
     * Tests adding and finding a book with multiple authors.
     */
    @Test
    public void testAddAndFindBookWithMultipleAuthors() {
        try {
            List<Author> authors = new ArrayList<>();
            authors.add(new Author("Author A"));
            authors.add(new Author("Author B"));
            
            library.addBookWithTitleAndAuthorList("Multi-Author Book", authors);
            
            Book book = library.findBookByTitle("Multi-Author Book");
            assertNotNull("Book should exist", book);
            assertEquals("Multi-Author Book", book.getTitle());
            assertEquals(2, book.getAuthors().size());
            assertEquals("Author A", book.getAuthors().get(0).getName());
            assertEquals("Author B", book.getAuthors().get(1).getName());
        } catch (Exception e) {
            fail("Test failed due to: " + e.getMessage());
        }
    }
    
    /**
     * Tests adding and finding a student user.
     */
    @Test
    public void testAddAndFindStudentUser() {
        try {
            User user = library.findUserByName("Test Student");
            assertNotNull("User should exist", user);
            assertTrue("User should be a Student", user instanceof Student);
            
            Student student = (Student) user;
            assertEquals("Test Student", student.getName());
            assertTrue("Fee should be paid", student.isFeePaid());
        } catch (UserOrBookDoesNotExistException e) {
            fail("User not found: " + e.getMessage());
        }
    }
    
    /**
     * Tests adding and finding a faculty member user.
     */
    @Test
    public void testAddAndFindFacultyMemberUser() {
        try {
            User user = library.findUserByName("Test Faculty");
            assertNotNull("User should exist", user);
            assertTrue("User should be a FacultyMember", user instanceof FacultyMember);
            
            FacultyMember faculty = (FacultyMember) user;
            assertEquals("Test Faculty", faculty.getName());
            assertEquals("Test Department", faculty.getDepartment());
        } catch (UserOrBookDoesNotExistException e) {
            fail("User not found: " + e.getMessage());
        }
    }
    
    /**
     * Tests borrowing a book.
     */
    @Test
    public void testBorrowBook() {
        try {
            library.borrowBook(student, book1);
            
            // Verify lending is recorded
            List<Lending> lendings = library.getLendings();
            assertEquals(1, lendings.size());
            
            Lending lending = lendings.get(0);
            assertEquals(book1, lending.getBook());
            assertEquals(student, lending.getUser());
            
            // Due date should be around 30 days from now
            LocalDate expectedDueDate = LocalDate.now().plusDays(30);
            assertEquals(expectedDueDate, lending.getDueDate());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Borrowing failed: " + e.getMessage());
        }
    }
    
    /**
     * Tests extending a lending for a faculty member.
     */
    @Test
    public void testExtendLending() {
        try {
            // Borrow the book first
            library.borrowBook(facultyMember, book1);
            
            // Extend the lending
            LocalDate newDueDate = LocalDate.now().plusDays(60);
            library.extendLending(facultyMember, book1, newDueDate);
            
            // Verify lending is extended
            List<Lending> lendings = library.getLendings();
            assertEquals(1, lendings.size());
            
            Lending lending = lendings.get(0);
            assertEquals(book1, lending.getBook());
            assertEquals(facultyMember, lending.getUser());
            assertEquals(newDueDate, lending.getDueDate());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Extending lending failed: " + e.getMessage());
        }
    }
    
    /**
     * Tests returning a book.
     */
    @Test
    public void testReturnBook() {
        try {
            // Borrow the book first
            library.borrowBook(student, book1);
            
            // Verify lending is recorded
            List<Lending> lendings = library.getLendings();
            assertEquals(1, lendings.size());
            
            // Return the book
            library.returnBook(student, book1);
            
            // Verify lending is removed
            lendings = library.getLendings();
            assertEquals(0, lendings.size());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Returning book failed: " + e.getMessage());
        }
    }
    
    /**
     * Tests adding and borrowing an omnibus.
     */
    @Test
    public void testOmnibus() {
        try {
            // Create an omnibus
            List<Book> books = new ArrayList<>();
            books.add(book1);
            books.add(book2);
            library.addOmnibus(books);
            
            // Verify omnibus is added
            List<Omnibus> omnibuses = library.getOmnibuses();
            assertEquals(1, omnibuses.size());
            
            Omnibus omnibus = omnibuses.get(0);
            assertEquals(2, omnibus.getBooks().size());
            
            // Borrow the omnibus
            library.borrowOmnibus(student, omnibus);
            
            // Verify two lendings are created (one for each book)
            List<Lending> lendings = library.getLendings();
            assertEquals(2, lendings.size());
            
            // Return the omnibus
            library.returnOmnibus(student, omnibus);
            
            // Verify lendings are removed
            lendings = library.getLendings();
            assertEquals(0, lendings.size());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Omnibus operations failed: " + e.getMessage());
        }
    }
    
    /**
     * Tests the observer pattern with LibraryStatistics.
     */
    @Test
    public void testObserverPattern() {
        try {
            // Create and add a statistics observer
            LibraryStatistics stats = new LibraryStatistics();
            library.addObserver(stats);
            
            // Perform some borrowing and returning operations
            library.borrowBook(student, book1);
            library.borrowBook(facultyMember, book2);
            library.returnBook(student, book1);
            
            // Verify statistics are tracked
            assertEquals(2, stats.getTotalBorrowings());
            assertEquals(1, stats.getTotalReturns());
            
            // Verify most active user
            assertEquals(facultyMember, stats.getMostActiveUser());
            
            // Verify most borrowed book
            assertEquals(book1, stats.getMostBorrowedBook());
        } catch (UserOrBookDoesNotExistException e) {
            fail("Observer pattern test failed: " + e.getMessage());
        }
    }
    
    /**
     * Tests that an exception is thrown when borrowing a non-existent book.
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testBorrowNonExistentBook() throws UserOrBookDoesNotExistException {
        Book nonExistentBook = new Book("Non-existent Book", "Unknown Author");
        library.borrowBook(student, nonExistentBook);
    }
    
    /**
     * Tests that an exception is thrown when a non-existent user tries to borrow a book.
     */
    @Test(expected = UserOrBookDoesNotExistException.class)
    public void testNonExistentUserBorrowBook() throws UserOrBookDoesNotExistException {
        User nonExistentUser = new Student("Non-existent Student", false);
        library.borrowBook(nonExistentUser, book1);
    }
    
    /**
     * Tests that an exception is thrown when adding a book with an empty author list.
     */
    @Test(expected = EmptyAuthorListException.class)
    public void testAddBookWithEmptyAuthorList() throws EmptyAuthorListException {
        List<Author> emptyList = new ArrayList<>();
        library.addBookWithTitleAndAuthorList("Test Book", emptyList);
    }
} 