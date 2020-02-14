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
    @Test
    public void constructorTest() {
        int expectedId = 100;
        String expectedName = "Canon PIXMA TR4520 Color Ink-jet Multifunction printer";
        String expectedBrand = "Canon";
        String expectedInkType = "jet";
        boolean expectedWifiAbility = true;
        boolean expectedColorAbility = true;
        boolean expectedBusinessAbility = true;

        Printer p = new Printer(expectedId, expectedName, expectedBrand,
                expectedInkType, expectedWifiAbility,
                expectedColorAbility, expectedBusinessAbility);

        Assertions.assertEquals(expectedId, p.getId());
        Assertions.assertEquals(expectedName, p.getName());
        Assertions.assertEquals(expectedBrand, p.getBrand());
        Assertions.assertEquals(expectedInkType, p.getInkType());
        Assertions.assertEquals(expectedWifiAbility, p.CanWorkWithWifi());
        Assertions.assertEquals(expectedColorAbility, p.canPrintDifferentColor());
        Assertions.assertEquals(expectedBusinessAbility, p.canUseForBusiness());
    }
}
