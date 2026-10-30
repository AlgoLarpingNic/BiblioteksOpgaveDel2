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
        return dueDate;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return resource + "\n"
                + member + "\n"
                + "afleveringsfrist " + dueDate;
    }


}