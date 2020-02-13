package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrinterTest {

    @Test
    public void setNameTest() {
        String expected = "OZWEEGO";

        Printer p = new Printer();
        p.setName(expected);

        Assertions.assertEquals(expected, p.getName());
    }

}
