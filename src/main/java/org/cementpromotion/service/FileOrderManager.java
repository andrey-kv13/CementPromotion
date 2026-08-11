package org.cementpromotion.service;

import org.cementpromotion.adapter.OrderFileAdapter;
import org.cementpromotion.dto.Order;
import org.cementpromotion.writer.OrderFileWriter;

import java.util.List;

public class FileOrderManager {
    private final OrderFileAdapter reader;
    private final CalculateDiscount calculator;
    private final OrderFileWriter writer;

    public FileOrderManager(OrderFileAdapter reader, CalculateDiscount calculator, OrderFileWriter writer) {
        this.reader = reader;
        this.calculator = calculator;
        this.writer = writer;
    }

    public void run(String inputPath,
                    String outputPath,
                    double pricePerKg,
                    double initialDiscount,
                    double discountStep) {

        List<Order> orders = reader.read(inputPath);
        List<Order> result = calculator.calculate(orders, pricePerKg, initialDiscount, discountStep);
        writer.write(result, outputPath);

    }

}
