package org.cementpromotion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.lang.Math;

public class WriteToFile {
    private File file = new File("totalPrice.txt");

    public void write(List<Object[]> result) throws FileNotFoundException {
    
        PrintWriter pw = new PrintWriter(file);
        for (Object[] row : result) {
            String customer = (String) row[1];
            Double totalPrice = (Double) row[3];
            pw.println(customer + " - " + (int) Math.round(totalPrice));

        }
        pw.close();
    }
}
