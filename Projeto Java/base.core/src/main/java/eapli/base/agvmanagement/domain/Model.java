package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Model implements ValueObject {


    private String model;

    public Model(String model){

        if (model.isBlank() || model == null)
            throw new IllegalArgumentException("Model cannot be empty!");

        if (model.length() > 50)
            throw new IllegalArgumentException("Model must have at maximum 50 chars!");

        this.model = model;
    }


    public Model() {

    }

    public String model() {
        return model;
    }
}
