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
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldigt valg. Prøv igen.");
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

    private void borrowResource() {
        IO.println(library.getMembers());
        int memberId = Integer.parseInt(
                IO.readln("Indtast medlemsnummer: ")
        );
        String isbn = IO.readln("Indtast ressource id/isbn: ");
        IO.println(library.getResource(isbn));

        if (library.loanResource(isbn, memberId)) {
            IO.println("Lån registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

    private void returnResource() {
        IO.println(library.getResources());
        String isbn = IO.readln("Indtast ressource isbn/id: ");

        if (library.returnResource(isbn)) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Der er sket en fejl");
        }
    }

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