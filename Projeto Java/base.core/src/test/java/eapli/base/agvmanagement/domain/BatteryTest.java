package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BatteryTest {

    private static final double BATTERY = 120d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureBatteryMustBeGreaterThan0() {
        new Battery(-1);
    }

    @Test
    public void ensureAutonomyHasRightValue() {
        final Battery instance = new Battery(BATTERY);
        assertEquals(String.valueOf(BATTERY), String.valueOf(instance.battery()));
    }

}