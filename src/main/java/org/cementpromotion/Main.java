package org.cementpromotion;

import org.cementpromotion.adapter.OrderFileAdapter;
import org.cementpromotion.adapter.PipeOrderAdapter;
import org.cementpromotion.service.FileOrderManager;
import org.cementpromotion.writer.OrderFileWriter;
import org.cementpromotion.service.CalculateDiscount;

public class Main {
    public static void main(String[] args) {

        OrderFileAdapter reader = new PipeOrderAdapter();

        CalculateDiscount calculator = new CalculateDiscount();

        OrderFileWriter writer = new OrderFileWriter();

        FileOrderManager manager = new FileOrderManager(reader, calculator, writer);
        manager.run("discount_day.txt",
                "totalPrice1.txt",
                156.0,
                0.5,
                0.05);

    }
}
