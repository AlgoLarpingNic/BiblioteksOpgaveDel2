public class AudioBook extends Resource {
    String isbn;

    public AudioBook(String author, String title, String identifier) {
        super(author, title, identifier);
        this.isbn = identifier;
    }

    public String getIsbn() {
        return isbn;
    }
}
