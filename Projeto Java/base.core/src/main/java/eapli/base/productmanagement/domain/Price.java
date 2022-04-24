package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Price implements ValueObject {

    private double price;

    public Price(final double price){

        if (price < 0)
            throw new IllegalArgumentException("Price cannot be negative!");

        this.price = price;
    }

    public Price() {

    }
}
