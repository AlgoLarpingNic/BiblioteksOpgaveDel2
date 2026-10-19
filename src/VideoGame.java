public class VideoGame extends Resource {
    String ean;

    public VideoGame(String author, String title, String identifier) {
        super(author, title, identifier);
        this.ean = identifier;
    }

}
