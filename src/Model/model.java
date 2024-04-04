package Model;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class model {
    private List<String> lines;

    public model() {
        lines = new ArrayList<>();
    }

    public Stream<String> getLinesStream() {
        return lines.stream();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void loadFromFile(File file) throws IOException {
        lines.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
    }
}
