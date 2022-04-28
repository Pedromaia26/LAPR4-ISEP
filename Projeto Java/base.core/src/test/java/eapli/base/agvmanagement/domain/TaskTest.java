package eapli.base.agvmanagement.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    private static final String TASK = "task";

    @Test(expected = IllegalArgumentException.class)
    public void ensureTaskMustNotBeEmpty() {
        new Task("");
    }

    @Test
    public void ensureTaskHasRightValue() {
        final Task instance = new Task(TASK);
        assertEquals(TASK, instance.task());
    }
}