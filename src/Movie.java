public class Movie extends Resource {
    private final String director;
    private final int lengthMinutes;

    public Movie(String studio, String title, String director, String ean, int lengthMinutes) {
        super(studio, title, ean);
        this.director = director;
        this.lengthMinutes = lengthMinutes;
    }

    public String getDirector() {
        return director;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    @Override
    public String toString() {
        return getCreator() + "; " + getTitle() + "; ean " + getIdentifier()
                + "; instruktør " + getDirector() + "; (" + lengthMinutes + " min)";
    }
}