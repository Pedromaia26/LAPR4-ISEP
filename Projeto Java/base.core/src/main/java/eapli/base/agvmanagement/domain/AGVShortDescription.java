package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AGVShortDescription implements ValueObject {

    private String shortDescription;

    public AGVShortDescription (String shortDescription){

        if (shortDescription.isBlank() || shortDescription == null)
            throw new IllegalArgumentException("Short description cannot be empty!");

        if (shortDescription.length() > 30)
            throw new IllegalArgumentException("Short description must have at maximum 30 chars!");

        this.shortDescription = shortDescription;
    }

    public AGVShortDescription() {

    }

    public String ShortDescription() {
        return shortDescription;
    }
}
