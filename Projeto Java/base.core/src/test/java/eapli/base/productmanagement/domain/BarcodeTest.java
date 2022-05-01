package eapli.base.productmanagement.domain;

import eapli.base.agvmanagement.domain.Autonomy;
import org.junit.Test;

import static org.junit.Assert.*;

public class BarcodeTest {
    private static final String BARCODE = "1234567890987";

    @Test(expected = IllegalArgumentException.class)
    public void ensureBarcodeMustBe13() {
        new Barcode("1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBarcodeMustBeNotEmpty() {
        new Barcode("");
    }

    @Test
    public void ensureBarcodeHasRightValue() {
        final Barcode instance = new Barcode(BARCODE);
        assertEquals(BARCODE, instance.toString());
    }
}