package eapli.base.Warehouse.domain;

import eapli.base.agvmanagement.domain.AGVIdentifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVDockIdentifierTest {
    private static final String ID = "1";

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVDockIdentifierMustNotBeEmpty() {
        new AGVDockIdentifier("");
    }



    @Test
    public void ensureAGVDockIdentifierHasRightValue() {
        final AGVDockIdentifier instance1 = new AGVDockIdentifier();
        final AGVDockIdentifier instance = new AGVDockIdentifier(ID);
        assertEquals(ID, instance.Id());
    }
}