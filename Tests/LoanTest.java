import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    Book book;
    Member member;
    Loan loan;
    @BeforeEach
    void setupLoan(){
        book = new Book("Ben Dover", "the deep", "80085", 420);
        member = new Member("Suk yoo hoff", 111);
        loan = new Loan(book, member);

    }

    @Test
    void testGetResource(){
        //arrange
        setupLoan();
        
        //act
        Resource getResourceResult = loan.getResource();

        //assert
        assertEquals(book, getResourceResult);

    }
    @Test
    void testGetMember(){
        //arrange
        setupLoan();

        //act
        Member getMemberResult = loan.getMember();

        //assert
        assertEquals(member, getMemberResult);
    }

    @Test
    void testGetLoanDate(){
        setupLoan();

        LocalDate getLoanDateResult = loan.getLoanDate();

        assertEquals(LocalDate.now(), getLoanDateResult);
    }

    @Test
    void testGetDueDate(){
        setupLoan();

        LocalDate getDueDateResult = loan.getDueDate();

        assertEquals(LocalDate.now().plusDays(14),getDueDateResult);
        assertNotEquals(LocalDate.now(),getDueDateResult);
    }
    @Test
    void testIsOverdue(){
        setupLoan();
        
        boolean isOverDueResult = loan.isOverdue();

        assertFalse(isOverDueResult);
    }


}
