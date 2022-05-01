package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WidthTest {
    private static final double WIDTH = 10;

    @Test(expected = IllegalArgumentException.class)
    public void ensureWidthMustBePositive() {
        new Width(-1);
    }

    @Test
    public void ensureLengthHasRightValue() {
        final Width instance = new Width(WIDTH);
        assertEquals(String.valueOf(WIDTH), String.valueOf(instance.width()));
    }
}