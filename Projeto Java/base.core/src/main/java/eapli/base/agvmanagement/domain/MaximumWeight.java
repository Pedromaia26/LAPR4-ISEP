package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class MaximumWeight implements ValueObject {

    private double maximumWeight;

    public MaximumWeight(double maximumWeight){

        if (maximumWeight < 0)
            throw new IllegalArgumentException("The maximum weight a AGV can carry cannot be negative!");

        this.maximumWeight = maximumWeight;
    }


    public MaximumWeight() {

    }
}
