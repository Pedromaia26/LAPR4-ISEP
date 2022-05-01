package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LengthTest {
    private static final double LENGTH = 10;

    @Test(expected = IllegalArgumentException.class)
    public void ensureLengthMustBePositive() {
        new Length(-1);
    }

    @Test
    public void ensureLengthHasRightValue() {
        final Length instance = new Length(LENGTH);
        assertEquals(String.valueOf(LENGTH), String.valueOf(instance.length()));
    }
}