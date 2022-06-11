package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgeTest {
    private static final int AGE = 25;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAgeMustBeGreater0() {
        new Age(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureAgeMustBeLess150() {
        new Age(151);
    }

    @Test
    public void ensureCostHasRightValue() {
        final Age instance = new Age(AGE);
        assertEquals(AGE, instance.age(), 0);
    }

    @Test
    public void testToString() {
        final String expected = "25";
        Age age = new Age(AGE);
        assertEquals(expected, age.toString());
    }
}