package eapli.base.productmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class BrandTest {
    private static final String BRAND = "brand";

    @Test(expected = IllegalArgumentException.class)
    public void ensureBrandMustBeLess50() {
        new Brand("123456789123456789123456789123456789123456789123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureBrandMustBeNotEmpty() {
        new Brand("");
    }

    @Test
    public void ensureBrandHasRightValue() {
        final Brand instance = new Brand(BRAND);
        assertEquals(BRAND, instance.toString());
    }
}