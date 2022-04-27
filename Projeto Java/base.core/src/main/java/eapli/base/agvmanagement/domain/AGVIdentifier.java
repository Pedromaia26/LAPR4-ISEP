package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class AGVIdentifier implements ValueObject, Comparable<AGVIdentifier> {


    private String agvIdentifer;

    public AGVIdentifier(String agvIdentifier){

        if (agvIdentifier.isBlank() || agvIdentifier == null)
            throw new IllegalArgumentException("AGV Identifier cannot be empty!");

        if (agvIdentifier.length() > 8)
            throw new IllegalArgumentException("AGV Identifier cannot have more than 8 chars!");

        this.agvIdentifer = agvIdentifier;
    }


    public AGVIdentifier() {

    }
}
