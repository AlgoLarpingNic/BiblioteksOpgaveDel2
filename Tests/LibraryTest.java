import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    Member member;
    Book book;
    Library library;
    Loan loan;
    LoanPolicy loanPolicy;

    LocalDate dueDate = LocalDate.now().plusDays(30);
    @BeforeEach
    void setupLibrary() {
        book = new Book("Ben Dover", "the deep", "80085", 420);
        member = new Member("Suk yoo hoff", 111);
        loanPolicy = new StandardLoanPolicy();
        library = new Library(loanPolicy);
        loan = new Loan(book, member, dueDate);

    }

    @Test
    void testLoanWithMember() {
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource(111, "80085");

        assertEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testLoanWithUnknownMember() {
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource(132, "80085");

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testWhenBookIsNotAvailable() {
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource(111, "8==D");

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testLoanBookTwice() {
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        library.loanResource(111, "80085");
        LoanResult result = library.loanResource(111, "80085");

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testOfLoanBookAfterReturn() {
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        library.loanResource(111, "80085");

        library.returnResource("80085");

        LoanResult result = library.loanResource(111, "80085");

        assertEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testReturn(){
        setupLibrary();
        library.addMember(member);
        library.addResource(book);

        library.loanResource(111, "80085");

        boolean returnResult = library.returnResource("80085");

        assertTrue(returnResult);



    }

}
