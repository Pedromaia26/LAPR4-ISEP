package eapli.base.Warehouse.domain;

import eapli.base.agvmanagement.domain.AGVIdentifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AisleIdentifierTest {
    private static final long ID = 1;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAisleIdentifierMustNotBenegative() {
        new AisleIdentifier(-5);
    }

    @Test
    public void ensureAisleIdentifierHasRightValue() {
        final AisleIdentifier instance1 = new AisleIdentifier();
        final AisleIdentifier instance = new AisleIdentifier(ID);
        assertEquals(ID, instance.Id());
    }
}