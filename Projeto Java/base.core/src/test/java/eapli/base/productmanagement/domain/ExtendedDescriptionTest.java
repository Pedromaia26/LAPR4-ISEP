package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExtendedDescriptionTest {
    private static final String EXTENDED_DESCRIPTION = "descricao extensa teste para 20 cararcteres";

    @Test(expected = IllegalArgumentException.class)
    public void ensureExtendedDescriptionMustNotBeLess20() {
        new ExtendedDescription("12345678912345");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureExtendedDescriptionMustNotBeGreater100() {
        new ExtendedDescription("123456789123456789123456789123456789123456789123456123456789123456789123456789123456789123456789123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureExtendedDescriptionMustBeNotEmpty() {
        new ExtendedDescription("");
    }

    @Test
    public void ensureExtendedDescriptionHasRightValue() {
        final ExtendedDescription instance = new ExtendedDescription(EXTENDED_DESCRIPTION);
        assertEquals(EXTENDED_DESCRIPTION, instance.toString());
    }
}