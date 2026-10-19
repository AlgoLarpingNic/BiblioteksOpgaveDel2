public class Main {

    public void main() {

        // Opret bibliotek
        Library library = new Library();

        // Opret bøger
        Book book1 = new Book(
                "Allan B. Downey",
                "Think Java",
                "9781492072508"
        );

        Book book2 = new Book(
                "Rachel Cusk",
                "Omrids",
                "9788763851664"
        );

        Book book3 = new Book(
                "Yuval Noah Harari",
                "Sapiens",
                "9780062316097"
        );

        // Opret medlemmer
        Member member1 = new Member(
                "Thorkild Hansen",
                111
        );

        Member member2 = new Member(
                "Lise Andersen",
                222
        );

        Member member3 = new Member(
                "Peter Larsen",
                333
        );

        // Tilføj bøger til biblioteket
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Tilføj medlemmer til biblioteket
        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        // Start brugerfladen
        ConsoleUI consoleUI = new ConsoleUI(library);
        consoleUI.run();
    }
}
