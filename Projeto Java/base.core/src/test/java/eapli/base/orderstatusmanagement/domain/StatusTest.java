package eapli.base.orderstatusmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {
    private static final String DESCRIPTION = "description";

    private Status StatusBuild() {
        return new StatusBuilder(DESCRIPTION).build();
    }

    @Test
    public void ensureStatusWithAllAttributes() {
        new Status(new Description(DESCRIPTION));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveDescription() {
        new Status(null);
    }

    @Test
    public void ensureCanChangeDescription() {
        final Status subject = StatusBuild();

        final Description newInfo = new Description("new description");

        subject.modifyDescription(newInfo);

        assertEquals(newInfo, subject.Description());
    }
}