public class Movie extends Resource {
    private final String studio;
    private final int lengthMinutes;

    public Movie(String director, String title, String ean, String studio, int lengthMinutes) {
        super(director, title, ean);
        this.studio = studio;
        this.lengthMinutes = lengthMinutes;
    }

    public String getStudio() {
        return studio;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    @Override
    public String toString() {
        return studio + "; " + getTitle() + "; ean " + getIdentifier()
                + "; instruktør " + getCreator() + "; (" + lengthMinutes + " min)";
    }
}