package eapli.base.taskmanagement.domain;

import eapli.base.orderstatusmanagement.domain.StatusBuilder;
import eapli.base.productmanagement.domain.*;
import eapli.base.taskmanagement.domain.Task;
import eapli.framework.domain.model.DomainFactory;

public class TaskBuilder implements DomainFactory<Task> {

    private Task task;
    private Description description;

    public TaskBuilder(final String description){
        withDescription(description);
    }

    public TaskBuilder withDescription(final String description) {
        this.description = new Description(description);
        return this;
    }

    private Task buildOrThrow() {
        if (task != null) {
            return task;
        } else if (description != null) {
            task = new Task(description);
            return task;
        } else {
            throw new IllegalStateException();
        }
    }

    public Task build() {
        final Task ret = buildOrThrow();
        return ret;
    }
}
