public class AudioBook extends Resource {
    private final int lengthMinutes;

    public AudioBook(String author, String title, String isbn, int lengthMinutes) {
        super(author, title, isbn);
        this.lengthMinutes = lengthMinutes;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    @Override
    public String toString() {
        return getCreator() + "; " + getTitle() + "; isbn " + getIdentifier()
                + "; (" + lengthMinutes + " min)";
    }
}