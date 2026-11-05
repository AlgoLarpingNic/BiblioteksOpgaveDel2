import java.util.Comparator;

public class ResourceTitleComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource resource1, Resource resource2) {
        String title1 = resource1.getTitle();
        String title2 = resource2.getTitle();
        return title1.compareTo(title2);
    }
}
