package eapli.base.surveymanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Age implements ValueObject {

    @Column(insertable = false, updatable = false)
    private int age;

    public Age(final int age){

        if (age < 0)
            throw new IllegalArgumentException("Price cannot be negative!");
        else if (age > 150)
            throw new IllegalArgumentException("Price cannot be greater than 150!");

        this.age = age;
    }

    public Age() {

    }

    @Override
    public String toString(){

        return String.valueOf(age);
    }

    public int age() {
        return age;
    }
}
