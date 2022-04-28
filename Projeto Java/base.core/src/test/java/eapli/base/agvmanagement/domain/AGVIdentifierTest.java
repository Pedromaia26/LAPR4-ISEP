package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVIdentifierTest {
    private static final String ID = "1";

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVIdentifierMustNotBeEmpty() {
        new AGVIdentifier("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVIdentifierMustNotHaveLengthGreater8() {
        new AGVIdentifier("123456789");
    }

    @Test
    public void ensureAGVIdentifierHasRightValue() {
        final AGVIdentifier instance = new AGVIdentifier(ID);
        assertEquals(ID, instance.AgvIdentifier());
    }

}