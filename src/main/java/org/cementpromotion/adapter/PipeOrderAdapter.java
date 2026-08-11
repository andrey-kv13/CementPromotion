package org.cementpromotion.adapter;

import org.cementpromotion.dto.Order;
import org.cementpromotion.exceptions.FileException;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PipeOrderAdapter implements OrderFileAdapter {

    public List<Order> read(String filePath) {
        List<Order> orders = new ArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String dateStr = parts[0].trim();
                String customer = parts[1].trim();
                double kg = Double.valueOf(parts[2].trim());


                LocalDateTime date = LocalDateTime.parse(dateStr);
                orders.add(new Order(customer, kg, date, 0));
            }
        } catch (IOException e) {
            throw new FileException("Путь к файлу " + filePath + " указан неверно", e);
        }

        return orders;
    }
}
