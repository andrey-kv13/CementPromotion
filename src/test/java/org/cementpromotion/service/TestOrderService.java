package org.cementpromotion.service;

import org.cementpromotion.TestData;
import org.cementpromotion.dto.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderService {

    @Test
    public void testOrderService() {
        List<Order> orders = TestData.sortedOrders();
        OrderService calculator = new OrderService();
        List<Order> result = calculator.calculate(orders, 156, 0.5, 0.05);

        assertEquals(2, result.size());
        assertEquals("Alpha", result.get(0).getCustomer());
        assertEquals("Beta", result.get(1).getCustomer());
        assertEquals(13650.0, result.get(0).getFinalPrice(), 0.01);

    }


}
