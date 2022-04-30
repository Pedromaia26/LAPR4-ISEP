package eapli.base.orderstatusmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DescriptionTest {
    private static final String DESCRIPTION = "description";

    @Test(expected = IllegalArgumentException.class)
    public void ensureDescriptionMustNotBeEmpty() {
        new Description("");
    }

    @Test
    public void ensureDescriptionHasRightValue() {
        final Description instance = new Description(DESCRIPTION);
        assertEquals(DESCRIPTION, instance.description());
    }
}