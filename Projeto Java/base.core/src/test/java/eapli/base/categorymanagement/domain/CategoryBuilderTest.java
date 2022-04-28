package eapli.base.categorymanagement.domain;

import eapli.base.agvmanagement.domain.AGV;
import eapli.base.agvmanagement.domain.AGVBuilder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryBuilderTest {
    private static final String CATEGORY_CODE = "abc123";
    private static final String CATEGORY_DESCRIPTION = "description";

    private Category buildCategory() {
        return new CategoryBuilder(CATEGORY_CODE, CATEGORY_DESCRIPTION).build();
    }

    @Test
    public void ensureCanBuildCategoryWithAllAttributes() {
        final Category subject = new CategoryBuilder(CATEGORY_CODE, CATEGORY_DESCRIPTION).build();
        assertNotNull(subject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotBuildWithNullCategoryCode() {
        new CategoryBuilder(null, CATEGORY_DESCRIPTION).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotBuildWithNullCategoryDescription() {
        new CategoryBuilder(CATEGORY_CODE, null).build();
    }
}