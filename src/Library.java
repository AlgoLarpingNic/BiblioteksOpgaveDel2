import java.util.ArrayList;

public class Library {

    private ArrayList<Resource> resources = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

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

        if (resource == null || member == null) {
            return false;
        }

        // Tjek om ressourcen allerede er udlånt
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(resourceIdentifier)) {
                return false; // Allerede udlånt
            }
        }

        Loan loan = new Loan(resource, member);
        loans.add(loan);

        return true;
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