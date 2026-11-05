import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {
    private Path path;
    private final String delimiter = ",";

    public LibraryLoader(Path path) {
        this.path = path;
    }

    public Book bookFromCsv(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Book(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]));
    }
    public List<Book> readBook() throws IOException {
        List<Book> booksLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("books.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Book book = bookFromCsv(line);
                booksLoaded.add(book);
            }
        }
        return booksLoaded;
    }

    public AudioBook audiobookFromCsv(String line) {
        String[] fields = line.split(delimiter, -1);
        return new AudioBook(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]));
    }
    public List<AudioBook> readAudiobook() throws IOException {
        List<AudioBook> audiobooksLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("audiobooks.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                AudioBook audioBook = audiobookFromCsv(line);
                audiobooksLoaded.add(audioBook);
            }
        }
        return audiobooksLoaded;
    }

    public Movie moviesFromCSV(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Movie(fields[0], fields[1], fields[3], fields[2], Integer.parseInt(fields[4]));
    }
    public List<Movie> readMovie() throws IOException {
        List<Movie> moviesLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("movies.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Movie movie = moviesFromCSV(line);
                moviesLoaded.add(movie);
            }
        }
        return moviesLoaded;
    }
    public VideoGame videoGameFromCSV(String line) {
        String[] fields = line.split(delimiter, -1);
        return new VideoGame(fields[0], fields[1], fields[2], fields[3]);
    }
    public List<VideoGame> readVideoGame() throws IOException {
        List<VideoGame> videoGamesLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path + "/videogames.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                VideoGame videoGame = videoGameFromCSV(line);
                videoGamesLoaded.add(videoGame);
            }
        }
        return videoGamesLoaded;
    }

    public VideoGame videogamesFromCSV(String line) {
        String[] fields = line.split(delimiter, -1);
        return new VideoGame(fields[0], fields[1], fields[2], fields[3]);
    }
    public List<VideoGame> readVideogame() throws IOException {
        List<VideoGame> videoGamesLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("videogames.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                VideoGame videogame = videogamesFromCSV(line);
                videoGamesLoaded.add(videogame);
            }
        }
        return videoGamesLoaded;
    }

    public Member memberFromCSV(String line) {
        String[] fields = line.split(delimiter, -1);
        return new Member(fields[0], Integer.parseInt(fields[1]));
    }
    public List<Member> readMember() throws IOException {
        List<Member> membersLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("members.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Member member = memberFromCSV(line);
                membersLoaded.add(member);
            }
        }
        return membersLoaded;
    }

    public Loan loansFromCSV(String line, Library library) {
        String[] fields = line.split(delimiter, -1);

        Resource resource = library.getResource(fields[0]);
        Member member = library.getMember(Integer.parseInt(fields[1]));

        if (resource == null || member == null){
            IO.println("Unkown member or resource in csv file.");
            return null;
        }
        LocalDate loanDate = LocalDate.parse(fields[2]);
        LocalDate dueDate = LocalDate.parse(fields[3]);

        //Member
        return new Loan(resource, member, loanDate, dueDate);
    }
    public List<Loan> readLoans(Library library) throws IOException {
        List<Loan> loansLoaded = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(path.resolve("loans.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Loan loan = loansFromCSV(line, library);
                loansLoaded.add(loan);
            }
        }
        return loansLoaded;
    }

}