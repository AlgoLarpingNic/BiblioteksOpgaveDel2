import java.time.LocalDate;
import java.util.List;

public class AalborgLoanPolicy implements LoanPolicy {
    private final int eanLoanLimit = 3;

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> currentLoans) {
        if (resource instanceof Movie || resource instanceof VideoGame) {
            return false;
        }

        int eanCount = 0;
        for (Loan loan : currentLoans) {
            if (loan.getMember().getMemberId() == member.getMemberId()) {
                Resource borrowed = loan.getResource();
                if (borrowed instanceof Movie || borrowed instanceof VideoGame) {
                    eanCount++;
                }
            }
        }
        return eanCount < eanLoanLimit;
    }

    @Override
    public LocalDate calculateDueDate(Resource resource) {
        return LocalDate.now().plusDays(30);
    }
}
