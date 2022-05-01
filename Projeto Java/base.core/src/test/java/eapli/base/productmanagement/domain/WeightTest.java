package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeightTest {
    private static final double WEIGHT = 10;

    @Test(expected = IllegalArgumentException.class)
    public void ensureWeightMustBePositive() {
        new Weight(-1);
    }

    @Test
    public void ensureWeightHasRightValue() {
        final Weight instance = new Weight(WEIGHT);
        assertEquals(String.valueOf(WEIGHT), String.valueOf(instance.weight()));
    }
}