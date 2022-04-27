package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleIdentifier implements ValueObject, Comparable<AisleIdentifier> {

    private long id;

    public AisleIdentifier(long id) {
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
}
