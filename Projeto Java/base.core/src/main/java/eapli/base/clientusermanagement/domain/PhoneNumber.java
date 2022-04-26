package eapli.base.clientusermanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class PhoneNumber implements ValueObject {
    private String phoneNumber;

    public PhoneNumber(String phoneNumber)  {
        final int max=13;
        //check if is numeric and has 12 numbers + "+"
        if (!phoneNumber.matches("[+][0-9]+"))  throw new IllegalArgumentException("Invalid Phone number, follow the pattern (eg. +351912345678)!");

        if(phoneNumber.length()!=max)throw new IllegalArgumentException("Invalid Phone number, follow the pattern (eg. +351912345678)!!");


        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber() {

    }
}
