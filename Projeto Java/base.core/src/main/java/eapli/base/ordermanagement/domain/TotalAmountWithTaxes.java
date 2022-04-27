package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TotalAmountWithTaxes implements ValueObject {
    private Double totalAmountWithTaxes;

    public TotalAmountWithTaxes(final Double totalAmountWithTaxes){

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

    public Double getTotalAmountWithTaxes() {
        return totalAmountWithTaxes;
    }

    public void setTotalAmountWithTaxes(Double totalAmountWithTaxes) {
        this.totalAmountWithTaxes = totalAmountWithTaxes;
    }
}
