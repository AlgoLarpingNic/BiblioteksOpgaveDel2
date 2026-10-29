void main() {
    StandardLoanPolicy standardLoanPolicy = new StandardLoanPolicy();
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



    // Start brugerfladen
    ConsoleUI consoleUI = new ConsoleUI(library);
    consoleUI.run();
}