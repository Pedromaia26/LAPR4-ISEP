package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Height implements ValueObject {

    private double height;

    public Height(double height){
        if (height < 0)
            throw new IllegalArgumentException("Height cannot be negative!");

        this.height = height;
    }


    public Height() {

    }

    public double height() {
        return height;
    }
}
