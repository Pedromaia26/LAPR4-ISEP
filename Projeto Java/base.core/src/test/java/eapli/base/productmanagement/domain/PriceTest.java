package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {
    private static final double PRICE = 15;

    @Test(expected = IllegalArgumentException.class)
    public void ensurePriceMustBePositive() {
        new Price(-1);
    }

    @Test
    public void ensurePriceHasRightValue() {
        final Price instance = new Price(PRICE);
        assertEquals(String.valueOf(PRICE), String.valueOf(instance.getPrice()));
    }
}