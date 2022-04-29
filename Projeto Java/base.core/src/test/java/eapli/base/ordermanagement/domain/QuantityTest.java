package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {
    private static final int QUANTITY = 2;

    @Test(expected = IllegalArgumentException.class)
    public void ensureQuantityMustBeGreater0() {
        new Quantity(-1);
    }

    @Test
    public void ensureQuantityHasRightValue() {
        final Quantity instance = new Quantity(QUANTITY);
        assertEquals(QUANTITY, instance.quantity());
    }
}