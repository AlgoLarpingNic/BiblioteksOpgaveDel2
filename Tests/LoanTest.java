import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class LoanTest {
    Book book;
    Member member;
    Loan loan;
    LocalDate dueDate = LocalDate.now().plusDays(14);
    
    @BeforeEach
    void setupLoan(){
        book = new Book("Ben Clover", "Rolling off the deep end", "80085", 420);
        member = new Member("Mike Wazawski", 111);
        loan = new Loan(book, member, dueDate);

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

        LocalDate getDueDateResult = dueDate;
        assertEquals(LocalDate.now().plusDays(30), getDueDateResult);
        assertNotEquals(LocalDate.now(), getDueDateResult);
    }
    @Test
    void testIsOverdue(){
        setupLoan();
        
        boolean isOverDueResult = loan.isOverdue();

        assertFalse(isOverDueResult);
    }


}
