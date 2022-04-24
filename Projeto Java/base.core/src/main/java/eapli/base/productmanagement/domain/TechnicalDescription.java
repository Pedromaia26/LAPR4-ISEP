package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class TechnicalDescription implements ValueObject {


    private String technicalDescription;

    public TechnicalDescription(final String technicalDescription){

        if (technicalDescription == null || technicalDescription.isBlank())
            throw new IllegalArgumentException("Technical description cannot be null!");


        this.technicalDescription = technicalDescription;
    }

    public TechnicalDescription() {

    }

    @Override
    public String toString(){

        return technicalDescription;
    }
}
