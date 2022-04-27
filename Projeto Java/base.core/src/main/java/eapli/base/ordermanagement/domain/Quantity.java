package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Quantity implements ValueObject {

    private int quantity;

    public Quantity(final int quantity){

        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative!");

        this.quantity = quantity;
    }

    public Quantity() {}

    @Override
    public String toString(){

        return String.valueOf(quantity);
    }

}
