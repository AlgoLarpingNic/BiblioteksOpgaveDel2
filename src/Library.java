import java.util.ArrayList;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();


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

    // Lån ressource
    public boolean loanResource(String resourceIdentifier, int memberId) {
        Resource resource = getResource(resourceIdentifier);
        Member member = getMember(memberId);
        if (member == null) {
            return LoanResult.MEMBER_NOT_FOUND;
        }

        if (resource == null || member == null) {
            return false;
        }

        // Tjek om ressourcen allerede er udlånt
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(resourceIdentifier)) {
                return false; // Allerede udlånt
            }
        }

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