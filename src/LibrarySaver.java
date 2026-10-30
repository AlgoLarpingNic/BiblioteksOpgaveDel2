import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LibrarySaver {
    private Path path;
    private final String delimiter = ",";

    public LibrarySaver(Path path, String delimiter){
        this.path = path;
    }

    public void saveMember(List<Member> members, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(member.getMemberId() + delimiter + member.getName());
                writer.newLine();
            }
        }
    }
    public void saveLoan(List<Loan> loans, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(loan.getMember().getMemberId() + delimiter + loan.getResource().getIdentifier() + delimiter + loan.getLoanDate() + delimiter + loan.getDueDate());
                writer.newLine();
            }
        }
    }
    public void saveResource(List<Resource> resources, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                writer.write((resource).getCreator() + delimiter + resource.getTitle() + delimiter + resource.getIdentifier());
                writer.newLine();
            }
        }
    }
    public void saveBook(List<Resource> resources, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof Book book) {
                    writer.write(book.getCreator() + delimiter + book.getTitle() + delimiter + book.getIdentifier() + delimiter + book.getPages());
                    writer.newLine();
                }
            }
        }
    }
    public void saveAudiobook(List<Resource> resources, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof AudioBook audioBook) {
                    writer.write(audioBook.getCreator() + delimiter + audioBook.getTitle() + delimiter + audioBook.getIdentifier() + delimiter + audioBook.getLengthMinutes());
                    writer.newLine();

                }
            }
        }
    }
    public void saveMovie(List<Resource> resources, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof Movie movie) {
                    writer.write(movie.getStudio() + delimiter + movie.getCreator() + delimiter + movie.getTitle() + delimiter + movie.getIdentifier() + delimiter + movie.getLengthMinutes());
                    writer.newLine();
                }
            }
        }
    }
    public void saveVideogame(List<Resource> resources, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (resource instanceof VideoGame videoGame) {
                    writer.write(videoGame.getCreator() + delimiter + videoGame.getTitle() + delimiter + videoGame.getIdentifier() + delimiter + videoGame.getPlatform());
                    writer.newLine();
                }

            }
        }
    }
    /*

    return switch'en ian ikke ville have vi skulle bruge :c
    public void saveResourcesOfType(List<Resource> resources, Class<?> type, String fileName) throws Exception {
        Path path = Path.of(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Resource resource : resources) {
                if (type.isInstance(resource)) {
                    String line = switch (resource) {
                        case Book book -> book.getIdentifier() + delimiter + book.getTitle() + delimiter
                                + book.getCreator() + delimiter + book.getPages();
                        case AudioBook audio -> audio.getIdentifier() + delimiter + audio.getTitle() + delimiter
                                + audio.getCreator() + delimiter + audio.getLengthMinutes();
                        case Movie movie -> movie.getIdentifier() + delimiter + movie.getTitle() + delimiter
                                + movie.getCreator() + delimiter + movie.getStudio() + delimiter
                                + movie.getLengthMinutes();
                        case VideoGame game -> game.getIdentifier() + delimiter + game.getTitle() + delimiter
                                + game.getCreator() + delimiter + game.getPlatform();
                        default -> "";
                    };
                    if (!line.isEmpty()) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        }
    }
     */
}
