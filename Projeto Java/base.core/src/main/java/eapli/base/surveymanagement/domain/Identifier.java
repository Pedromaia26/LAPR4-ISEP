package eapli.base.surveymanagement.domain;

import eapli.base.clientusermanagement.domain.VAT;

import java.util.Objects;

public class Identifier {

    private String identifier;

    public Identifier(String identifier) {

        if(identifier.length() == 0) throw new IllegalArgumentException("Invalid Identifier, should not be empty!");

        this.identifier = identifier;
    }

    public Identifier() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier identifier1 = (Identifier) o;
        return identifier.equals(identifier1.identifier);
    }

    @Override
    public String toString() {
        return identifier;
    }
}
