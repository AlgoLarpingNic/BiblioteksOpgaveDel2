import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDoubleLibrary {
    @Test
    void libraryTestsCanLoanAndCalculateDueDate() {
        // Arrange
        TestDoubleLoanPolicy testDouble = new TestDoubleLoanPolicy();
        Library library = new Library(testDouble);

        library.addMember(new Member("Test", 111));
        library.addResource(new Book("Forfatter", "Titel", "12345", 200));

        // Act
        LoanResult result = library.loanResource("12345", 111);

        // Assert
        assertEquals(LoanResult.SUCCESS, result);
        assertTrue(testDouble.canLoanCalled);
        assertTrue(testDouble.calculateDueDateCalled);


    }
}

