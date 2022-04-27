package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Volume implements ValueObject {

    private double volume;

    public Volume(double volume){

        if (volume < 0)
            throw new IllegalArgumentException("The volume an AGV can carry cannot be negative");

        this.volume = volume;
    }


    public Volume() {

    }
}
