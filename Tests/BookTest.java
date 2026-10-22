import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    void testGetCreator() {
        Book book = new Book("Mike Litoris", "About you", "8008", 67);
        String creatorResult = book.getCreator();
        int pageResult = book.getPages();

        //assert
        assertEquals("Mike Litoris", creatorResult);
        assertNotNull(book.getCreator(), creatorResult);
        assertEquals(67, pageResult);
        assertNotEquals(-1, pageResult);

    }
}
