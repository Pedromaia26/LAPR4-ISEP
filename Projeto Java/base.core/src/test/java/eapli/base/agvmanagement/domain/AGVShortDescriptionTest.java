package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AGVShortDescriptionTest {
    private static final String SHORT_DESCRIPTION = "description";

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVShortDescriptionMustNotBeEmpty() {
        new AGVShortDescription("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAGVShortDescriptionMustNotHaveLengthGreater30() {
        new AGVShortDescription("1234567891234567891234567891234");
    }

    @Test
    public void ensureAGVShortDescriptionHasRightValue() {
        final AGVShortDescription instance = new AGVShortDescription(SHORT_DESCRIPTION);
        assertEquals(SHORT_DESCRIPTION, instance.ShortDescription());
    }
}