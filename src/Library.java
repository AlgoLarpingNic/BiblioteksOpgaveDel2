import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {

    private final List<Resource> resources = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<Loan> loans = new ArrayList<>();
    private final LoanPolicy loanPolicy;


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

    // Hent ressource ud fra ID/ISBN
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

    public boolean isResourceLoaned(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return true;
            }
        }
        return false;
    }

    // Lån ressource
    public LoanResult loanResource(int memberId, String identifier) {
        Member member = getMember(memberId);
        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }
        Resource resource = getResource(identifier);
        if (resource == null) {
            return LoanResult.RESOURCE_NOT_FOUND;
        }
        if (isResourceLoaned(identifier)) {
            return LoanResult.RESOURCE_NOT_AVAILABLE;
        }
        // Spørg policy om lånet er tilladt
        if (!loanPolicy.canLoan(resource, member, loans)) {
            return LoanResult.NOT_PERMITTED;
        }
        LocalDate dueDate = loanPolicy.calculateDueDate(resource);
        Loan loan = new Loan(resource, member, dueDate);
        loans.add(loan);
        return LoanResult.SUCCESS;
    }

    // Aflever ressource
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
    public List<Loan> findLoansByMemberId(int memberId) {
        List<Loan> memberLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().getMemberId() == memberId) {
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }

    public List<Loan> findOverdueLoans() {
        List<Loan> overdue = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.isOverdue()) {
                overdue.add(loan);
            }
        }
        return overdue;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}