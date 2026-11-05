void main() throws IOException {
    Path path = Path.of("csv_ting");
    Files.createDirectories(path);

    LibrarySaver saver = new LibrarySaver(path);
    LibraryLoader loader = new LibraryLoader(path);

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);

    if (library.getResources().isEmpty() && library.getMembers().isEmpty()) {
        IO.println("Ingen data fundet, opretter filer");

        // Medlemmer
        library.addMember(new Member("Thorkild Hansen", 111));
        library.addMember(new Member("Lise Andersen", 222));
        library.addMember(new Member("Peter Larsen", 333));

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

        // Gem lånasd
        saver.saveLoan(library.getLoans(), "loans.csv");

        IO.println("Data gemt korrekt." + "\n" + loader.readBook() + "\n" + loader.readAudiobook() + "\n" + loader.readMovie() + "\n" + loader.readVideogame() + "\n" + loader.readMember() + "\n" + loader.readLoans(library));
    } catch (Exception e) {
        IO.println("Kunne ikke gemme data: " + e.getMessage());
    }

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

}