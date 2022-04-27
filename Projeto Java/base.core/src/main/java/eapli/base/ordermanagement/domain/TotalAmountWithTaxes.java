package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TotalAmountWithTaxes implements ValueObject {
    private double totalAmountWithTaxes;

    public TotalAmountWithTaxes(final double totalAmountWithTaxes){

        if (totalAmountWithTaxes < 0)
            throw new IllegalArgumentException("Cost cannot be negative!");

        this.totalAmountWithTaxes = totalAmountWithTaxes;
    }

    public TotalAmountWithTaxes() {

    }

    @Override
    public String toString(){

        return String.valueOf(totalAmountWithTaxes);
    }
}
