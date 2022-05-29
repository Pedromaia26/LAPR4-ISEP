package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VerifyObligatorinessTest {

    private static final String OBLIGATORINESS1 = "mandatory";
    private static final String OBLIGATORINESS2 = "optional";
    private static final String OBLIGATORINESS3 = "condition dependent";

    @Test
    public void ensureObligatorinessCanBeEmpty() {
        VerifyObligatoriness obligatoriness = new VerifyObligatoriness("");
        assertNull(obligatoriness.obligatoriness);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureObligatorinessMustBeOneOfTheOption() {
        new VerifyObligatoriness("Invalid Obligatoriness Option");
    }

    @Test
    public void ensureObligatorinessHasRightValue() {
        final VerifyObligatoriness instance1 = new VerifyObligatoriness(OBLIGATORINESS1);
        final VerifyObligatoriness instance2 = new VerifyObligatoriness(OBLIGATORINESS2);
        final VerifyObligatoriness instance3 = new VerifyObligatoriness(OBLIGATORINESS3);
        assertEquals(OBLIGATORINESS1, instance1.obligatoriness);
        assertEquals(OBLIGATORINESS2, instance2.obligatoriness);
        assertEquals(OBLIGATORINESS3, instance3.obligatoriness);
    }

    @Test
    public void testToString() {
        final VerifyObligatoriness instance = new VerifyObligatoriness(OBLIGATORINESS1);
        String expected = "mandatory";

        assertEquals(expected, instance.toString());
    }

}