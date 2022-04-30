package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable

public class AisleIdentifier implements ValueObject, Comparable<AisleIdentifier> {

    private long id;

    public AisleIdentifier(long id) {
        if(id<0)throw new IllegalArgumentException("Aisle id < 0!");

        this.id = id;
    }

    public AisleIdentifier() {

    }

    @Override
    public int compareTo(AisleIdentifier o) {
        if(id>o.id)return 1;
        else if (id<o.id)return -1;
        else return 0;

    }

    public long Id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AisleIdentifier that = (AisleIdentifier) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
