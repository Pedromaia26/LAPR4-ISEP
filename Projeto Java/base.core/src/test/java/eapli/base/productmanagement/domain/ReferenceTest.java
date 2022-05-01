package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReferenceTest {
    private static final String REFERENCE = "abcd12345";

    @Test(expected = IllegalArgumentException.class)
    public void ensureReferenceMustBePattern() {
        new Reference("a-a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureReferenceMustBeNotEmpty() {
        new Reference("");
    }

    @Test
    public void ensureReferenceHasRightValue() {
        final Reference instance = new Reference(REFERENCE);
        assertEquals(REFERENCE, instance.toString());
    }
}