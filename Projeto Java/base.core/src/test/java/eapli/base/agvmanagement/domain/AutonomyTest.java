package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class AutonomyTest {
    private static final double AUTONOMY = 120d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureAutonomyMustBeGreater0() {
        new Autonomy(-1);
    }

    @Test
    public void ensureAutonomyHasRightValue() {
        final Autonomy instance = new Autonomy(AUTONOMY);
        assertEquals(String.valueOf(AUTONOMY), String.valueOf(instance.autonomy()));
    }
}