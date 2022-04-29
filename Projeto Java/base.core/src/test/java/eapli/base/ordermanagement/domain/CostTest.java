package eapli.base.ordermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CostTest {
    private static final double COST = 25d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureCostMustBeGreater0() {
        new Cost(-1);
    }

    @Test
    public void ensureCostHasRightValue() {
        final Cost instance = new Cost(COST);
        assertEquals(COST, instance.cost(), 0);
    }
}