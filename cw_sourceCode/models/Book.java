package models;

public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(int id, String title, String author, int year, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%-3d | %-25s | %-20s | %-4d | $%.2f",
                id, title, author, year, price);
    }
}
