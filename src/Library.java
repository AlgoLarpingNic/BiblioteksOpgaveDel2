import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    // Hent bog ud fra bog-ID
    public Book getBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
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
    public boolean loanBook(int bookId, int memberId) {

        Book book = getBook(bookId);
        Member member = getMember(memberId);

        if (book == null || member == null || !book.isAvailable()) {
            return false;
        }

        book.loanBook(member);

        Loan loan = new Loan(book, member);
        loans.add(loan);

        return true;
    }

    // Aflever bog
    public boolean returnBook(int bookId) {

        Loan loanToRemove = null;

        for (Loan loan : loans) {
            if (loan.getBook().getId() == bookId) {
                loanToRemove = loan;
                break;
            }
        }

        if (loanToRemove != null) {
            loanToRemove.getBook().returnBook();
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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }
}
