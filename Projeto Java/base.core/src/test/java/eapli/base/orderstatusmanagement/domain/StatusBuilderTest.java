package eapli.base.orderstatusmanagement.domain;

import eapli.base.categorymanagement.domain.Category;
import eapli.base.categorymanagement.domain.CategoryBuilder;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusBuilderTest {
    private static final String DESCRIPTION = "description";

    private Status buildStatus() {
        return new StatusBuilder(DESCRIPTION).build();
    }

    @Test
    public void ensureCanBuildStatusWithAllAttributes() {
        final Status subject = new StatusBuilder(DESCRIPTION).build();
        assertNotNull(subject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureCannotBuildWithNullDescription() {
        new StatusBuilder(null).build();
    }
}