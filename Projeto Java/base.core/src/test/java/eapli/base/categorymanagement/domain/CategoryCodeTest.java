package eapli.base.categorymanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryCodeTest {
    private static final String ID = "123abc";

    @Test(expected = IllegalArgumentException.class)
    public void ensureCategoryCodeMustNotBeEmpty() {
        new CategoryCode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCategoryCodeMustNotHaveLengthLess2() {
        new CategoryCode("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCategoryCodeMustNotHaveLengthGreater23() {
        new CategoryCode("12345678912345678912345a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCategoryCodeMustNotBeNonAlphanumeric() {
        new CategoryCode("123abc-");
    }

    @Test
    public void ensureCategoryCodeHasRightValue() {
        final CategoryCode instance = new CategoryCode(ID);
        assertEquals(ID, instance.Code());
    }
}