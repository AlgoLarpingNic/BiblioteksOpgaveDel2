import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private final String author;
    private final String title;
    private final String isbn;
    private final int id;

    private Member borrowedBy;
    private LocalDate borrowedDate;

    public Book(String author, String title, String isbn, int id) {
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.id = id;
        this.borrowedBy = null;
        this.borrowedDate = null;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }

    public boolean loanBook(Member member) {
        if (isAvailable()) {
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        }

        return false;
    }

    public void returnBook() {
        borrowedBy = null;
        borrowedDate = null;
    }

    public LocalDate getDueDate() {
        if (borrowedDate == null) {
            return null;
        }

        return borrowedDate.plusDays(14);
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        return id == book.id &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, id);
    }

    @Override
    public String toString() {
        return author + "; " + title +
                "; isbn " + isbn +
                "; (" + id + ")";
    }
}
