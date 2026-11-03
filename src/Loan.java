import java.time.LocalDate;

public class Loan implements Comparable<Loan>{
    private final Member member;
    private final Resource resource;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate loanDate, LocalDate dueDate) {
        this.resource = resource;
        this.member = member;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getLoanDate() {
        return LocalDate.now();
    }

    public LocalDate getDueDate() {
        return getLoanDate().plusDays(30);
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return resource + "\n"
                + member + "\n"
                + "udlånt: " + getLoanDate() + "\n"
                + "afleveringsfrist: " + getDueDate();
    }

    @Override
    public int compareTo(Loan other) {
        return this.dueDate.compareTo(other.dueDate);
    }
}