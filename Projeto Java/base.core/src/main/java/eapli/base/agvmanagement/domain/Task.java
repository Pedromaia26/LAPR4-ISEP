package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Task implements ValueObject {

    private String task;

    public Task(String task){

        if (task.isBlank() || task == null)
            throw new IllegalArgumentException("Task cannot be empty!");

        this.task = task;
    }


    public Task() {

    }
}
