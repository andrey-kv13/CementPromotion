package org.cementpromotion;

import org.cementpromotion.dto.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class TestData {

    private TestData() {
    }

    public static List<Order> unsortedOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Alpha", 100.0, LocalDateTime.parse("2021-02-09T10:00:00"), 0));
        orders.add(new Order("Beta", 200.0, LocalDateTime.parse("2021-02-09T08:00:00"), 0));
        orders.add(new Order("Alpha", 50.0, LocalDateTime.parse("2021-02-09T09:00:00"), 0));
        return orders;
    }

    public static List<Order> sortedOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Beta", 200.0, LocalDateTime.parse("2021-02-09T08:00:00"), 0));
        orders.add(new Order("Alpha", 50.0, LocalDateTime.parse("2021-02-09T09:00:00"), 0));
        orders.add(new Order("Alpha", 100.0, LocalDateTime.parse("2021-02-09T10:00:00"), 0));
        return orders;
    }


    public static List<Order> sortedListTotalPrice() {
        List<Order> totals = new ArrayList<>();
        totals.add(new Order("Alpha", 0, LocalDateTime.parse("2021-02-09T09:00:00"), 13650.0));
        totals.add(new Order("Beta", 0, LocalDateTime.parse("2021-02-09T08:00:00"), 15600.0));
        return totals;
    }
}
