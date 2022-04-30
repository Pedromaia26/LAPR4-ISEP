package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockBeginWSquareTest {
    private static final long beginWSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockBeginWSquareTestNotLessThan1() {
        new AGVDockBeginWSquare(-5);
    }

    @Test
    public void ensureAGVDockBeginWSquareTestHasRightValue() {
        final AGVDockBeginWSquare instance = new AGVDockBeginWSquare(beginWSquare);
        assertEquals(beginWSquare, instance.BeginWSquare());
    }
}