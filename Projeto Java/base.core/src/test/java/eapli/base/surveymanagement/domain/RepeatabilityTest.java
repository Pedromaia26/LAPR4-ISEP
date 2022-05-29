package eapli.base.surveymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class RepeatabilityTest {

    private static final String REPEATABILITY = "Repeatability";

    @Test(expected = IllegalArgumentException.class)
    public void ensureRepeatabilityMustBeNotEmpty() {
        new Repeatability("");
    }

    @Test
    public void ensureRepeatabilityHasRightValue() {
        final Repeatability instance = new Repeatability(REPEATABILITY);
        assertEquals(REPEATABILITY, instance.toString());
    }

    @Test
    public void testEquals() {
        final Repeatability instance = new Repeatability(REPEATABILITY);
        String repeatability = "Repeatability";
        Repeatability instance2 = new Repeatability(repeatability);

        assertEquals(instance, instance2);
    }

    @Test
    public void testToString() {
        final QuestionText instance = new QuestionText(REPEATABILITY);
        String expected = "Repeatability";

        assertEquals(expected, instance.toString());
    }

}