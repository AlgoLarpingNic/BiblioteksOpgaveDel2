public class ConsoleUI {

    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {

        boolean running = true;

        while (running) {

            showMenu();


            int choice = Integer.parseInt(
                    IO.readln("Indtast valg: ")
            );

            switch (choice) {

                case 1 -> borrowBook();

                case 2 -> returnBook();

                case 3 -> showLoans();

                case 0 -> running = false;

                default -> IO.println(
                        "Ugyldigt valg. Prøv igen."
                );
            }
        }
    }

    private void showMenu() {

        IO.println();
        IO.println("1. Lån");
        IO.println("2. Aflever");
        IO.println("3. Vis alle lån");
        IO.println("0. Afslut");
        IO.println();
    }

    // Opgave 5/6/7: Lån en bog
    private void borrowBook() {
        IO.println(library.getMembers());
        int memberId = Integer.parseInt(
                IO.readln("Indtast medlemsnummer: ")
        );
        IO.println(library.getBooks());
        int bookId = Integer.parseInt(
                IO.readln("Indtast bog id: ")
        );

        if (library.loanBook(bookId, memberId)) {
            IO.println("Lån registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    // Opgave 8/9: Aflever en bog
    private void returnBook() {
        IO.println(library.getBooks());
        int bookId = Integer.parseInt(
                IO.readln("Indtast bog id: ")
        );

        if (library.returnBook(bookId)) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    // Opgave 10/11: Vis lån for et medlem
    private void showLoans() {
        IO.println(library.getMembers());
        int memberId = Integer.parseInt(
                IO.readln("Indtast medlemsnummer: ")
        );

        var loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            IO.println("Ingen udlån");
        } else {

            for (Loan loan : loans) {
                IO.println(loan);
            }
        }
    }

}
