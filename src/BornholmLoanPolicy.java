import java.time.LocalDate;
import java.util.List;

public class BornholmLoanPolicy implements LoanPolicy {
    @Override
    public LocalDate calculateDueDate(Resource resource) {
        if (resource instanceof AudioBook) {
            return LocalDate.now().plusDays(14);
        }
        return LocalDate.now().plusDays(30);
    }


    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> currentLoan) {
        return true;
    }
}
