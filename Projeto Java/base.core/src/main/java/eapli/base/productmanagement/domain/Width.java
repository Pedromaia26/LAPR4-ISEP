package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Width implements ValueObject {

    private double width;

    public Width(double width){
        if (width < 0)
            throw new IllegalArgumentException("Width cannot be negative!");

        this.width = width;
    }


    public Width() {

    }

    public double width() {
        return width;
    }
}
