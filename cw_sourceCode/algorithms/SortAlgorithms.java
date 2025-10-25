package algorithms;
import java.util.List;

import models.Book;

public class SortAlgorithms {
    // Insertion Sort by book title
    public static void insertionSortByTitle(List<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;
            while (j >= 0 && books.get(j).getTitle().compareToIgnoreCase(key.getTitle()) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    public static void insertionSortByAuthor(List<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;

            while (j >= 0 && books.get(j).getAuthor().compareToIgnoreCase(key.getAuthor()) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }

    public static void insertionSortById(List<Book> books) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;

            while (j >= 0 && books.get(j).getId() > key.getId()) {
                books.set(j + 1, books.get(j));
                j--;
            }
            books.set(j + 1, key);
        }
    }
    
    
}
