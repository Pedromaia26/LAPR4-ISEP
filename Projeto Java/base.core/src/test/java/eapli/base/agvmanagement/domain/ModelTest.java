package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    private static final String MODEL = "model";

    @Test(expected = IllegalArgumentException.class)
    public void ensureModelMustNotBeEmpty() {
        new Model("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureModelMustNotHaveLengthGreater50() {
        new Model("123456789123456789123456789123456789123456789123456");
    }

    @Test
    public void ensureModelHasRightValue() {
        final Model instance = new Model(MODEL);
        assertEquals(MODEL, instance.model());
    }
}