package eapli.base.ordermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TotalAmountWithoutTaxes implements ValueObject {
    private Double totalAmountWithoutTaxes;

    public TotalAmountWithoutTaxes(final Double totalAmountWithoutTaxes){

        if (totalAmountWithoutTaxes < 0)
            throw new IllegalArgumentException("Cost cannot be negative!");

        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
    }

    public TotalAmountWithoutTaxes() {

    }

    @Override
    public String toString(){

        return String.valueOf(totalAmountWithoutTaxes);
    }

    public Double totalAmountWithoutTaxes() {
        return totalAmountWithoutTaxes;
    }

    public void modifyTotalAmountWithoutTaxes(Double totalAmountWithoutTaxes) {
        this.totalAmountWithoutTaxes = totalAmountWithoutTaxes;
    }
}
