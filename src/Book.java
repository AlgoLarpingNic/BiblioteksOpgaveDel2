public class Book extends Resource {
    String isbn;

    public Book(String creator, String title, String identifier) {
        super(creator, title, identifier);
        this.isbn = identifier;
    }


}
