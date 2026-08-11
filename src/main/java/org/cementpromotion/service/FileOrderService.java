package org.cementpromotion.service;

import org.cementpromotion.adapter.OrderFileAdapter;
import org.cementpromotion.dto.Order;
import org.cementpromotion.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileOrderService {
    private final OrderFileAdapter reader;

    public FileOrderService(OrderFileAdapter reader) {
        this.reader = reader;
    }

    public void write(List<Order> result, String filePath) {
        File file = new File(filePath);
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Order order : result) {
                String customer = order.getCustomer();
                Double totalPrice = order.getFinalPrice();
                pw.println(customer + " - " + (int) Math.round(totalPrice));
            }
        } catch (IOException e) {
            throw new FileException("Путь к файлу " + filePath + " указан неверно", e);
        }
    }

    public List<Order> read(String filePath) {
        return reader.read(filePath);
    }
}

