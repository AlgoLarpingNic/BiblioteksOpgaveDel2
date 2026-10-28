public class Book extends Resource {
    private final int pages;

    public Book(String author, String title, String isbn, int pages) {
        super(author, title, isbn);
        this.pages = pages;
    }

    @Override
    public String getIdentifier() {
        return isbn;
    }
}