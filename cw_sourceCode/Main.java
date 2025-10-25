import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorithms.SearchAlgorithms;
import algorithms.SortAlgorithms;
import models.Book;
import models.Order;
import structures.OrderQueue;
import ui.DisplayBooks;
import structures.OrderHistoryStack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = DisplayBooks.readBooksFromCSV();
        books.sort((a, b) -> Integer.compare(a.getId(), b.getId()));
        OrderHistoryStack orderHistory = new OrderHistoryStack();

        OrderQueue orderQueue = new OrderQueue();

        // SortAlgorithms.insertionSortByTitle(books);

        int choice;
        do {
            System.out.println("\n===== LIBRARY SYSTEM =====");
            System.out.println("1. Show all books");
            System.out.println("2. Create new order");
            System.out.println("3. Show orders queue");
            System.out.println("4. Search order by customer name");
            System.out.println("5. Process next order");
            System.out.println("6. Show processed orders (stack)");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input, enter number: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    DisplayBooks.showAllBooks(books);
                    break;
                case 2:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter address: ");
                    String address = scanner.nextLine();

                    Order order = new Order(name, address);
                    String addMore = "y";
                    do {
                        DisplayBooks.showAllBooks(books);
                        System.out.print("Enter Book ID to order: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        Book selectedBook = books.stream()
                                .filter(b -> b.getId() == id)
                                .findFirst()
                                .orElse(null);

                        if (selectedBook == null) {
                            System.out.println("Invalid Book ID!");
                            continue;
                        }

                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        scanner.nextLine();

                        order.addBook(selectedBook, qty);
                        System.out.print("Add another book? (y/n): ");
                        addMore = scanner.nextLine();

                    } while (addMore.equalsIgnoreCase("y"));

                    orderQueue.addOrder(order);
                    System.out.println("Order added successfully! Current status: " + order.getStatus());
                    break;

                case 3:
                    orderQueue.showAllOrders();
                    break;
                case 4:
                    System.out.print("Enter customer name to search: ");
                    String searchName = scanner.nextLine();
                    Order found = SearchAlgorithms.linearSearchByName(orderQueue.getQueue(), searchName);
                    if (found != null)
                        System.out.println(found);
                    else
                        System.out.println("No order found for " + searchName);
                    break;
                case 5:
                    Order processed = orderQueue.processOrder();
                    if (processed != null) {
                        processed.setStatus("Processing");
                        System.out.println("Order status updated to: " + processed.getStatus());

                        System.out.println("\nSorting books in this order by title...");
                        List<Book> orderBooks = new ArrayList<>(processed.getBooks().keySet());
                        SortAlgorithms.insertionSortByTitle(orderBooks);

                        for (Book b : orderBooks) {
                            System.out.println(" - " + b.getTitle());
                        }

                        processed.setStatus("Completed");
                        System.out.println("Order status updated to: " + processed.getStatus());

                        orderHistory.push(processed);
                        System.out.println("Order processed and moved to history stack.");
                    }
                    break;
                case 6:
                    // Show processed orders stack
                    orderHistory.showAllProcessedOrders();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
