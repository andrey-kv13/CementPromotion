package org.cementpromotion;
import java.time.LocalDateTime;

public class Order {
    private String customer;
    private double kg;
    private LocalDateTime date;

    public Order(String customer, double kg, LocalDateTime date) {
        this.customer = customer;
        this.kg = kg;
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public double getKg() {
        return kg;
    }

    public LocalDateTime getDate() {
        return date;
    }
}