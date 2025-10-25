package structures;
import java.util.LinkedList;
import java.util.Queue;

import models.Order;

public class OrderQueue {
    private Queue<Order> orderQueue = new LinkedList<>();

    public void addOrder(Order order) {
        orderQueue.add(order);
        System.out.println("Order added to the queue successfully!");
    }

    public Order processOrder() {
        if (!orderQueue.isEmpty()) {
            return orderQueue.poll();
        } else {
            System.out.println("No orders to process.");
            return null;
        }
    }

    public Queue<Order> getQueue() {
        return orderQueue;
    }

    public void showAllOrders() {
        if (orderQueue.isEmpty()) {
            System.out.println("No orders in queue.");
            return;
        }

        System.out.println("\n===== ALL ORDERS IN QUEUE =====");
        for (Order o : orderQueue) {
            System.out.println(o);
            System.out.println("----------------------------");
        }
    }
}
