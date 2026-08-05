package org.cementpromotion;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculateDiscount {

    @Test
    public void testCalculateDiscount(){
        List<Object[]> sorted = new Orders(TestData.sortedOrders()).sortByDate();
        CalculateDiscount calculator = new CalculateDiscount(sorted, 156, 0.5, 0.05);
        List<Object[]> result = calculator.calculate();
        assertEquals(2, result.size(),
                () -> "Ожидали 2 компании, получили " + result.size());
        assertEquals("Alpha", result.get(0)[1],
                () -> "Первой компанией должна быть Alpha, получили " + result.get(0)[1]);
        assertEquals("Beta", result.get(1)[1],
                () -> "Второй компанией должна быть Beta, получили " + result.get(1)[1]);
        assertEquals(13650.0, (Double) result.get(0)[3], 0.01,
                () -> "Ожидали стоимость Alpha 13650.0, получили " + result.get(0)[3]);
    }
}
