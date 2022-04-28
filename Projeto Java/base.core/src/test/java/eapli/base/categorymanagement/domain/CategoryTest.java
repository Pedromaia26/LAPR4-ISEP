package eapli.base.categorymanagement.domain;

import eapli.base.agvmanagement.domain.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {
    private static final String CATEGORY_CODE = "abc123";
    private static final String CATEGORY_DESCRIPTION = "description";

    private Category CategoryBuild() {
        return new CategoryBuilder(CATEGORY_CODE, CATEGORY_DESCRIPTION).build();
    }

    @Test
    public void ensureCategoryWithAllAttributes() {
        new Category(new CategoryCode(CATEGORY_CODE), new CategoryDescription(CATEGORY_DESCRIPTION));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCategoryCode() {
        new Category(null, new CategoryDescription(CATEGORY_DESCRIPTION));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveCategoryDescription() {
        new Category(new CategoryCode(CATEGORY_CODE), null);
    }

    @Test
    public void ensureCanChangeCategoryDescription() {
        final Category subject = CategoryBuild();

        final CategoryDescription newInfo = new CategoryDescription("new description");

        subject.modifyCategoryDescription(newInfo);

        assertEquals(newInfo, subject.CategoryDescription());
    }
}