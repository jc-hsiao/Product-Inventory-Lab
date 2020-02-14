package services;

import models.Printer;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class PrinterServiceTest {
    PrinterService ps1;
    Printer printer1, printer2, printer3, printer4;

    @Before
    public void setUp(){
        ps1 = new PrinterService();

        printer1 = ps1.create(
                "Canon PIXMA TR4520 Color Ink-jet Multifunction printer",
                "Canon",
                "Inkjet",
                true,
                true,
                true);

        printer2 = ps1.create(
                "HP OfficeJet Pro 6978 InkJet All-In-One Printer",
                "HP",
                "Inkjet",
                false,
                true,
                false);

        printer3 = ps1.create(
                "HP LaserJet Pro MFP M281fdw Color Laser",
                "HP",
                "Laser",
                false,
                true,
                false);

        printer4 = ps1.create(
                "Brother - MFC-L2710DW Wireless Black-and-White All-in-One Laser Printer - Black",
                "Brother",
                "Laser",
                true,
                false,
                true);
    }
    @Test
    public void createTest() {
        String expectedName = "Canon PIXMA TR4520 Color Ink-jet Multifunction printer";
        String expectedBrand = "Canon";
        String expectedInkType = "jet";
        boolean expectedWifiAbility = true;
        boolean expectedColorAbility = true;
        boolean expectedBusinessAbility = true;

        PrinterService ps = new PrinterService();
        Printer p = ps.create(expectedName, expectedBrand,
                expectedInkType, expectedWifiAbility,
                expectedColorAbility, expectedBusinessAbility);

        int actualId = p.getId();
        String actualName = p.getName();
        String actualBrand = p.getBrand();
        String actualInkType = p.getInkType();
        boolean actualWifiAbility = p.CanWorkWithWifi();
        boolean actualColorAbility = p.canPrintDifferentColor();
        boolean actualBusinessAbility = p.canUseForBusiness();

        Assertions.assertEquals(Integer.class.getName(), new Integer(actualId).getClass().getName());
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedBrand, actualBrand);
        Assertions.assertEquals(expectedInkType, actualInkType);
        Assertions.assertEquals(expectedWifiAbility, actualWifiAbility);
        Assertions.assertEquals(expectedColorAbility, actualColorAbility);
        Assertions.assertEquals(expectedBusinessAbility, actualBusinessAbility);
    }

    @Test
    public void findTest(){
        Printer expectedPrinter = printer2;
        Assertions.assertEquals(expectedPrinter, ps1.findPrinter(2));
    }

    @Test
    public void findAllTest(){
        Printer[] expectedPrinters = {printer1,printer2,printer3,printer4};
        Printer[] actualPrinters = ps1.findAll();
        for(int i=0; i<expectedPrinters.length; i++ ){
            Assertions.assertEquals(expectedPrinters[i],actualPrinters[i]);

        }
        Assertions.assertArrayEquals(expectedPrinters, actualPrinters);
    }

    @Test
    public void findAllTest2(){
        Printer[] expectedPrinters = {printer1,printer2,printer3,printer4};
        Printer[] actualPrinters = ps1.findAll();
        Assertions.assertArrayEquals(expectedPrinters, actualPrinters);
    }

    @Test
    public void removeTest(){
        int id = ps1.findAll()[0].getId();
        Assertions.assertTrue(ps1.delete(id));
        Assertions.assertNull(ps1.findPrinter(id));
    }

    @Test
    public void removeTest2(){
        Assertions.assertFalse(ps1.delete(9));
    }


}
