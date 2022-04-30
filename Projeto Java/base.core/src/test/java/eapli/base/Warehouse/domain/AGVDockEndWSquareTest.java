package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockEndWSquareTest {
    private static final long endWSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockEndWSquareTestNotLessThan1() {
        new AGVDockEndLSquare(-5);
    }

    @Test
    public void ensureAGVDockEndWSquareTestHasRightValue() {
        final AGVDockEndWSquare instance = new AGVDockEndWSquare(endWSquare);
        assertEquals(endWSquare, instance.EndWSquare());
    }
}