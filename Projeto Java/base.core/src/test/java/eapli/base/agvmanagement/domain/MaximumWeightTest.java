package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class MaximumWeightTest {
    private static final double MAXIMUM_WEIGHT = 100d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureMaximumWeightMustBeGreater0() {
        new MaximumWeight(-1);
    }

    @Test
    public void ensureMaximumWeightHasRightValue() {
        final MaximumWeight instance = new MaximumWeight(MAXIMUM_WEIGHT);
        assertEquals(String.valueOf(MAXIMUM_WEIGHT), String.valueOf(instance.maximumWeight()));
    }
}