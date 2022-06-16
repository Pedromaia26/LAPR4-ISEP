package eapli.base.taskmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Description implements ValueObject {
    private String description;

    public Description(final String description){

        if (description == null || description.isBlank())
            throw new IllegalArgumentException("Description cannot be null!");

        this.description = description;
    }

    public Description() {

    }

    @Override
    public String toString(){

        return description;
    }

    public String Description() {
        return description;
    }
}
