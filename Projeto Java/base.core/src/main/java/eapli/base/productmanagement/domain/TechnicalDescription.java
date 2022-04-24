package eapli.base.productmanagement.domain;

import javax.persistence.Embeddable;

@Embeddable
public class TechnicalDescription {


    private String technicalDescription;

    public TechnicalDescription(final String technicalDescription){

        if (technicalDescription == null || technicalDescription.isBlank())
            throw new IllegalArgumentException("Technical description cannot be null!");


        this.technicalDescription = technicalDescription;
    }

    public TechnicalDescription() {

    }
}
