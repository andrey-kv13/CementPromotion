package org.cementpromotion;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Object[]> orders;

    public Orders(List<Order> orders){
        this.orders = new ArrayList<>();
        for(Order order : orders){
            this.orders.add(new Object[]{order.getDate(), order.getCustomer(), order.getKg()});

        }
    }

    public List<Object[]> sortByDate(){
        List<Object[]> sortedOrder = new ArrayList<>(orders);
        sortedOrder.sort((o1, o2) -> ((LocalDateTime) o1[0]).compareTo((LocalDateTime) o2[0]));
        

        return sortedOrder;
    }

}
