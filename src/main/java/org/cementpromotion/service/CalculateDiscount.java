package org.cementpromotion.service;

import org.cementpromotion.dto.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CalculateDiscount {
    private List<Order> orders;
    private int pricePerKg;
    private double initialDiscount;
    private double discountStep;


    public CalculateDiscount(List<Order> orders, int pricePerKg,
                             double initialDiscount, double discountStep) {
        this.orders = orders;
        this.pricePerKg = pricePerKg;
        this.initialDiscount = initialDiscount;
        this.discountStep = discountStep;
    }


    public List<Order> calculate() {

        orders.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));
        double currentDiscount = initialDiscount;
        List<Order> result = new ArrayList<>();

        for (Order order : orders) {
            LocalDateTime orderDate = order.getDate();
            String customerName = order.getCustomer();
            Double weightKg = order.getKg();

            Double finalPrice = weightKg * pricePerKg * (1 - currentDiscount);
            currentDiscount -= discountStep;

            if (currentDiscount < 0) {
                currentDiscount = 0;
            }

            result.add(new Order(customerName, weightKg, orderDate, finalPrice));

        }

        // Сортируем по имени клиента
        result.sort((a, b) -> a.getCustomer().compareTo(b.getCustomer()));

        // Объединяем заказы одного клиента
        for (int i = 0; i < result.size() - 1; i++) {
            String currentCustomer = result.get(i).getCustomer();
            String nextCustomer = result.get(i + 1).getCustomer();

            if (currentCustomer.equals(nextCustomer)) {
                double currentPrice = result.get(i).getFinalPrice();
                double nextPrice = result.get(i + 1).getFinalPrice();
                double totalPriceSum = currentPrice + nextPrice;

                double currentWeight = result.get(i).getKg();
                double nextWeight = result.get(i + 1).getKg();
                double totalWeightSum = currentWeight + nextWeight;

                result.set(i, new Order(
                        result.get(i).getCustomer(),
                        totalWeightSum, result.get(i).getDate(),
                        totalPriceSum));


                result.remove(i + 1);
                i--;
            }
        }

        return result;
    }
}
