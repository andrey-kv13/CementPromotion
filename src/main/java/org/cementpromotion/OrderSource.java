package org.cementpromotion;
import java.util.List;
import java.io.FileNotFoundException;

public interface OrderSource {

        List<Order> read() throws FileNotFoundException;
    
}
