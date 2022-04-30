package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockDepthWSquareTest {
    private static final long depthWSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockDepthWSquareTestNotLessThan1() {
        new AGVDockDepthWSquare(-5);
    }

    @Test
    public void ensureAGVDockDepthWSquareTestHasRightValue() {
        final AGVDockDepthWSquare instance = new AGVDockDepthWSquare(depthWSquare);
        assertEquals(depthWSquare, instance.DepthWSquare());
    }
}