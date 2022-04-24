package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Brand implements ValueObject, Comparable<Brand> {


    private String brand;

    public Brand(final String brand) {

        if (brand == null || brand.isBlank())
            throw new IllegalArgumentException("Brand name cannot be empty!");
        if (brand.length() > 50)
            throw new IllegalArgumentException("Brand name cannot have more than 50 chars!");

        this.brand = brand;
    }

    public Brand() {
        
    }

    @Override
    public int compareTo(Brand o) {
        return 0;
    }
}
