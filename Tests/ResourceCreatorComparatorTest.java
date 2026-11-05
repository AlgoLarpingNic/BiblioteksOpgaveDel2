
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceCreatorComparatorTest {
    @Test
    void resourceCreatorComparatorTest() {
        //
        LoanPolicy loanPolicy = new StandardLoanPolicy();
        Library library = new Library(loanPolicy);
        library.getResources();
        library.addResource(new Book("Allan B. Drown inh", "Think Java", "0001", 320));
        library.addResource(new Book("Rachel Cusk", "Omrids", "0002", 256));
        library.addResource(new Book("Edith Inshide", "Sapiens", "0003", 443));
        List<Resource> temp1 = new ArrayList<>();

        temp1.add(new Book("Allan B. Drown inh", "Think Java", "0001", 320));
        temp1.add(new Book("Rachel Cusk", "Omrids", "0002", 256));
        temp1.add(new Book("Edith Inshide", "Sapiens", "0003", 443));
        List<Resource> temp = new ArrayList<>();
        temp = library.getResources();

        //
        temp.sort(new ResourceCreatorComparator());


        //assert
        assertNotEquals(temp, temp1);
    }


}

