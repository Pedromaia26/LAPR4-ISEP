package eapli.base.clientusermanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VATTest {
    private static final String VAT = "123456789";

    @Test(expected = IllegalArgumentException.class)
    public void ensureVATCodeMustNotBeEmpty() {
        new VAT("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureVATCodeMustNotHaveLengthGreater9() {
        new VAT("1234567890");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureVATCodeMustNotBeNonNumeric() {
        new VAT("123a");
    }

    @Test
    public void ensureVATCodeHasRightValue() {
        final VAT instance = new VAT(VAT);
        assertEquals(VAT, instance.vat());
    }
}