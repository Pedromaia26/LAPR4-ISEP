package eapli.base.Warehouse.domain;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;

@Embeddable

public class AisleEndLSquare implements ValueObject {
    private long endLSquare;

    public AisleEndLSquare(long endLSquare) {
        if(endLSquare<0)throw new IllegalArgumentException("Aisle EndLSquare < 0!");

        this.endLSquare = endLSquare;
    }

    public AisleEndLSquare() {

    }

    public long EndLSquare() {
        return endLSquare;
    }
}
