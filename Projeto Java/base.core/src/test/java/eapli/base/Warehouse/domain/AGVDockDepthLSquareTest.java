package eapli.base.Warehouse.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockDepthLSquareTest {
    private static final long depthLSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockDepthLSquareTestNotLessThan1() {
        new AGVDockDepthWSquare(-5);
    }

    @Test
    public void ensureAGVDockDepthLSquareTestHasRightValue() {
        final AGVDockDepthLSquare instance = new AGVDockDepthLSquare(depthLSquare);
        assertEquals(depthLSquare, instance.DepthLSquare());
    }
}