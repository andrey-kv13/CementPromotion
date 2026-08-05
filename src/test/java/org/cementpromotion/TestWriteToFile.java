package org.cementpromotion;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWriteToFile {
    @Test
    public void testWrite() throws IOException {
        List<Object[]> result = TestData.sortedListTotalPrice();
        WriteToFile writer = new WriteToFile();
        writer.write(result);

        List<String> lines = Files.readAllLines(Path.of("totalPrice.txt"));
        assertEquals("Alpha - 13650", lines.get(0),
                () -> "Ожидали строку 'Alpha - 13650', получили '" + lines.get(0) + "'");
        assertEquals("Beta - 15600", lines.get(1),
                () -> "Ожидали строку 'Beta - 15600', получили '" + lines.get(1) + "'");

    }
}
