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
        this.borrowedDate = null;
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

    //check availability
    public boolean isAvailable() {
        return member == null;
    }

    //lån-objekt-funktion
    public boolean loanMaterial(Member member) {
        if (isAvailable()) {
            this.member = member;
            borrowedDate = LocalDate.now();
            return true;
        }
        return false;
    }

    //afleveringsfunktion
    public void returnMaterial() {
        member = null;
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
        return object.getIdentifier() == object.getIdentifier() && Objects.equals((resource.getIdentifier()), object.getIdentifier());
    }

    @Override
    public String toString() {
        return resource.getCreator() + "; " + resource.getTitle() +
                "; isbn " + resource.getIdentifier() +
                "; (" + resource.getIdentifier() + ")" + member;
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource.getIdentifier(), resource.getIdentifier());
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
