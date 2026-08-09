package org.cementpromotion.adapter;

import org.cementpromotion.dto.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPipeOrderAdapter {

    @ParameterizedTest
    @CsvSource({
            "src/test/resources/orders_discount_zero.txt, 12",
            "src/test/resources/orders_pipe.txt, 3",
            "src/test/resources/orders_single.txt, 1"
    })
    public void testRead(String input, int expectedValue) {
        OrderFileReader source = new PipeOrderAdapter(input);
        List<Order> orders = source.read();
        assertEquals(expectedValue, orders.size(),
                () -> "Ожидали " + expectedValue + " заказов, получили " + orders.size());
    }
}
