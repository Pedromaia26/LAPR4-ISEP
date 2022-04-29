package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class VerifyGender implements ValueObject {
    public String gender;

    public VerifyGender(String gender) {
        if(gender.isBlank()){
            this.gender=null;
        }
        else {
            if (!gender.equalsIgnoreCase(Gender.FEMALE.name()) && !gender.equalsIgnoreCase(Gender.MALE.name()) && !gender.equalsIgnoreCase(Gender.OTHER.name()))
                throw new IllegalArgumentException("Invalid Gender, 'male', 'female' or 'other'!");

            this.gender = gender;
        }
    }

    public VerifyGender() {

    }
}
