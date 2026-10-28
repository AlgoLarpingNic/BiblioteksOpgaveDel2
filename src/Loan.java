import java.time.LocalDate;

public class Loan {
    private final Member member;
    private final Resource resource;
    private final LocalDate loanDate;
    private final LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate dueDate) {
        this.resource = resource;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.dueDate = dueDate;
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

    public LocalDate getDueDate() {
        return loanDate.plusDays(14);
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(getDueDate());
    }

    @Override
    public String toString() {
        return String.format("""
                %s
                %s
                Afleveringsfrist: %s""", getResource(), getMember(), getDueDate());
    }
}
