import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();
    private LoanPolicy loanPolicy;


    public Library(LoanPolicy loanPolicy) {
        this.loanPolicy = loanPolicy;
    }

    //add metoder til oprettelse af ressourcer og members
    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    // Hent ressource ud fra identifier
    public Resource getResource(String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
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

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    // Lån bog
    public boolean isResourceloaned(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    public LoanResult loanResource(String identifier, int memberId) {
        Member member = getMember(memberId);
        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }

        Resource resource = getResource(identifier);
        if (resource == null) {
            return LoanResult.RESOURCE_NOT_FOUND;
        }
        if (loanPolicy.canLoan(resource, member, loans)) {
            return LoanResult.RESOURCE_NOT_AVAILABLE;
        }

        if (!loanPolicy.canLoan(resource, member, loans)) {
            return LoanResult.NOT_PERMITTED;
        }


        LocalDate dueDate = loanPolicy.calculateDueDate(resource);
        Loan loan = new Loan(resource, member, dueDate);
        loans.add(loan);

        return LoanResult.SUCCESS;
    }

    // Aflever <objekt/matriale/resource>
    public boolean returnResource(String identifier) {
        Loan loanToRemove = null;
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
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

    public ArrayList<Loan> findOverdueLoans() {
        ArrayList<Loan> overdue = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                overdue.add(loan);
            }
        }
        return overdue;
    }
}
