package org.cementpromotion;
import java.util.ArrayList;
import java.util.List;

public class CalculateDiscount {
    private List<Object[]> sortedOrders;
    private int pricePerKg = 156;
    private double initialDiscount = 0.5;
    private double discountStep = 0.05;

    public CalculateDiscount(List<Object[]> sortedOrders, int pricePerKg,
                             double initialDiscount, double discountStep) {
        this.sortedOrders = sortedOrders;
        this.pricePerKg = pricePerKg;
        this.initialDiscount = initialDiscount;
        this.discountStep = discountStep;
    }

    public List<Object[]> calculate() {
        double currentDiscount = initialDiscount;
        List<Object[]> result = new ArrayList<>();

        for (Object[] order : sortedOrders) {
            Object orderDate = order[0];
            Object customerName = order[1];
            Double weightKg = (Double) order[2];

            Double finalPrice = weightKg * pricePerKg * (1 - currentDiscount);
            currentDiscount -= discountStep;

            if (currentDiscount < 0) {
                currentDiscount = 0;
            }

            result.add(new Object[]{orderDate, customerName, weightKg, finalPrice});
        }

        // Сортируем по имени клиента
        result.sort((a, b) -> ((String) a[1]).compareTo((String) b[1]));

        // Объединяем заказы одного клиента
        for (int i = 0; i < result.size() - 1; i++) {
            String currentCustomer = (String) result.get(i)[1];
            String nextCustomer = (String) result.get(i + 1)[1];

            if (currentCustomer.equals(nextCustomer)) {
                Double currentPrice = (Double) result.get(i)[3];
                Double nextPrice = (Double) result.get(i + 1)[3];
                Double totalPriceSum = currentPrice + nextPrice;

                Double currentWeight = (Double) result.get(i)[2];
                Double nextWeight = (Double) result.get(i + 1)[2];
                Double totalWeightSum = currentWeight + nextWeight;


                result.get(i)[2] = totalWeightSum;
                result.get(i)[3] = totalPriceSum;


                result.remove(i + 1);
                i--;
            }
        }

        return result;
    }
}