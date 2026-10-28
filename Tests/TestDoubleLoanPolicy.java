import java.time.LocalDate;
import java.util.List;

public class TestDoubleLoanPolicy implements LoanPolicy{
    public boolean canLoanCalled = false;
    public boolean calculateDueDateCalled = false;

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> currentLoan) {
        canLoanCalled = true;
        return true;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource) {
        calculateDueDateCalled = true;
        return LocalDate.now().plusDays(30);
    }
}