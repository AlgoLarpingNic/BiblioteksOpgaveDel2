import java.util.Comparator;

public class LoanLoanDateComparator implements Comparator<Loan> {

    @Override
    public int compare(Loan loan1, Loan loan2) {
        return loan1.getLoanDate().compareTo(loan2.getLoanDate());
    }
}
