package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Book;

public class DisplayBooks {
    private static final String FILE_PATH = "./data/books.csv";

    public static List<Book> readBooksFromCSV() {
        List<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] v = line.split(",");
                books.add(new Book(
                        Integer.parseInt(v[0].trim()),
                        v[1].trim(),
                        v[2].trim(),
                        Integer.parseInt(v[3].trim()),
                        Double.parseDouble(v[4].trim())));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV: " + e.getMessage());
        }
        return books;
    }

    public static void showAllBooks(List<Book> books) {
        System.out.println("\n===== BOOK LIST =====");
        System.out.printf("%-3s | %-25s | %-20s | %-4s | %-6s%n",
                "ID", "Title", "Author", "Published", "Price");
        System.out.println("---------------------------------------------------------------");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}
