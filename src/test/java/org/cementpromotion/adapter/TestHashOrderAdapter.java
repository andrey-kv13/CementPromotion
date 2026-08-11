package org.cementpromotion.adapter;

import org.cementpromotion.dto.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashOrderAdapter {

    @Test
    public void testRead() {
        HashOrderAdapter source = new HashOrderAdapter();

        List<Order> orders = source.read("src/test/resources/orders_hash");
        assertEquals(3, orders.size(),
                () -> "Ожидали 3 заказа, получили " + orders.size());
    }
}
