void main() {
    StandardLoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    Library library = new Library(standardLoanPolicy);

    // Bøger
    List<Book> books = List.of(
    new Book("Allan B. Drown inh",  "Think Java",   "0001", 320),
    new Book("Rachel Cusk",         "Omrids",       "0002", 256),
    new Book("Edith Inshide",       "Sapiens",      "0003", 443)
    );

    // Lydbøger
    List<AudioBook> audioBooks = List.of(
    new AudioBook("Edith Inshide",  "Sapiens",      "0004", 900)
    );

    // Film
    List<Movie> movies = List.of(
    new Movie("John Issin",     "Toy Story",        "0005", "Pixar", 81)
    );

    // Videospil
    List<VideoGame> videoGames = List.of(
    new VideoGame("Nintendo",   "The Legend of Zelda",  "0006", "Nintendo Switch")
    );
    // Medlemmer
    List<Member> members = List.of(
    new Member("Thorkild Hansen", 111),
    new Member("Lise Andersen", 222),
    new Member("Peter Larsen", 333)
    );

    // Start brugerfladen
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}