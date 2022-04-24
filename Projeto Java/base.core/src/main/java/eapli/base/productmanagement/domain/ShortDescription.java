package eapli.base.productmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class ShortDescription implements ValueObject {

    private String shortDescription;

    public ShortDescription(final String shortDescription){

        if (shortDescription == null || shortDescription.isBlank())
            throw new IllegalArgumentException("Short description cannot be empty!");
        if (shortDescription.length() > 30)
            throw new IllegalArgumentException("Exceeded short description maximum chars (30)");

        this.shortDescription = shortDescription;

    }

    public ShortDescription() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShortDescription)) return false;
        ShortDescription that = (ShortDescription) o;
        return Objects.equals(shortDescription, that.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDescription);
    }

    @Override
    public String toString(){

        return shortDescription;
    }
}
