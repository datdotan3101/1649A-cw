package models;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String customerName;
    private String address;
    private String status;
    private Map<Book, Integer> items = new HashMap<>();

    public Order(String customerName, String address) {
        this.customerName = customerName;
        this.address = address;
        this.status = "Pending";
    }

    public void addBook(Book book, int quantity) {
        items.put(book, quantity);
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public Map<Book, Integer> getItems() {
        return items;
    }

    public Map<Book, Integer> getBooks() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nCustomer: ").append(customerName)
                .append("\nAddress: ").append(address)
                .append("\nBooks Ordered:\n");

        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            sb.append(" - ").append(entry.getKey().getTitle())
                    .append(" (x").append(entry.getValue()).append(")\n");
        }

        return sb.toString();
    }
}
