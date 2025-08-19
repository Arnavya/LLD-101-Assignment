import java.io.*;
import java.util.*;

public class DatasetReader {

    public List<Book> loadBooks(String filename) throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] fields = splitCSVLine(line);
                if (fields.length < 7) continue;

                String title = fields[0];
                String author = fields[1];
                double rating = Double.parseDouble(fields[2]);
                int reviews = Integer.parseInt(fields[3]);
                int price = Integer.parseInt(fields[4]);
                int year = Integer.parseInt(fields[5]);
                String genre = fields[6];

                Book book = new Book(title, author, rating, reviews, price, year, genre);
                books.add(book);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Handles quoted CSV fields
    private static String[] splitCSVLine(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '\"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                tokens.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        tokens.add(sb.toString().trim());
        return tokens.toArray(new String[0]);
    }
}
