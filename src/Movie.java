public class Movie extends Resource{
    String ean;

    public Movie(String author, String title, String identifier) {
        super(author, title, identifier);
        this.ean = identifier;
    }

    public String getEan() {
        return ean;
    }
}
