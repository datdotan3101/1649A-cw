package structures;
import java.util.Stack;

import models.Order;

public class OrderHistoryStack {
    private Stack<Order> history = new Stack<>();

    // Add order proccessed
    public void push(Order order) {
        history.push(order);
        System.out.println("Order processed and added to history stack.");
    }

    // Get current order
    public Order peekRecent() {
        if (history.isEmpty()) {
            System.out.println("⚠️ No processed orders yet.");
            return null;
        }
        return history.peek();
    }

    // Display all order
    public void showAllProcessedOrders() {
        if (history.isEmpty()) {
            System.out.println("⚠️ No processed orders in history.");
            return;
        }

        System.out.println("\n===== PROCESSED ORDERS STACK =====");
        for (Order o : history) {
            System.out.println(o);
            System.out.println("----------------------------");
        }
    }

    // Delete all stacks
    public void clearHistory() {
        history.clear();
        System.out.println("🧹 History stack cleared.");
    }
}
