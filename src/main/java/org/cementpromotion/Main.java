package org.cementpromotion;

import org.cementpromotion.adapter.PipeOrderAdapter;
import org.cementpromotion.adapter.WriteToFile;
import org.cementpromotion.dto.Order;
import org.cementpromotion.service.CalculateDiscount;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PipeOrderAdapter source = new PipeOrderAdapter("discount_day.txt");
        List<Order> orders = source.read();

        CalculateDiscount calculator = new CalculateDiscount(orders, 156, 0.5, 0.05);
        List<Order> result = calculator.calculate();

        WriteToFile writer = new WriteToFile();
        writer.write(result);
    }
}
