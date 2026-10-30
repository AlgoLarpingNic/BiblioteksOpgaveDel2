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

    private void borrowResource() {
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));

        String identifier = IO.readln("Indtast ressource ean/isbn: ");

        LoanResult result = library.loanResource(memberId, identifier);
        switch (result) {
            case SUCCESS -> IO.println("Lån registreret for: " + library.getMember(memberId) + "ved: " + library.getResource(identifier));
            case NOT_PERMITTED -> IO.println("Lånet er ikke tilladt ifølge lånereglerne");
            case MEMBER_NOT_FOUND -> IO.println("Medlem ikke fundet for medlems id: " + memberId);
            case RESOURCE_NOT_FOUND -> IO.println("Intet fundet for indtastning: " + identifier);
            case RESOURCE_NOT_AVAILABLE -> IO.println("Matrialet er ikke tilgængeligt, formegentlig allerede udlånt");
        }
    }

    private void returnResource() {
        String identifier = IO.readln("Indtast ressource isbn/id: ");
        if (library.returnResource(identifier)) {
            IO.println("Aflevering registreret");
        } else {
            IO.println("Materialet er ikke udlånt eller findes ikke");
        }
    }

    private void showLoans() {
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