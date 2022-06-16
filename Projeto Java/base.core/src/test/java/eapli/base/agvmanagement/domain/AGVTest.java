package eapli.base.agvmanagement.domain;

import eapli.base.Warehouse.domain.AGVDock;
import eapli.base.productmanagement.domain.Product;
import eapli.base.taskmanagement.domain.Description;
import eapli.base.taskmanagement.domain.Task;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class AGVTest {
    private static final String AGV_IDENTIFIER = "abc123";
    private static final String SHORT_DESCRIPTION = "description";
    private static final String MODEL = "model";
    private static final String TASK = "task";
    private static final double AUTONOMY = 120d;
    private static final double MAXIMUM_WEIGHT = 500d;
    private static final double VOLUME = 100d;

    private AGV AGVBuild() {
        Description description = new Description(TASK);
        Task task = new Task(description);
        AGVDock agvDock = new AGVDock();
        return new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, task, VOLUME, agvDock).build();
    }

    @Test
    public void ensureAGVWithAllAttributes() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAGVIdentifier() {
        Description description = new Description(TASK);
        new AGV(null, new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAGVDescription() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), null
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAutonomy() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , null, new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveMaximumHeight() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), null, new Model(MODEL)
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveModel() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), null
                , new Task(description), new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveTask() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , null, new Volume(VOLUME), new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveVolume() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), null, new AGVDock(), new Battery());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAGVDock() {
        Description description = new Description(TASK);
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(description), new Volume(VOLUME), null, new Battery());
    }


    @Test
    public void ensureCanChangeShortDescription() {
        final AGV subject = AGVBuild();

        final AGVShortDescription newInfo = new AGVShortDescription("short description");

        subject.modifyAgvShortDescription(newInfo);

        assertEquals(newInfo, subject.AgvShortDescription());
    }

    @Test
    public void ensureCanChangeAutonomy() {
        final AGV subject = AGVBuild();

        final Autonomy newInfo = new Autonomy(150d);

        subject.modifyAutonomy(newInfo);

        assertEquals(newInfo, subject.Autonomy());
    }

    @Test
    public void ensureCanChangeMaximumWeight() {
        final AGV subject = AGVBuild();

        final MaximumWeight newInfo = new MaximumWeight(300d);

        subject.modifyMaximumWeight(newInfo);

        assertEquals(newInfo, subject.MaximumWeight());
    }

    @Test
    public void ensureCanChangeModel() {
        final AGV subject = AGVBuild();

        final Model newInfo = new Model("model2");

        subject.modifyModel(newInfo);

        assertEquals(newInfo, subject.Model());
    }

    @Test
    public void ensureCanChangeTask() {
        Description description = new Description("task2");

        final AGV subject = AGVBuild();

        final Task newInfo = new Task(description);

        subject.modifyTask(newInfo);

        assertEquals(newInfo, subject.Task());
    }

    @Test
    public void ensureCanChangeVolume() {
        final AGV subject = AGVBuild();

        final Volume newInfo = new Volume(200d);

        subject.modifyVolume(newInfo);

        assertEquals(newInfo, subject.Volume());
    }

    @Test
    public void ensureAGVEqualsFailsForDifferenteAGVIdentifier() {

        final AGV AGV1 = AGVBuild();

        Description description = new Description(TASK);
        Task task = new Task(description);
        AGVDock agvDock = new AGVDock();

        final AGV AGV2 = new AGVBuilder("aaa111", SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, task, VOLUME, agvDock).build();

        final boolean expected = AGV1.equals(AGV2);

        assertFalse(expected);
    }

    @Test
    public void ensureAGVEqualsAreTheSameForTheSameInstance() {
        final AGV AGV1 = AGVBuild();

        final boolean expected = AGV1.equals(AGV1);

        assertTrue(expected);
    }

    @Test
    public void ensureAGVEqualsFailsForDifferenteObjectTypes() {

        final AGV AGV1 = AGVBuild();

        final boolean expected = AGV1.equals(new Product());

        assertFalse(expected);
    }

    @Test
    public void ensureAGVIsTheSameAsItsInstance() {

        final AGV AGV1 = AGVBuild();

        final boolean expected = AGV1.sameAs(AGV1);

        assertTrue(expected);
    }

    @Test
    public void ensureTwoAGVWithDifferentAGVIdentifierAreNotTheSame() {
        final AGV AGV1 = AGVBuild();

        Description description = new Description(TASK);
        Task task = new Task(description);
        AGVDock agvDock = new AGVDock();

        final AGV AGV2 = new AGVBuilder("aaa111", SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, task, VOLUME, agvDock).build();

        final boolean expected = AGV1.sameAs(AGV2);

        assertFalse(expected);
    }
}