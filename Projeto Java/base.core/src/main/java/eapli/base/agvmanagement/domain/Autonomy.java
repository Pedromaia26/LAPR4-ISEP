package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Autonomy implements ValueObject {

    private double autonomy;

    public Autonomy(double autonomy){

        if (autonomy < 0)
            throw new IllegalArgumentException("Autonomy of an AGV cannot be negative!");

        this.autonomy = autonomy;
    }


    public Autonomy() {

    }

    public double autonomy() {
        return autonomy;
    }
}
