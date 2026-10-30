void main() {
    Path path = Path.of("savedResources.csv");
    String delimiter = ",";
    StandardLoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    LibrarySaver saver = new LibrarySaver(path, delimiter);
    Library library = new Library(standardLoanPolicy);

    // Bøger
    library.addResource(new Book("Allan B. Drown inh",  "Think Java",   "0001", 320));
    library.addResource(new Book("Rachel Cusk",         "Omrids",       "0002", 256));
    library.addResource(new Book("Edith Inshide",       "Sapiens",      "0003", 443));

    // Lydbøger
    library.addResource(new AudioBook("Edith Inshide",  "Sapiens",      "0004", 900));

    // Film
    library.addResource(new Movie("John Issin",     "Toy Story",        "0005", "Pixar", 81));

    // Videospil
    library.addResource(new VideoGame("Nintendo",   "The Legend of Zelda",  "0006", "Nintendo Switch"));


    // Medlemmer
    library.addMember(new Member ("Thorkild Hansen", 111));
    library.addMember(new Member("Lise Andersen", 222));
    library.addMember(new Member("Peter Larsen", 333));

    try {
        //Gem ressourcer
        saver.saveResource(library.getResources(), "resources.csv");
        saver.saveBook(library.getResources(), "books.csv");
        saver.saveAudiobook(library.getResources(), "audiobooks.csv");
        saver.saveMovie(library.getResources(), "movies.csv");
        saver.saveVideogame(library.getResources(), "videogames.csv");

        // Gem medlemmer
        saver.saveMember(library.getMembers(), "members.csv");

        //Gem lån
        saver.saveLoan(library.getLoans(), "loans.csv");

    } catch (Exception e) {
        IO.println("Kunne ikke gemme data: " + e.getMessage());

        /*
        tilhørende metoden ian ikke ville have vi brugte desv. :c
        saver.saveResource(library.getResources(), Book.class, "books.csv");
        saver.saveResource(library.getResources(), AudioBook.class, "audiobooks.csv");
        saver.saveResource(library.getResources(), Movie.class, "movies.csv");
        saver.saveResource(library.getResources(), VideoGame.class, "videogames.csv");
        */

    }

    // Start brugerfladen
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}