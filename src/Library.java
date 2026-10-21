import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();
    private Loan loan;
    private Resource resource;
    

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    // Hent bog ud fra bog-ID
    public Resource getResource(String isbn) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(isbn)) {
                return resource;
            }
        }

        return null;
    }

    // Hent medlem ud fra medlems-ID
    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }

        return null;
    }

    // Lån bog
    public boolean loanResource(String resourceIdentifier, int memberId) {

        Member member = getMember(memberId);

        if (resource == null || member == null || !loan.isAvailable()) {
            return false;
        }
        loanResource(resourceIdentifier, memberId);

        Loan loan = new Loan(resource, member);
        loans.add(loan);

        return true;
    }

    // Aflever bog
    public boolean returnResource(String identifier) {

        Loan loanToRemove = null;

        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier() == getResource(identifier).getIdentifier()) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            Objects.requireNonNull(loanToRemove.getResource());
            loans.remove(loanToRemove);

            return true;
        }

        return false;
    }

    // Find alle lån for et bestemt medlem
    public ArrayList<Loan> findLoansByMemberId(int memberId) {

        ArrayList<Loan> memberLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getMember().getMemberId() == memberId) {
                memberLoans.add(loan);
            }
        }

        return memberLoans;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}
