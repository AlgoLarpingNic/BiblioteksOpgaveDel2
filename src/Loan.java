import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final Member member;
    private final LocalDate loanDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
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

    @Override
    public String toString() {
        return book.toString() +
                "\n" + member.toString() +
                ",\nafleveringsfrist: " + getDueDate();
    }
}
