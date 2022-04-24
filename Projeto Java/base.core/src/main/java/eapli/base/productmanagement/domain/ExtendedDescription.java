package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class ExtendedDescription implements ValueObject {

    private String extendedDescription;


    public ExtendedDescription(final String extendedDescription){

        if (extendedDescription == null || extendedDescription.isBlank())
            throw new IllegalArgumentException("Extended description cannot be empty!");
        if (extendedDescription.length() < 20 || extendedDescription.length() > 100)
            throw new IllegalArgumentException("Extended description must have between 20 and 100 chars");

        this.extendedDescription = extendedDescription;

    }

    public ExtendedDescription() {

    }

    @Override
    public String toString(){

        return extendedDescription;
    }
}
