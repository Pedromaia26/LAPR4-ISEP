package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class Barcode implements ValueObject {

    private String barcode;

    public Barcode (final String barcode){
        if (barcode == null || barcode.isBlank())
            throw new IllegalArgumentException("Barcode cannot be empty");
        if (barcode.length() != 13)
            throw new IllegalArgumentException("Barcode must have 13 chars!");

        this.barcode = barcode;
    }

    public Barcode() {

    }
}
