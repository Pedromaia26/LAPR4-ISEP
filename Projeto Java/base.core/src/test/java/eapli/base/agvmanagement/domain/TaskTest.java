package eapli.base.agvmanagement.domain;

import eapli.base.taskmanagement.domain.Description;
import eapli.base.taskmanagement.domain.Task;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private static final String TASK = "task";

    @Test(expected = IllegalArgumentException.class)
    public void ensureTaskMustNotBeEmpty() {
        new Task(null);
    }

    @Test
    public void ensureTaskHasRightValue() {
        Description description = new Description(TASK);
        final Task instance = new Task(description);
        assertEquals(TASK, instance.description());
    }
}