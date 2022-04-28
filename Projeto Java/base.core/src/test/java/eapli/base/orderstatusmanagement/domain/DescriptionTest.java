package eapli.base.orderstatusmanagement.domain;

import eapli.base.categorymanagement.domain.CategoryDescription;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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