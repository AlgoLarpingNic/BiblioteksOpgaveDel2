void main() throws IOException {
    Path path = Path.of("csv_ting");
    Files.createDirectories(path);

    LibrarySaver saver = new LibrarySaver(path);
    LibraryLoader loader = new LibraryLoader(path);



    // Bøger
    library.addResource(new Book("Allan B. Drown inh", "Think Java", "0001", 320));
    library.addResource(new Book("Rachel Cusk", "Omrids", "0002", 256));
    library.addResource(new Book("Edith Inshide", "Sapiens", "0003", 443));

        // Bøger
        library.addResource(new Book("Allan B. Downey", "Think Java", "0001", 450));
        library.addResource(new Book("Rachel Cusk", "Omrids", "0002", 280));
        library.addResource(new Book("Yuval Noah Harari", "Sapiens", "0003", 512));

        // Lydbøger
        library.addResource(new AudioBook("Rachel Cusk", "Omridset", "0004", 900));

        //film
        library.addResource(new Movie("Pixar", "Toy Story", "Guy Richie", "0005", 123));

        //videospil
        library.addResource(new VideoGame("Nintendo", "Super Smash", "0006", "Nintendo switch"));

        Loan loan = new Loan(library.getResource("0001"), library.getMember(111), LocalDate.now(), LocalDate.now().plusDays(30));
        library.addLoan(loan);


        IO.println("Eksempeldata oprettet.");
    }

    try {
        //Gem ressourcer
        saver.saveResource(library.getResources(), "resources.csv");
        saver.saveBook(library.getResources(), "books.csv");
        saver.saveAudiobook(library.getResources(), "audiobooks.csv");
        saver.saveMovie(library.getResources(), "movies.csv");
        saver.saveVideogame(library.getResources(), "videogames.csv");

        // Gem medlemmer
        saver.saveMember(library.getMembers(), "members.csv");

        // Gem lån
        saver.saveLoan(library.getLoans(), "loans.csv");

        IO.println("Data gemt korrekt." + "\n" + loader.readBook() + "\n" + loader.readAudiobook() + "\n" + loader.readMovie() + "\n" + loader.readVideogame() + "\n" + loader.readMember() + "\n" + loader.readLoans(library));
    } catch (Exception e) {
        IO.println("Kunne ikke gemme data: " + e.getMessage());
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

    Collator SvCollator = Collator.getInstance(new Locale("sv"));

    library.getLoans().sort(null);
    IO.println(library.getResources());
    library.getResources().sort((SvCollator));
    IO.println(library.getResources());
        /*
        tilhørende metoden ian ikke ville have vi brugte desv. :c
        saver.saveResource(library.getResources(), Book.class, "books.csv");
        saver.saveResource(library.getResources(), AudioBook.class, "audiobooks.csv");
        saver.saveResource(library.getResources(), Movie.class, "movies.csv");
        saver.saveResource(library.getResources(), VideoGame.class, "videogames.csv");
        */


    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();

}