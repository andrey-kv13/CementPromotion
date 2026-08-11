package org.cementpromotion.service;

import org.cementpromotion.dto.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class CalculateDiscount {


    public List<Order> calculate(List<Order> orders, double pricePerKg, double initialDiscount, double discountStep) {
        orders.sort((o1, o2) -> o1.getDate().compareTo(o2.getDate()));

        double currentDiscount = initialDiscount;
        TreeMap<String, Order> map = new TreeMap<>();

        for (Order order : orders) {

            String customer = order.getCustomer();
            double totalPrice = order.getKg() * pricePerKg * (1 - currentDiscount);


            currentDiscount -= discountStep;

            if (currentDiscount < 0) {
                currentDiscount = 0;
            }

            if (map.containsKey(customer)) {
                Order old = map.get(customer);
                map.put(customer, new Order(customer,
                        old.getKg() + order.getKg(),
                        old.getDate(),
                        old.getFinalPrice() + totalPrice));
            } else {

                map.put(customer, new Order(customer, order.getKg(), order.getDate(), totalPrice));
            }
        }

        return new ArrayList<>(map.values());
    }
}
