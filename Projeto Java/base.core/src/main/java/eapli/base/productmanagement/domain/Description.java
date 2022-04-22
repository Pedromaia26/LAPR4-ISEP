package eapli.base.productmanagement.domain;

import java.util.Objects;

public class Description {

    private String shortDescription, extendedDescription, technicalDescription;

    public Description(final String shortDescription, final String extendedDescription, final String technicalDescription){

        if (shortDescription.isEmpty())
            throw new IllegalArgumentException("Short description cannot be empty!");
        if (shortDescription.length() > 30)
            throw new IllegalArgumentException("Exceeded short description maximum chars (30)");
        if (extendedDescription.isEmpty())
            throw new IllegalArgumentException("Extended description cannot be empty!");
        if (extendedDescription.length() < 20 || extendedDescription.length() > 100)
            throw new IllegalArgumentException("Extended description must have between 20 and 100 chars");
        if (technicalDescription.isEmpty())
            throw new IllegalArgumentException("Technical description cannot be null!");

        this.extendedDescription = extendedDescription;
        this.shortDescription = shortDescription;
        this.technicalDescription = technicalDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;
        Description that = (Description) o;
        return Objects.equals(shortDescription, that.shortDescription) && Objects.equals(extendedDescription, that.extendedDescription) && Objects.equals(technicalDescription, that.technicalDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDescription, extendedDescription, technicalDescription);
    }
}
