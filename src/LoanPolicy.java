import java.time.LocalDate;
import java.util.List;

public interface LoanPolicy {
    LocalDate calculateDueDate(Resource resource);
    boolean canLoan(Resource resource, Member member, List<Loan> currentLoan);


}
