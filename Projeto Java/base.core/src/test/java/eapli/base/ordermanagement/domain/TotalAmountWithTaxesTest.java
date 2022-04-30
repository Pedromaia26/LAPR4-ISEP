package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TotalAmountWithTaxesTest {
    private static final Double TOTAL_AMOUNT_WITH_TAXES = 20d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureTotalAmountWithTaxesMustBeGreater0() {
        new TotalAmountWithTaxes(-1d);
    }

    @Test
    public void ensureTotalAmountWithTaxesHasRightValue() {
        final TotalAmountWithTaxes instance = new TotalAmountWithTaxes(TOTAL_AMOUNT_WITH_TAXES);
        assertEquals(TOTAL_AMOUNT_WITH_TAXES, instance.totalAmountWithTaxes());
    }
}