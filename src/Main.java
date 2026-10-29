void main() {
    StandardLoanPolicy standardLoanPolicy = new StandardLoanPolicy();
    Library library = new Library(standardLoanPolicy);

    // Bøger
    Book book1 = new Book("Allan B. Drown inh", "Think Java", "0001", 320);
    Book book2 = new Book("Rachel Cusk", "Omrids", "0002", 256);
    Book book3 = new Book("Edith Inshide", "Sapiens", "0003", 443);
    library.addResource(book1);
    library.addResource(book2);
    library.addResource(book3);


    // Lydbøger
    AudioBook audioBook1 = new AudioBook("Edith Inshide", "Sapiens", "0004", 900);
    library.addResource(audioBook1);


    // Film
    Movie movie1 = new Movie("John Issin", "Toy Story", "0005", "Pixar", 81);
    library.addResource(movie1);

    // Videospil
    VideoGame videoGame1 = new VideoGame("Nintendo", "The Legend of Zelda", "0006", "Nintendo Switch");
    library.addResource(videoGame1);

    // Medlemmer
    Member member1 = new Member("Thorkild Hansen", 111);
    Member member2 = new Member("Lise Andersen", 222);
    Member member3 = new Member("Peter Larsen", 333);

    library.addMember(member1);
    library.addMember(member2);
    library.addMember(member3);


    // Start brugerfladen
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}