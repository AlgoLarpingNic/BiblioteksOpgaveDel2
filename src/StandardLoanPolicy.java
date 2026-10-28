import java.time.LocalDate;
import java.util.List;

public class StandardLoanPolicy implements LoanPolicy {
    @Override
    public LocalDate calculateDueDate(Resource resource) {
        return LocalDate.now().plusDays(30);
    }

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> currentLoan) {
        return true;
    }
}
