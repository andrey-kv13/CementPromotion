package org.cementpromotion;

import org.cementpromotion.adapter.PipeOrderAdapter;
import org.cementpromotion.manager.FileOrderManager;
import org.cementpromotion.service.FileOrderService;
import org.cementpromotion.service.OrderService;

public class Main {
    public static void main(String[] args) {
        FileOrderService fileOrderService = new FileOrderService(new PipeOrderAdapter());
        OrderService calculator = new OrderService();
        FileOrderManager manager = new FileOrderManager(fileOrderService, calculator);
        manager.run("discount_day.txt",
                "totalPrice1.txt",
                156.0,
                0.5,
                0.05);
    }
}