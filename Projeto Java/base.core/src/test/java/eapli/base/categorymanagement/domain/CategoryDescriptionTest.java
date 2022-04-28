package eapli.base.categorymanagement.domain;

import eapli.base.agvmanagement.domain.AGVShortDescription;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryDescriptionTest {
    private static final String CATEGORY_DESCRIPTION = "description";

    @Test(expected = IllegalArgumentException.class)
    public void ensureCategoryDescriptionMustNotBeEmpty() {
        new CategoryDescription("");
    }

    @Test
    public void ensureCategoryDescriptionHasRightValue() {
        final CategoryDescription instance = new CategoryDescription(CATEGORY_DESCRIPTION);
        assertEquals(CATEGORY_DESCRIPTION, instance.Description());
    }
}