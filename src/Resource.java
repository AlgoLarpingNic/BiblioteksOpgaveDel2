public abstract class Resource {
    private final String creator;
    private final String title;
    private final String identifier;

    public Resource(String creator, String title, String identifier) {
        this.creator = creator;
        this.title = title;
        this.identifier = identifier;
    }

    public String getCreator() {
        return creator;
    }

    public String getTitle() {
        return title;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return creator + "; " + title + "; " + identifier;
    }
}