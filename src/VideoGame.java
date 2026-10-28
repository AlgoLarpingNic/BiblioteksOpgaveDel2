public class VideoGame extends Resource {
    private final String platform;

    public VideoGame(String studio, String title, String ean, String platform) {
        super(studio, title, ean);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return getCreator() + "; " + getTitle() + "; ean " + getIdentifier()
                + "; platform " + platform;
    }
}