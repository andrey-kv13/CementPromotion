package org.cementpromotion;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class HashOrderAdapter implements OrderSource {

    private final String filePath;

    public HashOrderAdapter(String filePath) {
        this.filePath = filePath;
    }

    public List<Order> read() throws FileNotFoundException {
        List<Order> orders = new ArrayList<>();
        File file =new File(filePath);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\#");
            String dateStr = parts[0].trim();
            String customer = parts[1].trim();
            Double kg = Double.valueOf(parts[2].trim());

            LocalDateTime date = LocalDateTime.parse(dateStr);
            orders.add(new Order(customer, kg, date));

        }
        scanner.close();
        return orders;
    }

}
