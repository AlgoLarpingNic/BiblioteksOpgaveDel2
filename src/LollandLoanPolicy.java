import java.time.LocalDate;
import java.util.List;

public class LollandLoanPolicy implements LoanPolicy{


    @Override
    public LocalDate calculateDueDate(Resource resource) {
        if(resource instanceof Book){
            LocalDate.now().plusDays(45);
        } else {
            LocalDate.now().plusDays(30);
        }
       return null;
    }

    @Override
    public boolean canLoan(Resource resource, Member member, List<Loan> currentLoan) {
        return true;
    }
}
