package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TotalAmountWithoutTaxesTest {
    private static final Double TOTAL_AMOUNT_WITHOUT_TAXES = 20d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureTotalAmountWithoutTaxesMustBeGreater0() {
        new TotalAmountWithoutTaxes(-1d);
    }

    @Test
    public void ensureTotalAmountWithoutTaxesHasRightValue() {
        final TotalAmountWithoutTaxes instance = new TotalAmountWithoutTaxes(TOTAL_AMOUNT_WITHOUT_TAXES);
        assertEquals(TOTAL_AMOUNT_WITHOUT_TAXES, instance.totalAmountWithoutTaxes());
    }
}