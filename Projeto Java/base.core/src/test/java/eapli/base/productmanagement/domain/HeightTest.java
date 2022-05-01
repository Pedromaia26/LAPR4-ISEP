package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeightTest {
    private static final double HEIGHT = 100;

    @Test(expected = IllegalArgumentException.class)
    public void ensureHeightMustBePositive() {
        new Height(-1);
    }

    @Test
    public void ensureHeightHasRightValue() {
        final Height instance = new Height(HEIGHT);
        assertEquals(String.valueOf(HEIGHT), String.valueOf(instance.height()));
    }
}