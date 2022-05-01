package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortDescriptionTest {
    private static final String SHORT_DESCRIPTION = "short description";

    @Test(expected = IllegalArgumentException.class)
    public void ensureShortDescriptionMustBeLess30() {
        new ShortDescription("1234567891234567891234567891231");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureShortDescriptionMustBeNotEmpty() {
        new ShortDescription("");
    }

    @Test
    public void ensureShortDescriptionHasRightValue() {
        final ShortDescription instance = new ShortDescription(SHORT_DESCRIPTION);
        assertEquals(SHORT_DESCRIPTION, instance.toString());
    }
}