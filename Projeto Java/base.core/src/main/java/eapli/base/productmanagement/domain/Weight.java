package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Weight implements ValueObject {

    private double weight;

    public Weight(double weight){
        if (weight < 0)
            throw new IllegalArgumentException("Weight cannot be negative!");

        this.weight = weight;
    }


    public Weight() {

    }

    public double weight() {
        return weight;
    }
}
