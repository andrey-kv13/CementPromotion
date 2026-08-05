package org.cementpromotion;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestSortedOrders {


    @Test
    public void testSortedOrders(){

        List<Object[]>sorted = new Orders(TestData.unsortedOrders()).sortByDate();
        assertEquals("Beta", sorted.get(0)[1],
                () -> "Первым по дате должен быть Beta, получили " + sorted.get(0)[1]);
        assertEquals("Alpha", sorted.get(1)[1],
                () -> "Вторым по дате должен быть Alpha, получили " + sorted.get(1)[1]);
        assertEquals("Alpha", sorted.get(2)[1],
                () -> "Третьим по дате должен быть Alpha, получили " + sorted.get(2)[1]);
    }
}

