package org.cementpromotion.manager;

import org.cementpromotion.dto.Order;
import org.cementpromotion.service.FileOrderService;
import org.cementpromotion.service.OrderService;


import java.util.List;

public class FileOrderManager {
    private final FileOrderService fileOrderService;
    private final OrderService calculator;


    public FileOrderManager(FileOrderService fileOrderService, OrderService calculator) {
        this.calculator = calculator;
        this.fileOrderService = fileOrderService;
    }

    public void run(String inputPath,
                    String outputPath,
                    double pricePerKg,
                    double initialDiscount,
                    double discountStep) {

        List<Order> orders = fileOrderService.read(inputPath);
        List<Order> result = calculator.calculate(orders, pricePerKg, initialDiscount, discountStep);
        fileOrderService.write(result, outputPath);

    }

}
