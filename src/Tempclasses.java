public class Tempclasses {
    /*
    import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // 1. Opret biblioteket
        Library library = new Library();

        // 2. Opret testdata
        Book book1 = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
        Book book2 = new Book("Rachel Cusk", "Omrids", "9788763851664", 2);
        Book book3 = new Book("Yuval Noah Harari", "Sapiens", "9780062316097", 3);

        Member member1 = new Member("Thorkild Hansen", 111);
        Member member2 = new Member("Lise Andersen", 222);
        Member member3 = new Member("Peter Larsen", 333);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addMember(member1);
        library.addMember(member2);
        library.addMember(member3);

        // --- TEST AF CONTAINS() METODEN ---
        IO.println("--- TEST AF CONTAINS() ---");
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        Book searchBook = new Book("Allan B. Downey", "Think Java", "9781492072508", 1);
        Book unaddedBook = new Book("George Orwell", "1984", "9780451524935", 4);

        boolean containsSearchBook = bookList.contains(searchBook);
        boolean containsUnaddedBook = bookList.contains(unaddedBook);

        IO.println("Findes 'Think Java' i listen? " + containsSearchBook);
        IO.println("Findes '1984' i listen? " + containsUnaddedBook);
        IO.println("---------------------------\n");

        // --- OPGAVE 1 TIL 10 TESTER ---
        IO.println("--- OPGAVE 2: getBook() ---");
        Book foundBook = library.getBook(1);
        IO.println(foundBook);
        Book notFoundBook = library.getBook(117);
        IO.println(notFoundBook); // null

        IO.println("\n--- OPGAVE 4: getMember() ---");
        Member foundMember = library.getMember(111);
        IO.println(foundMember);
        Member notFoundMember = library.getMember(999);
        IO.println(notFoundMember); // null

        IO.println("\n--- OPGAVE 6: loanBook() ---");
        IO.println(library.loanBook(1, 111)); // true
        IO.println(library.loanBook(9, 111)); // false
        IO.println(library.loanBook(1, 999)); // false

        IO.println("\n--- OPGAVE 8: returnBook() ---");
        ArrayList<Loan> loans = library.getLoans();
        IO.println(loans);
        IO.println(library.returnBook(1)); // true
        loans = library.getLoans();
        IO.println(loans); // []
        IO.println(library.returnBook(1)); // false
        IO.println(library.returnBook(117)); // false

        IO.println("\n--- OPGAVE 10: findLoansByMemberId() ---");
        library.loanBook(1, 111);
        library.loanBook(2, 111);
        loans = library.findLoansByMemberId(111);
        IO.println(loans);

        library.loanBook(3, 222);
        loans = library.findLoansByMemberId(222);
        IO.println(loans);

        loans = library.findLoansByMemberId(333);
        IO.println(loans); // []

        // Nulstil lån før menu
        library.returnBook(1);
        library.returnBook(2);
        library.returnBook(3);

        // --- INTERAKTIV MENU-LØKKE ---
        IO.println("\n--- INTERAKTIV MENU ---");
        boolean running = true;

        while (running) {
            IO.println();
            IO.println("Books:");
            IO.println("1. " + book1);
            IO.println("2. " + book2);
            IO.println("3. " + book3);
            IO.println("4. Vis medlems lån");
            IO.println("5. Exit");

            int bookChoice = Integer.parseInt(
                    IO.readln("Vælg en bog (1-3), 4 for medlemslån, eller 5 for exit: ")
            );

            if (bookChoice == 5) {
                running = false;
                IO.println("Farvel!");
                continue;
            }

            if (bookChoice == 4) {
                int searchMemberId = Integer.parseInt(IO.readln("Indtast medlems-ID (f.eks. 111, 222, 333): "));
                ArrayList<Loan> memberLoans = library.findLoansByMemberId(searchMemberId);
                IO.println("Lån for medlem " + searchMemberId + ": " + memberLoans);
                continue;
            }

            Book selectedBook = library.getBook(bookChoice);

            if (selectedBook == null) {
                IO.println("Ugyldigt bogvalg.");
                continue;
            }

            IO.println("\nDu valgte:\n" + selectedBook);

            int choice = Integer.parseInt(
                    IO.readln("Tast 1 for at låne bogen eller 2 for at aflevere bogen: ")
            );

            if (choice == 1) {
                IO.println("Vælg medlem:");
                IO.println("1. " + member1);
                IO.println("2. " + member2);
                IO.println("3. " + member3);
                int memberChoice = Integer.parseInt(IO.readln("Vælg medlem (1-3): "));

                int selectedMemberId = -1;
                if (memberChoice == 1) selectedMemberId = 111;
                else if (memberChoice == 2) selectedMemberId = 222;
                else if (memberChoice == 3) selectedMemberId = 333;

                if (selectedMemberId != -1) {
                    if (library.loanBook(selectedBook.getId(), selectedMemberId)) {
                        IO.println("Bogen blev succesfuldt udlånt!");
                    } else {
                        IO.println("Udlån mislykkedes (bogen kan være udlånt eller ID er ugyldigt).");
                    }
                } else {
                    IO.println("Ugyldigt medlemsvalg.");
                }

            } else if (choice == 2) {
                if (library.returnBook(selectedBook.getId())) {
                    IO.println("Bogen blev afleveret.");
                } else {
                    IO.println("Aflevering mislykkedes (bogen var ikke udlånt).");
                }
            } else {
                IO.println("Ugyldigt valg.");
            }
        }
    }
}
     */
}
