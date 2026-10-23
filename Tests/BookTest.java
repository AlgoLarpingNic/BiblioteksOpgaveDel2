import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    Book book;

    @BeforeEach
    void setup() {
        book = new Book("Mike Litoris", "About you", "8008", 67);
    }

    @Test
    void testGetCreator() {
        setup();

        String creatorResult = book.getCreator();

        //assert
        assertEquals("Mike Litoris", creatorResult);
        assertNotNull(book.getCreator(), creatorResult);

    }

    @Test
    void testGetPages() {
        setup();

        int pageResult = book.getPages();

        assertEquals(67, pageResult);
        assertNotEquals(-1, pageResult);
    }
}
