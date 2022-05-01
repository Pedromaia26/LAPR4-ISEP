package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductionCodeTest {
    private static final String PRODUCTION_CODE = "a.123";

    @Test(expected = IllegalArgumentException.class)
    public void ensureProductionCodeMustBePattern() {
        new ProductionCode("a-a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureProductionCodeMustBeNotEmpty() {
        new ProductionCode("");
    }

    @Test
    public void ensureProductionCodeHasRightValue() {
        final ProductionCode instance = new ProductionCode(PRODUCTION_CODE);
        assertEquals(PRODUCTION_CODE, instance.toString());
    }
}