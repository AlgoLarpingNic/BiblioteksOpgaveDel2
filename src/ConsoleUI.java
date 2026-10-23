public class ConsoleUI {
    private final Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;

        while (running) {

            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast valg: "));
            switch (choice) {
                case 1 -> borrowResource();
                case 2 -> returnResource();
                case 3 -> showLoans();
                case 4 -> showOverdueLoans();
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
        IO.println("4. Vis overskredne lån");
        IO.println("0. Afslut");
        IO.println();
    }

    // Opgave 5/6 7: Lån en bog
    private void borrowResource() {
        IO.println(library.getMembers());
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        IO.println(library.getResources());
        String identifier = IO.readln("Indtast isbn/ean: ");

        LoanResult result = library.loanResource(identifier, memberId);
        switch (result) {
            case SUCCESS -> IO.println("Lån registreret for: " + library.getResource(identifier));
            case MEMBER_NOT_FOUND -> IO.println("Medlem ikke fundet");
            case RESOURCE_NOT_FOUND -> IO.println("Intet fundet for indtastning: " + identifier);
            case RESOURCE_NOT_AVAILABLE -> IO.println("Matrialet er ikke tilgængeligt, formegentlig allerede udlånt");
        }
    }

    // Opgave 8/9: Aflever en bla bla
    private void returnResource() {
        IO.println(library.getResources());
        String identifier = IO.readln("Indtast materiale-id (isbn/ean): ");

        if (library.returnResource(identifier)) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Materialet er ikke udlånt eller findes ikke");
        }
    }
    //vis lån
    private void showLoans() {
        IO.println(library.getMembers());
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        var loans = library.findLoansByMemberId(memberId);

        if (loans.isEmpty()) {
            IO.println("Ingen udlån");
        } else {
            for (Loan loan : loans) {
                IO.println(loan);
                IO.println();
            }
        }
    }

    private void showOverdueLoans() {
        var overdue = library.findOverdueLoans();

        if (overdue.isEmpty()) {
            IO.println("Ingen overskredne lån");
        } else {
            for (Loan loan : overdue) {
                IO.println(loan);
                IO.println();
            }
        }
    }

}