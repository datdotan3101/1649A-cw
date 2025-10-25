package algorithms;
import java.util.Queue;

import models.Order;

public class SearchAlgorithms {
    public static Order linearSearchByName(Queue<Order> orders, String name) {
        for (Order o : orders) {
            if (o.getCustomerName().equalsIgnoreCase(name)) {
                return o;
            }
        }
        return null;
    }
}
