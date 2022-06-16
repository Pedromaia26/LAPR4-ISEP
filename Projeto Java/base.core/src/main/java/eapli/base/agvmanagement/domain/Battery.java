package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Battery implements ValueObject {

    private double battery;

    public Battery(double battery){

        if (battery < 0)
            throw new IllegalArgumentException("Battery of an AGV cannot be negative!");

        this.battery = battery;
    }


    public Battery() {

    }

    public double battery() {
        return battery;
    }

}
