package org.cementpromotion;
import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        OrderSource source = new PipeOrderAdapter("discount_day.txt");
        List<Order> orders = source.read();

        Orders ordersList = new Orders(orders);

        CalculateDiscount calculator = new CalculateDiscount(ordersList.sortByDate(), 156, 0.5, 0.05);
        List<Object[]> result = calculator.calculate();

        WriteToFile writer = new WriteToFile();
        writer.write(result);
    }
}
