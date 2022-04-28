package eapli.base.agvmanagement.domain;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AGVBuilderTest {

    private static final String AGV_IDENTIFIER = "abc123";
    private static final String SHORT_DESCRIPTION = "description";
    private static final String MODEL = "model";
    private static final String TASK = "task";
    private static final double AUTONOMY = 120d;
    private static final double MAXIMUM_WEIGHT = 500d;
    private static final double VOLUME = 100d;

    private AGV buildAGV() {
        return new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, TASK, VOLUME).build();
    }

    @Test
    public void ensureCanBuildAGVWithAllAttributes() {
        final AGV subject = new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, TASK, VOLUME).build();
        assertNotNull(subject);
    }

    @Test(expected = NullPointerException.class)
    public void ensureCannotBuildAGVWithNullAGVIdentifier() {
        new AGVBuilder(null, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, TASK, VOLUME).build();
    }

    @Test(expected = NullPointerException.class)
    public void ensureCannotBuildAGVWithNullAGVShortDescription() {
        new AGVBuilder(AGV_IDENTIFIER, null, AUTONOMY, MAXIMUM_WEIGHT, MODEL, TASK, VOLUME).build();
    }

    @Test(expected = NullPointerException.class)
    public void ensureCannotBuildAGVWithNullModel() {
        new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, null, TASK, VOLUME).build();
    }

    @Test(expected = NullPointerException.class)
    public void ensureCannotBuildAGVWithNullTask() {
        new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, null, VOLUME).build();
    }
}