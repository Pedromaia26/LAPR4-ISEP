package eapli.base.agvmanagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class AGVIdentifier implements ValueObject, Comparable<AGVIdentifier> {


    private String agvIdentifier;

    public AGVIdentifier(String agvIdentifier){

        if (agvIdentifier.isBlank() || agvIdentifier == null)
            throw new IllegalArgumentException("AGV Identifier cannot be empty!");

        if (agvIdentifier.length() > 8)
            throw new IllegalArgumentException("AGV Identifier cannot have more than 8 chars!");

        this.agvIdentifier = agvIdentifier;
    }


    public AGVIdentifier() {

    }

    @Override
    public int compareTo(AGVIdentifier o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AGVIdentifier that = (AGVIdentifier) o;
        return agvIdentifier.equals(that.agvIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(agvIdentifier);
    }
}
