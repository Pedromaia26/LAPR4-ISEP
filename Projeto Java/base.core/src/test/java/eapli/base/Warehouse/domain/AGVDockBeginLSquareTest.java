package eapli.base.Warehouse.domain;

import eapli.base.agvmanagement.domain.AGVIdentifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockBeginLSquareTest {

    private static final long beginLSquare = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockBeginLSquareTestNotLessThan1() {
        new AGVDockBeginLSquare(-5);
    }

    @Test
    public void ensureAGVDockBeginLSquareTestHasRightValue() {

        final AGVDockBeginLSquare instance = new AGVDockBeginLSquare(beginLSquare);
        assertEquals(beginLSquare, instance.BeginLSquare());
    }



}