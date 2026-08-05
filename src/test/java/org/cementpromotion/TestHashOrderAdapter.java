package org.cementpromotion;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHashOrderAdapter {

    @Test
    public void testRead() throws FileNotFoundException {
        OrderSource source = new HashOrderAdapter("src/test/resources/orders_hash");
        List<Order> orders = source.read();
        assertEquals(3, orders.size(),
                () -> "Ожидали 3 заказа, получили " + orders.size());
    }
}
