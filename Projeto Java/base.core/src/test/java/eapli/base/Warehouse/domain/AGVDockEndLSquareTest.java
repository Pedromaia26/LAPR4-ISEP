package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockEndLSquareTest {
    private static final long endLSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockEndLSquareTestNotLessThan1() {
        new AGVDockEndLSquare(-5);
    }

    @Test
    public void ensureAGVDockEndLSquareTestHasRightValue() {
        final AGVDockEndLSquare instance = new AGVDockEndLSquare(endLSquare);
        assertEquals(endLSquare, instance.EndLSquare());
    }
}