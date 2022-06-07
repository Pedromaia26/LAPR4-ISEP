package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.Gender;

import javax.persistence.Embeddable;

@Embeddable
public class VerifyObligatoriness {

    public String obligatoriness;

    public VerifyObligatoriness(String obligatoriness) {
        if(obligatoriness.isBlank()){
            this.obligatoriness=null;
        }
        else {
            if (!obligatoriness.equalsIgnoreCase(Obligatoriness.MANDATORY.name()) && !obligatoriness.equalsIgnoreCase(Obligatoriness.OPTIONAL.name()) && !obligatoriness.equalsIgnoreCase("Condition dependent"))
                throw new IllegalArgumentException("Invalid obligatoriness!");

            this.obligatoriness = obligatoriness;
        }
    }

    public VerifyObligatoriness() {

    }

    public String obligatoriness() {
        return obligatoriness;
    }

    @Override
    public String toString() {
        return obligatoriness;
    }
}
