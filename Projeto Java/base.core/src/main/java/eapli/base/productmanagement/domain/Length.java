package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Length implements ValueObject {

    private double length;

    public Length(double length){
        if (length < 0)
            throw new IllegalArgumentException("Length cannot be negative!");

        this.length = length;
    }


    public Length() {

    }

    public double length() {
        return length;
    }
}
