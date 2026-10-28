import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TestSuiteResources {
Book book;
AudioBook audioBook;
Movie movie;
VideoGame videoGame;

Member member;
Loan loan;

Library library;

    //CLASSES
    @BeforeEach
    void constructor() {
        book = new Book("Allan B. Drown inh", "Think Java", "0001", 320);
        audioBook = new AudioBook("Edith Inshide",  "Sapiens", "0004", 900);
        movie = new Movie("John Issin", "Toy Story", "0005", "Pixar", 81);
        videoGame = new VideoGame("Nintendo", "The Legend of Zelda", "0006", "Nintendo Switch");
        member = new Member("Mike Oxlong", 69);
        loan = new Loan(videoGame, member);
        library = new Library();
    }

    @Test
    void memberConstructorAndGetters() {
        //arrange (slightly overkill at kalde constructoren i vores tilfælde)
        constructor();

        //act (slightly overkill i det her eksempel) ret member.getName() til resultName hvis ønsket
        String resultName = member.getName();

        //assert
        assertEquals("Mike Oxlong", member.getName());
        assertEquals(69, member.getMemberId());
    }

    //LOAN
    @Test
    void loanDateMemberRegister() {
        assertEquals(loan.getMember(), member);
        assertEquals(loan.getMember().getMemberId(), member.getMemberId());
        assertEquals(LocalDate.now().plusDays(14), loan.getDueDate());

        Loan loanTest = new Loan(movie, member);
        loanTest.getLoanDate().minusDays(15);

        boolean loanTestBool = true;
        if (loanTestBool == loanTest.isOverdue()) {
            loanTestBool = false;
            assertEquals(loanTestBool, loanTest.isOverdue());
        }
    }

    //BOOK
    @Test
    void bookConstructorAndGetters() {
        assertEquals("Allan B. Drown inh", book.getCreator());
        assertEquals("Think Java", book.getTitle());
        assertEquals("0001", book.getIdentifier());
        assertEquals(320, book.getPages());
    }
    @Test
    void bookNotConstructorAndGetters() {
        assertNotEquals("Allan B. Downey", book.getCreator());
        assertNotEquals("Think of Java", book.getTitle());
        assertNotEquals("97814", book.getIdentifier());
        assertNotEquals(67, book.getPages());
    }
    //Audiobook
    @Test
    void audiobookConstructorAndGetters() {
        assertEquals("Edith Inshide", audioBook.getCreator());
        assertEquals("Sapiens", audioBook.getTitle());
        assertEquals("0004", audioBook.getIdentifier());
        assertEquals(900, audioBook.getLengthMinutes());
    }
    @Test
    void audiobookNotConstructorAndGetters() {
        assertNotEquals("Allan B. Downey", audioBook.getCreator());
        assertNotEquals("Think of Java", audioBook.getTitle());
        assertNotEquals("97814", audioBook.getIdentifier());
        assertNotEquals(67, audioBook.getLengthMinutes());
    }
    //Movie
    @Test
    void movieConstructorAndGetters() {
        assertEquals("John Issin", movie.getCreator());
        assertEquals("Toy Story", movie.getTitle());
        assertEquals("0005", movie.getIdentifier());
        assertEquals("Pixar", movie.getStudio());
        assertEquals(81, movie.getLengthMinutes());
    }
    @Test
    void movieNotConstructorAndGetters() {
        assertNotEquals("Allan B. Downey", movie.getCreator());
        assertNotEquals("Think of Java", movie.getTitle());
        assertNotEquals("97814", movie.getIdentifier());
        assertNotEquals("20'th Century", movie.getStudio());
        assertNotEquals(67, movie.getLengthMinutes());
    }
    //Videogame
    @Test
    void videogameConstructorAndGetters() {
        assertEquals("Nintendo", videoGame.getCreator());
        assertEquals("The Legend of Zelda", videoGame.getTitle());
        assertEquals("0006", videoGame.getIdentifier());
        assertEquals("Nintendo Switch", videoGame.getPlatform());
    }
    @Test
    void videogameNotConstructorAndGetters() {
        assertNotEquals("Allan B. Downey", videoGame.getCreator());
        assertNotEquals("Think of Java", videoGame.getTitle());
        assertNotEquals("97814", videoGame.getIdentifier());
        assertNotEquals("PSP", videoGame.getPlatform());
    }


    //LIBRARY FUNKTIONER/METODER
    @Test
    void testLoanWithMember() {
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource("0001", 69);

        assertEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testLoanWithUnknownMember() {
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource("0001", 67);

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testWhenBookIsNotAvailable() {
        library.addMember(member);
        library.addResource(book);

        LoanResult result = library.loanResource("8==D", 69);

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testLoanBookTwice() {
        library.addMember(member);
        library.addResource(book);

        library.loanResource("0001", 69);
        LoanResult result = library.loanResource("0001", 69);

        assertNotEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testOfLoanBookAfterReturn() {
        library.addMember(member);
        library.addResource(book);

        library.loanResource("0001", 69);

        library.returnResource("0001");

        LoanResult result = library.loanResource("0001", 69);

        assertEquals(LoanResult.SUCCESS, result);
    }

    @Test
    void testReturn(){
        library.addMember(member);
        library.addResource(book);

        library.loanResource("0001", 69);

        boolean returnResult = library.returnResource("0001");

        assertTrue(returnResult);
    }


}
