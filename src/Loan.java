import java.time.LocalDate;
import java.util.Objects;

public class Loan {
    private final Resource resource;
    private final Member member;
    private final LocalDate loanDate;
    private Member borrowedBy;
    private LocalDate borrowedDate;

    public Loan(Resource resource, Member member) {
        this.resource = resource;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.borrowedBy = null;
        this.borrowedDate = null;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
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

    //check availability
    public boolean isAvailable() {
        return borrowedBy == null;
    }

    //lån-objekt-funktion
    public boolean loanMaterial(Member member) {
        if (isAvailable()) {
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        }
        return false;
    }

    //afleveringsfunktion
    public void returnMaterial() {
        borrowedBy = null;
        borrowedDate = null;
    }


    //objekt referere til hvilket som helst objekt (bog/spil/lydbog, etc)
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        //hvis objektet ikke findes eller at klassen != objektet af klasse-typen ...
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        //objekt = o
        Resource object = (Resource) o;
        return isbn == object.isbn && Objects.equals(isbn, object.isbn);
    }

    @Override
    public String toString() {
        return creator + "; " + title +
                "; isbn " + isbn +
                "; (" + ean + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, ean);
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


    @Override
    public String toString() {
        return book.toString() +
                "\n" + member.toString() +
                ",\nafleveringsfrist: " + getDueDate();
    }
}
