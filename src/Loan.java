import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final Resource resource;
    private final LocalDate loanDate;
    private Member member;
    private LocalDate borrowedDate;

    public Loan(Resource resource, Member member) {
        this.resource = resource;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.borrowedDate = LocalDate.now();
    }

    public Member getBorrowedBy() {
        return member;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getDueDate() {
        if (borrowedDate == null) {
            return null;
        }
        return borrowedDate.plusDays(14);
    }

    public boolean isAvailable() {
        return member == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(resource, loan.resource) && Objects.equals(member, loan.member);
    }

    @Override
    public String toString() {
        return resource.getCreator() + "; " + resource.getTitle() +
                "; isbn " + resource.getIdentifier() +
                "; Lånt af: " + member;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, member);
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }
}