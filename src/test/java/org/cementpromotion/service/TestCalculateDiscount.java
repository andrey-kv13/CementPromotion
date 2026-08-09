package org.cementpromotion.service;

import org.cementpromotion.TestData;
import org.cementpromotion.dto.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculateDiscount {

    @Test
    public void testCalculateDiscount() {
        List<Order> sorted = TestData.sortedOrders();
        CalculateDiscount calculator = new CalculateDiscount(sorted, 156, 0.5, 0.05);
        List<Order> result = calculator.calculate();

        assertEquals(2, result.size());
        assertEquals("Alpha", result.get(0).getCustomer());
        assertEquals("Beta", result.get(1).getCustomer());
        assertEquals(13650.0, result.get(0).getFinalPrice(), 0.01);

    }


}
