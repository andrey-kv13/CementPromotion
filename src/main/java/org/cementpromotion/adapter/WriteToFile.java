package org.cementpromotion.adapter;

import org.cementpromotion.dto.Order;
import org.cementpromotion.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriteToFile {
    private File file = new File("totalPrice.txt");

    public void write(List<Order> result) {

        try (PrintWriter pw = new PrintWriter(file)) {
            for (Order order : result) {
                String customer = order.getCustomer();
                Double totalPrice = order.getFinalPrice();
                pw.println(customer + " - " + (int) Math.round(totalPrice));

            }
        } catch (IOException e) {
            throw new FileException("Путь к файлу " + file + " указан неверно", e);
        }
    }
}
