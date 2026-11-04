void main() throws IOException {
    Path path = Path.of("csv_ting");
    Files.createDirectories(path);

//    LibrarySaver saver = new LibrarySaver(path);
    LibraryLoader loader = new LibraryLoader(path);

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);

    try {
        // Bøger
        for (Book book : loader.readBook()) {
            library.addResource(book);
        }
        // Lydbøger
        for (AudioBook audioBook : loader.readAudiobook()) {
            library.addResource(audioBook);
        }
        // Film
        for (Movie movie : loader.readMovie()) {
            library.addResource(movie);
        }
        // Videospil
        for (VideoGame videoGame : loader.readVideogame()) {
            library.addResource(videoGame);
        }
        // Medlemmer
        for (Member member : loader.readMember()) {
            library.addMember(member);
        }
        // Lån
        for (Loan loan : loader.readLoans(library)) {
            library.addLoan(loan);
        }
        IO.println("Data indlæst korrekt.");
    } catch (IOException e){
        IO. println("Kunne ikke indlæse alle filer: " + e.getMessage());
        }

    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();

/*
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
        Loan loan = new Loan(library.getResource("0001"), library.getMember(111), LocalDate.now(), LocalDate.now().plusDays(30));
        library.addLoan(loan);
        saver.saveLoan(library.getLoans(), "loans.csv");

        IO.println("Data gemt korrekt." + "\n" + loader.readBook() + "\n" + loader.readAudiobook() + "\n" + loader.readMovie() + "\n" + loader.readVideogame() + "\n" + loader.readMember() + "\n" + loader.readLoans(library));
    } catch (Exception e) {
        IO.println("Kunne ikke gemme data: " + e.getMessage());
    }
*/

}




























        /*
        tilhørende metoden ian ikke ville have vi brugte desv. :c
        saver.saveResource(library.getResources(), Book.class, "books.csv");
        saver.saveResource(library.getResources(), AudioBook.class, "audiobooks.csv");
        saver.saveResource(library.getResources(), Movie.class, "movies.csv");
        saver.saveResource(library.getResources(), VideoGame.class, "videogames.csv");
        */