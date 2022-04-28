package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class VolumeTest {
    private static final double VOLUME = 50d;

    @Test(expected = IllegalArgumentException.class)
    public void ensureVolumeMustBeGreater0() {
        new Volume(-1);
    }

    @Test
    public void ensureVolumeHasRightValue() {
        final Volume instance = new Volume(VOLUME);
        assertEquals(String.valueOf(VOLUME), String.valueOf(instance.volume()));
    }
}