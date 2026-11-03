import java.util.Comparator;

public class ResourceCreatorComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource resource1, Resource resource2) {
        String creator1 = resource1.getCreator();
        String creator2 = resource2.getCreator();
        return creator1.compareTo(creator2);
    }
}

