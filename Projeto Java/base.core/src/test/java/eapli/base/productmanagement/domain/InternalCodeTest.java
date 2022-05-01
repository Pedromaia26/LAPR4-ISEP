package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class InternalCodeTest {
    private static final String INTERNAL_CODE = "abcd.12345";

    @Test(expected = IllegalArgumentException.class)
    public void ensureInternalCodeMustBePattern() {
        new Barcode("aaaaaaaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureInternalCodeMustBeNotEmpty() {
        new InternalCode("");
    }

    @Test
    public void ensureInternalCodeHasRightValue() {
        final InternalCode instance = new InternalCode(INTERNAL_CODE);
        assertEquals(INTERNAL_CODE, instance.toString());
    }
}