public class Book extends Resource {
    private final int pages;

    public Book(String author, String title, String isbn, int pages) {
        super(author, title, isbn);
        this.pages = pages;
    }

    public int getPages() {
        return pages;
    }
    @Override
    public String toString() {
        return getCreator() + "; " + getTitle() + "; isbn " + getIdentifier()
                + "; (" + pages + " sider)";
    }
}
