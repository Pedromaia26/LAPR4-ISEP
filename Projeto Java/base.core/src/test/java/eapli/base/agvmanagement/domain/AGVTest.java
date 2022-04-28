package eapli.base.agvmanagement.domain;

import eapli.base.productmanagement.domain.ShortDescription;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.general.domain.model.Money;
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
        return new AGVBuilder(AGV_IDENTIFIER, SHORT_DESCRIPTION, AUTONOMY, MAXIMUM_WEIGHT, MODEL, TASK, VOLUME).build();
    }

    @Test
    public void ensureAGVWithAllAttributes() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(TASK), new Volume(VOLUME));
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAGVIdentifier() {
        new AGV(null, new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(TASK), new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAGVDescription() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), null
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(TASK), new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveAutonomy() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , null, new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(TASK), new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveMaximumHeight() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), null, new Model(MODEL)
                , new Task(TASK), new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveModel() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), null
                , new Task(TASK), new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveTask() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , null, new Volume(VOLUME));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureMustHaveVolume() {
        new AGV(new AGVIdentifier(AGV_IDENTIFIER), new AGVShortDescription(SHORT_DESCRIPTION)
                , new Autonomy(AUTONOMY), new MaximumWeight(MAXIMUM_WEIGHT), new Model(MODEL)
                , new Task(TASK), null);
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
        final AGV subject = AGVBuild();

        final Task newInfo = new Task("task2");

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

}