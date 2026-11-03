void main() throws IOException {
    Path path = Path.of("/csv_ting");
    Files.createDirectories(path);
    String delimiter = ",";
    StandardLoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    LibrarySaver saver = new LibrarySaver(path, delimiter);
    Library library = new Library(standardLoanPolicy);
    LibraryLoader loader = new LibraryLoader(path);

    Collator SvCollator = Collator.getInstance(new Locale("sv"));


    // Bøger
    library.addResource(new Book("Allan B. Drown inh", "Think Java", "0001", 320));
    library.addResource(new Book("Rachel Cusk", "Omrids", "0002", 256));
    library.addResource(new Book("Edith Inshide", "Sapiens", "0003", 443));

    // Lydbøger
    library.addResource(new AudioBook("Edith Inshide", "Sapiens", "0004", 900));

    // Film
    library.addResource(new Movie("John Issin", "Toy Story", "0005", "Pixar", 81));

    // Videospil
    library.addResource(new VideoGame("Nintendo", "The Legend of Zelda", "0006", "Nintendo Switch"));


    // Medlemmer
    library.addMember(new Member("Thorkild Hansen", 111));
    library.addMember(new Member("Lise Andersen", 222));
    library.addMember(new Member("Peter Larsen", 333));

    Loan loan1 = new Loan(library.getResource("0001"), library.getMember(111), LocalDate.now().plusDays(14), LocalDate.now());
    library.addLoan(loan1);

    try {
        //Gem ressourcer
        saver.saveResource(library.getResources(), path + "/resources.csv");
        saver.saveBook(library.getResources(), path + "/books.csv");
        saver.saveAudiobook(library.getResources(), path + "/audiobooks.csv");
        saver.saveMovie(library.getResources(), path + "/movies.csv");
        saver.saveVideogame(library.getResources(), path + "/videogames.csv");

        // Gem medlemmer
        saver.saveMember(library.getMembers(), path + "/members.csv");

        //Gem lån
        saver.saveLoan(library.getLoans(), path + "/loans.csv");

    } catch (Exception e) {
        IO.println("Kunne ikke gemme data: " + e.getMessage());
    }


    try {
        IO.println(loader.readBook());
    } catch (Exception e) {
        IO.println("nej");
    }
    try {
        IO.println(loader.readLoans(library));
    } catch (Exception e) {
        IO.println("nej");
    }
    try {
        IO.println(loader.readMember());
    } catch (Exception e) {
        IO.println("nej");
    }
    try {
        IO.println(loader.readAudiobook());
    } catch (Exception e) {
        IO.println("nej");
    }
    try {
        IO.println(loader.readMovie());
    } catch (Exception e) {
        IO.println("nej");
    }

    library.getLoans().sort(null);
    IO.println(library.getResources());
    Collections.sort(library.getResources(), new ResourceCreatorComparator());
    IO.println(library.getResources());
        /*
        tilhørende metoden ian ikke ville have vi brugte desv. :c
        saver.saveResource(library.getResources(), Book.class, "books.csv");
        saver.saveResource(library.getResources(), AudioBook.class, "audiobooks.csv");
        saver.saveResource(library.getResources(), Movie.class, "movies.csv");
        saver.saveResource(library.getResources(), VideoGame.class, "videogames.csv");
        */


    // Start brugerfladen
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}