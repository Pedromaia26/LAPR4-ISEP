package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class TechnicalDescriptionTest {
    private static final String TECHNICAL_DESCRIPTION = "technical description";

    @Test(expected = IllegalArgumentException.class)
    public void ensureTechnicalDescriptionMustBeNotEmpty() {
        new TechnicalDescription("");
    }

    @Test
    public void ensureTechnicalDescriptionHasRightValue() {
        final TechnicalDescription instance = new TechnicalDescription(TECHNICAL_DESCRIPTION);
        assertEquals(TECHNICAL_DESCRIPTION, instance.toString());
    }
}